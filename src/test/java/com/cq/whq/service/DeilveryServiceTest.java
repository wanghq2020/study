package com.cq.whq.service;

import com.cq.whq.common.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author whq
 * @version 1.0
 * @date 2020/6/5 21:31
 */
@SpringBootTest
class DeilveryServiceTest {

    @Autowired
    DeilveryService deilveryService;

    @Test
    void mergeOrder() {
        Response res=deilveryService.mergeOrder(1L,"5,6");
    }
}