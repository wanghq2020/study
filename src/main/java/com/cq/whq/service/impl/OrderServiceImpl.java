package com.cq.whq.service.impl;

import com.cq.whq.common.Response;
import com.cq.whq.common.ResponseEnums;
import com.cq.whq.dao.DeilveryDao;
import com.cq.whq.dao.OrderDetailDao;
import com.cq.whq.model.DeilveryModel;
import com.cq.whq.model.OrderDetailModel;
import com.cq.whq.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 21:13
 */
@Service
public class OrderServiceImpl implements OrderService {
    Logger logger=LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    DeilveryDao deilveryDao;

    @Override
    @Transactional
    public Response splitOrder(Long orderDetailId, BigDecimal deilveryQuantity) {
        if(deilveryQuantity.compareTo(new BigDecimal(0))<=0){
            return Response.error(ResponseEnums.Request_Invalid);
        }
        //查询子订单信息
        OrderDetailModel orderdetail=orderDetailDao.queryByOrderId(orderDetailId);
        if(orderdetail==null){
            return Response.error(ResponseEnums.Not_Found_Data);
        }
        //根据订单查询是否有已拆分的发货单(默认只能一种商品拆分)
        List<DeilveryModel> list=deilveryDao.queryByOrderId(orderDetailId,orderdetail.getVersion());

        //判断待发货量是否满足拆分量
        if(orderdetail.getRemainingQuantity().compareTo(deilveryQuantity)<=0){
            return Response.error(ResponseEnums.NOT_SPLIT_ORDER);
        }

        //拆单
        //添加一条发货信息
        DeilveryModel dm=new DeilveryModel();
        dm.setDeilveryQuantity(deilveryQuantity);
        dm.setOrderDetailId(orderDetailId);
        dm.setOrderId(orderdetail.getOrderId());
        dm.setVersion(orderdetail.getVersion());
        deilveryDao.insert(dm);
        //修改待发货量
        orderdetail.setRemainingQuantity(orderdetail.getRemainingQuantity().subtract(deilveryQuantity));
        orderDetailDao.update(orderdetail);

        return Response.success();
    }


    @Override
    @Transactional
    public Response changeOrderQuantity(Long orderDetialId,BigDecimal orderQuantity) {
        if(orderQuantity.compareTo(new BigDecimal(0))<1){
            return Response.error(ResponseEnums.Request_Param_Invalid);
        }
        //查询订单详情信息
        OrderDetailModel order=orderDetailDao.queryByOrderId(orderDetialId);
        //查询所有订单当前版本发货信息
        List<DeilveryModel> list=deilveryDao.queryByOrderId(orderDetialId,order.getVersion());
        //计算当前修改比例
        BigDecimal ratio=orderQuantity.divide(order.getOrderQuantity());

        BigDecimal totalQuantity=new BigDecimal(0);
        //等比例修改发货量
        if(list!=null && list.size()>0){
            for(int i=0;i<list.size();i++){
                DeilveryModel deil=list.get(i);
                if(deil.getIsDeilvery()!=1){
                    //未发货
                    deil.setDeilveryQuantity(deil.getDeilveryQuantity().multiply(ratio));
                    deilveryDao.updateQuantity(deil);
                }
                totalQuantity=totalQuantity.add(deil.getDeilveryQuantity());
            }
        }
        //修改订单表总数和剩余数量
        order.setOrderQuantity(orderQuantity);
        order.setRemainingQuantity(order.getOrderQuantity().subtract(totalQuantity));
        orderDetailDao.update(order);
        return Response.success();

    }
}
