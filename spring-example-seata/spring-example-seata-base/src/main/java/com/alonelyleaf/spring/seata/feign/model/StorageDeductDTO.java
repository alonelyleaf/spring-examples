package com.alonelyleaf.spring.seata.feign.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 库存消减 DTO
 *
 * @author bijl
 * @date 2021/3/25 下午5:47
 */
@Data
@ApiModel(value = "StorageDeductDTO", description = "库存消减 DTO")
public class StorageDeductDTO implements Serializable {

    @ApiModelProperty(value = "商品编号", example = "CODE1")
    @NotBlank(message = "商品编号不能为空")
    private String commodityCode;

    @ApiModelProperty(value = "数量", example = "1")
    @NotBlank(message = "数量不能为空")
    private Integer count;
}
