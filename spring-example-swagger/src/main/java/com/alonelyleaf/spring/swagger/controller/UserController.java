package com.alonelyleaf.spring.swagger.controller;

import com.alonelyleaf.spring.swagger.model.UserGetDTO;
import com.alonelyleaf.spring.swagger.model.UserGetVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * 用户 controller
 * 启动项目，访问 ip:port/doc.html 查看文档
 *
 * @author bijl
 * @date 2021/2/3 上午11:27
 */
@Api(value = "/user", tags = "用户 controller")
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/get")
    @ApiOperation(value = "获取学生信息", httpMethod = "POST", notes = "根据用户ID获取用户")
    public UserGetVO gradeSetup(@RequestBody @Valid UserGetDTO userGetDTO) {

        UserGetVO userGetVO = new UserGetVO();
        userGetVO.setId(userGetDTO.getId());
        userGetVO.setName("哈斯");
        userGetVO.setBirthday(LocalDateTime.now().minusYears(5L));

        return userGetVO;
    }
}
