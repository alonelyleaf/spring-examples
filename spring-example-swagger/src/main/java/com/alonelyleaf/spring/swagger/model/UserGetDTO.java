package com.alonelyleaf.spring.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 获取用户 DTO
 *
 * @author bijl
 * @date 2021/2/3 上午11:26
 */
@Data
@ApiModel(value = "UserGetDTO", description = "获取用户 DTO")
public class UserGetDTO implements Serializable {

    @ApiModelProperty(value = "用户ID", notes = "用户ID", example = "1", hidden = false)
    private Long id;

    @ApiModelProperty(value = "用户手机号", example = "13312341234", hidden = true)
    private String mobile;
}
