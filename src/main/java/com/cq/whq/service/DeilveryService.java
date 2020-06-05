package com.cq.whq.service;

import com.cq.whq.common.Response;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 22:26
 */
public interface DeilveryService {
    /**
     * 合并订单
     * @param orderDetailId
     * @param orderDeilveryIds
     * @return
     */
    public Response mergeOrder(Long orderDetailId,String orderDeilveryIds);
}
