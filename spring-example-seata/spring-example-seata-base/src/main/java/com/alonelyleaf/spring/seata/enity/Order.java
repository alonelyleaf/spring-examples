package com.alonelyleaf.spring.seata.enity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 订单
 *
 * @author bijl
 * @date 2021/3/25 下午2:59
 */
@Data
@ApiModel(value = "Order", description = "订单")
@EqualsAndHashCode(callSuper = true)
@TableName(value = "order_tbl")
public class Order extends Model<Order> {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;

    @ApiModelProperty(value = "商品编码")
    @TableField(value = "commodity_code")
    private String commodityCode;

    @ApiModelProperty(value = "商品数量")
    @TableField(value = "count")
    private Integer count;

    @ApiModelProperty(value = "金额(单位分)")
    @TableField(value = "money")
    private Long money;

    @ApiModelProperty(value = "创建时间", example = "")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间", example = "")
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除标识:0-未删除;1-删除", example = "")
    @TableField(value = "del_flag")
    @TableLogic
    private Integer delFlag;
}
