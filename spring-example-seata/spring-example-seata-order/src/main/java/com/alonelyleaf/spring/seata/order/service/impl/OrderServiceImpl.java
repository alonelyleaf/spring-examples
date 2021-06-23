package com.alonelyleaf.spring.seata.order.service.impl;

import com.alonelyleaf.spring.seata.enity.Order;
import com.alonelyleaf.spring.seata.order.mapper.OrderMapper;
import com.alonelyleaf.spring.seata.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 订单 ServiceImpl
 *
 * @author bijl
 * @date 2021/3/25 下午3:03
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
