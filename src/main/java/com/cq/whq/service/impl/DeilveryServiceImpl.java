package com.cq.whq.service.impl;

import com.cq.whq.common.Response;
import com.cq.whq.common.ResponseEnums;
import com.cq.whq.dao.DeilveryDao;
import com.cq.whq.dao.OrderDetailDao;
import com.cq.whq.model.DeilveryModel;
import com.cq.whq.model.OrderDetailModel;
import com.cq.whq.service.DeilveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 22:27
 */
@Service
public class DeilveryServiceImpl implements DeilveryService {

    @Autowired
    DeilveryDao deilveryDao;

    @Autowired
    OrderDetailDao orderDetailDao;


    @Override
    @Transactional
    public Response mergeOrder(Long orderDetailId,String orderDeilveryIds) {

        String[] deilveryIds=orderDeilveryIds.split(",");

        BigDecimal totalDeilQuantity=new BigDecimal(0);

        //查询当前合并订单信息
        OrderDetailModel order=orderDetailDao.queryByOrderId(orderDetailId);

        //查询当前订单当前版本发货信息
        List<DeilveryModel> list=deilveryDao.queryByOrderId(order.getId(),order.getVersion());

        //查询相关的发货信息
        for(int i=0;i<deilveryIds.length;i++){
            Long deilveryId=Long.valueOf(deilveryIds[i]);
            DeilveryModel del=deilveryDao.queryById(deilveryId);
            if(del==null ){
                //没有相关数据不能进行合并
                return Response.error(ResponseEnums.Not_Found_Data);
            }
            if(del.getIsDeilvery()==1){
                //已发货订单不能进行合并
                return Response.error(ResponseEnums.Not_Found_Data);
            }
            if(order.getVersion()!=del.getVersion()){
                //版本号对不上不能进行合并
                return Response.error(ResponseEnums.Not_Found_Data);
            }
            //排除当前版本需合并订单
            for(int j=0;j<list.size();j++){
                DeilveryModel delv=list.get(j);
                if(del.getId()==delv.getId()){
                    list.remove(j);
                }
            }
            totalDeilQuantity=totalDeilQuantity.add(del.getDeilveryQuantity());
        }
        //插入最新版本的发货单
        DeilveryModel deilvery=new DeilveryModel();
        deilvery.setVersion(order.getVersion()+1);
        deilvery.setOrderId(order.getOrderId());
        deilvery.setOrderDetailId(order.getId());
        deilvery.setDeilveryQuantity(totalDeilQuantity);
        deilveryDao.insert(deilvery);
        //更新没有合并的版本号
        for(int a=0;a<list.size();a++){
            DeilveryModel d=list.get(a);
            d.setVersion(order.getVersion()+1);
            deilveryDao.updateVersion(d);
        }
        //更新订单版本号
        order.setVersion(order.getVersion()+1);
        orderDetailDao.update(order);

        return Response.success();
    }
}
