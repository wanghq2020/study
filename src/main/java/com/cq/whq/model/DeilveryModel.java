package com.cq.whq.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 19:54
 *
 *
 */
public class DeilveryModel {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单详情id
     */
    private Long orderDetailId;
    /**
     * 发货数量
     */
    private BigDecimal deilveryQuantity;
    /**
     * 是否已发货（0 未发货  1 已发货）
     */
    private Integer isDeilvery;

    /**
     * 版本号，标记拆分合并版本
     */
    private Integer version;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

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

    public Integer getIsDeilvery() {
        return isDeilvery;
    }

    public void setIsDeilvery(Integer isDeilvery) {
        this.isDeilvery = isDeilvery;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
