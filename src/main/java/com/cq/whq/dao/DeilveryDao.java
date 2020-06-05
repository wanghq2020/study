package com.cq.whq.dao;

import com.cq.whq.model.DeilveryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 21:21
 */
@Mapper
public interface DeilveryDao {
    List<DeilveryModel> queryByOrderId(@Param("orderDetailId") Long orderDetailId,@Param("version")Integer version);
    int insert(DeilveryModel deilveryModel);

    DeilveryModel queryById(@Param("id")Long id);

    /**
     * 修改版本信息
     * @param deilveryModel
     * @return
     */
    int updateVersion(DeilveryModel deilveryModel);

    /**
     * 修改发货量
     * @param deilveryModel
     * @return
     */
    int updateQuantity(DeilveryModel deilveryModel);
}
