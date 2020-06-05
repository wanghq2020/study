package com.cq.whq.model.request;

import java.math.BigDecimal;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/28 8:00
 */
public class OrderRequestModel {
    private Long orderDetailId;
    private BigDecimal deilveryQuantity;
    private String deilveryIds;
    private BigDecimal orderQuantity;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public BigDecimal getDeilveryQuantity() {
        return deilveryQuantity;
    }

    public void setDeilveryQuantity(BigDecimal deilveryQuantity) {
        this.deilveryQuantity = deilveryQuantity;
    }

    public String getDeilveryIds() {
        return deilveryIds;
    }

    public void setDeilveryIds(String deilveryIds) {
        this.deilveryIds = deilveryIds;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
