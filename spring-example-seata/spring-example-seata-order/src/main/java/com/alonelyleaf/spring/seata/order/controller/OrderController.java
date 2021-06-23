package com.alonelyleaf.spring.seata.order.controller;

import com.alonelyleaf.spring.seata.enity.Order;
import com.alonelyleaf.spring.seata.order.middleware.OrderService;
import com.alonelyleaf.spring.seata.order.model.OrderCreateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 订单 Controller
 *
 * @author bijl
 * @date 2021/3/25 下午3:23
 */
@Api(value = "/order", tags = "订单 Controller")
@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ApiOperation(value = "创建订单")
    @PostMapping(value = "/create")
    public Order save(@RequestBody @Valid OrderCreateDTO params) {

        return orderService.purchase(params);
    }
}
