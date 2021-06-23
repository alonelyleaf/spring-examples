package com.alonelyleaf.spring.seata.feign;

import com.alonelyleaf.spring.seata.constant.ServiceConstant;
import com.alonelyleaf.spring.seata.feign.model.StorageDeductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 库存服务 Feign
 *
 * @author bijl
 * @date 2021/3/25 下午5:51
 */
@FeignClient(name = ServiceConstant.STORAGE_SERVER_NAME)
public interface StorageFeign {

    /**
     * 库存扣减
     *
     * @param storageDeductDTO 库存扣减 DTO
     * @return
     * @author bijl
     * @date 2021/3/25 下午8:29
     */
    @PostMapping("/storage/deduct")
    Boolean deduct(@RequestBody @Valid StorageDeductDTO storageDeductDTO);
}
