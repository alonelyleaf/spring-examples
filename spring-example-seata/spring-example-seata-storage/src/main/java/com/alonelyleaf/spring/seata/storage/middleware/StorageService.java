package com.alonelyleaf.spring.seata.storage.middleware;

import com.alonelyleaf.spring.seata.feign.model.StorageDeductDTO;
import com.alonelyleaf.spring.seata.storage.service.IStorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 库存 Service
 *
 * @author bijl
 * @date 2021/3/25 下午5:47
 */
@Service
@AllArgsConstructor
public class StorageService {

    private final IStorageService storageService;

    /**
     * 库存消减
     *
     * @param
     * @return
     * @author bijl
     * @date 2021/3/25 下午8:03
     */
    public Boolean deduct(StorageDeductDTO storageDeductDTO) {
        return true;
    }
}
