package com.alonelyleaf.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 获取用户 VO
 *
 * @author bijl
 * @date 2021/2/3 上午11:26
 */
@Data
@ApiModel(value = "UserGetVO", description = "获取用户 VO")
public class UserGetVO implements Serializable {

    @ApiModelProperty(value = "用户ID", example = "1", hidden = false)
    private Long id;

    @ApiModelProperty(value = "用户名称", example = "泰勒", hidden = false)
    private String name;

    @ApiModelProperty(value = "用户生日", notes = "用户生日", example = "1990-01-01", hidden = false)
    private LocalDateTime birthday;
}
