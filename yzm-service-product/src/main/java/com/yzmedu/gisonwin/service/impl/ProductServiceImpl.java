package com.yzmedu.gisonwin.service.impl;

import com.yzm.gisonwin.entity.ShopProduct;
import com.yzmedu.gisonwin.mapper.ProductMapper;
import com.yzmedu.gisonwin.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/18 16:41
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public ShopProduct findByPid(String pid) {

        ShopProduct product = productMapper.selectByPrimaryKey(pid);
        return product;
    }
}
