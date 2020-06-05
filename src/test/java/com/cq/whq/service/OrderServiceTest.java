package com.cq.whq.service;

import com.cq.whq.common.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author whq
 * @version 1.0
 * @date 2020/6/5 21:30
 */
@SpringBootTest
class OrderServiceTest {


    @Autowired
    OrderService orderService;

    @Test
    void splitOrder() {
       Response res= orderService.splitOrder(1L,new BigDecimal(20));
    }

    @Test
    void splitOrder2() {
        Response res= orderService.splitOrder(1L,new BigDecimal(3));
    }

    @Test
    void changeOrderQuantity() {
        Response res=orderService.changeOrderQuantity(1L,new BigDecimal(0));
    }
    @Test
    void changeOrderQuantity2() {
        Response res=orderService.changeOrderQuantity(1L,new BigDecimal(30));
    }
}