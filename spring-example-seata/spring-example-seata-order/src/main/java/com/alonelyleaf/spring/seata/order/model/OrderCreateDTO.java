package com.alonelyleaf.spring.seata.order.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 类的描述
 *
 * @author bijl
 * @date 2021/3/25 下午3:31
 */
@Data
@ApiModel(value = "OrderCreateDTO", description = "订单创建 DTO")
public class OrderCreateDTO implements Serializable {

    @ApiModelProperty(value = "用户ID", example = "1")
    private String userId;

    @ApiModelProperty(value = "商品编号", example = "CODE1")
    private String commodityCode;

    @ApiModelProperty(value = "", example = "1")
    private Integer orderCount;
}
