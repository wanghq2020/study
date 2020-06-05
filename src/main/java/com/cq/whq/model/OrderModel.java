package com.cq.whq.model;

import java.util.Date;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 19:45
 */
public class OrderModel {
//    `id` bigint(64) NOT NULL,
//  `user_id` bigint(64) NOT NULL COMMENT '会员id',
//            `user_name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
//            `mobile` varchar(25) DEFAULT NULL COMMENT '收货电话',
//            `address` varchar(255) DEFAULT NULL COMMENT '收货地址',
//            `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
//            `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
//  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    private Long id;
    /**
     * 会员id
     */
    private Long userId;
    /**
     * 收货人姓名
     */
    private String userName;
    /**
     * 收货电话
     */
    private String mobile;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 备注
     */
    private String remark;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
