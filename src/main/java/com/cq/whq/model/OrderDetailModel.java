package com.cq.whq.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 19:48
 */
public class OrderDetailModel {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long  orderId;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 下单数量
     */
    private BigDecimal orderQuantity;
    /**
     * 剩余代发货数量
     */
    private BigDecimal remainingQuantity;
    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 版本号，标记拆分合并单
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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(BigDecimal remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
