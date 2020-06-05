package com.cq.whq.dao;

import com.cq.whq.model.OrderDetailModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 21:26
 */
@Mapper
public interface OrderDetailDao {
    /**
     * 查询子订单
     * @param orderDetailId
     * @return
     */
    OrderDetailModel queryByOrderId(Long orderDetailId);
    int update(OrderDetailModel orderDetailModel);
}
