package com.alonelyleaf.spring.seata.storage.controller;

import com.alonelyleaf.spring.seata.feign.model.StorageDeductDTO;
import com.alonelyleaf.spring.seata.storage.middleware.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 库存 Controller
 *
 * @author bijl
 * @date 2021/3/25 下午8:01
 */
@Api(value = "/storage", tags = "库存 Controller")
@RestController
@RequestMapping("/storage")
@AllArgsConstructor
public class StorageController {

    private final StorageService storageService;

    @ApiOperation(value = "创建订单")
    @PostMapping(value = "/create")
    public Boolean save(@RequestBody @Valid StorageDeductDTO params) {

        return storageService.deduct(params);
    }

}
