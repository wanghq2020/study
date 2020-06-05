package com.cq.whq.service;

import com.cq.whq.common.Response;

import java.math.BigDecimal;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 21:11
 */
public interface OrderService {
    /**
     * 拆分订单
     * @param orderId
     * @param orderDetailId
     * @param deilveryQuantity
     * @return
     */
    public Response splitOrder( Long orderDetailId, BigDecimal deilveryQuantity);

    /**
     * 更改交易单数量
     * @param orderDetialId
     * @param orderQuantity
     * @return
     */
    public Response changeOrderQuantity(Long orderDetialId,BigDecimal orderQuantity);

}
