package com.alonelyleaf.spring.seata.enity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 库存
 *
 * @author bijl
 * @date 2021/3/25 下午5:30
 */
@Data
@ApiModel(value = "Storage", description = "库存")
@EqualsAndHashCode(callSuper = true)
@TableName("storage_tbl")
public class Storage extends Model<Storage> {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品编码")
    @TableField(value = "commodity_code")
    private String commodityCode;

    @ApiModelProperty(value = "库存数量")
    @TableField(value = "count")
    private Long count;

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
