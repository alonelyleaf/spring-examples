package com.alonelyleaf.spring.seata.order.middleware;

import com.alonelyleaf.spring.seata.enity.Order;
import com.alonelyleaf.spring.seata.feign.StorageFeign;
import com.alonelyleaf.spring.seata.feign.model.StorageDeductDTO;
import com.alonelyleaf.spring.seata.order.model.OrderCreateDTO;
import com.alonelyleaf.spring.seata.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 订单 Service
 *
 * @author bijl
 * @date 2021/3/25 下午4:38
 */
@Service
@AllArgsConstructor
public class OrderService {

    private final IOrderService orderService;

    private final StorageFeign storageFeign;

    /**
     * 采购
     */
    @GlobalTransactional
    public Order purchase(OrderCreateDTO orderCreateDTO) {

        // 扣减库存
        StorageDeductDTO storageDeductDTO = new StorageDeductDTO();
        storageDeductDTO.setCommodityCode(orderCreateDTO.getCommodityCode());
        storageDeductDTO.setCount(orderCreateDTO.getOrderCount());
        storageFeign.deduct(storageDeductDTO);

        // 创建订单
        Order newOrder = new Order();
        newOrder.setUserId(orderCreateDTO.getUserId());
        newOrder.setCommodityCode(orderCreateDTO.getCommodityCode());
        newOrder.setCount(orderCreateDTO.getOrderCount());

        orderService.save(newOrder);

        return newOrder;
    }

}
