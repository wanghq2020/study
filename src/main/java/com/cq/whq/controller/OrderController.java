package com.cq.whq.controller;

import com.alibaba.fastjson.JSONObject;
import com.cq.whq.common.Response;
import com.cq.whq.common.ResponseEnums;
import com.cq.whq.model.request.OrderRequestModel;
import com.cq.whq.service.DeilveryService;
import com.cq.whq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 20:04
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    DeilveryService deilveryService;


    /**
     * 拆单
     * @return
     */
    @PostMapping("/splitOrder")
    public Response splitOrder(@RequestBody OrderRequestModel model){

        if(model.getOrderDetailId()==null || model.getDeilveryQuantity()==null){
            return Response.error(ResponseEnums.Request_Param_Invalid);
        }
        Response res=orderService.splitOrder(model.getOrderDetailId(),model.getDeilveryQuantity());
        return res;
    }

    /**
     * 合并单
     * @param model
     * @return
     */
    @PostMapping("/mergeOrder")
    public Response mergeOrder(@RequestBody OrderRequestModel model){

        if(model.getOrderDetailId()==null || (model.getDeilveryIds()==null || "".equals(model.getDeilveryIds()))){
            return Response.error(ResponseEnums.Request_Param_Invalid);
        }
        Response res=deilveryService.mergeOrder(model.getOrderDetailId(),model.getDeilveryIds());
        return res;
    }

    /**
     * 改变订单数量
     * @param model
     * @return
     */
    @PostMapping("/changeOrderQuantity")
    public Response changeOrderQuantity(@RequestBody OrderRequestModel model){

        if(model.getOrderDetailId()==null || model.getOrderQuantity()==null){
            return Response.error(ResponseEnums.Request_Param_Invalid);
        }
        Response res=orderService.changeOrderQuantity(model.getOrderDetailId(),model.getOrderQuantity());
        return res;
    }
}
