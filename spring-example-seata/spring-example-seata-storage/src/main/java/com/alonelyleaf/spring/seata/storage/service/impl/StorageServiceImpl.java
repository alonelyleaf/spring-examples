package com.alonelyleaf.spring.seata.storage.service.impl;

import com.alonelyleaf.spring.seata.enity.Storage;
import com.alonelyleaf.spring.seata.storage.mapper.StorageMapper;
import com.alonelyleaf.spring.seata.storage.service.IStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 库存 ServiceImpl
 *
 * @author bijl
 * @date 2021/3/25 下午5:46
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements IStorageService {
}
