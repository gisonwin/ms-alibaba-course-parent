package com.yzmedu.gisonwin.service;

import com.yzm.gisonwin.entity.ShopProduct;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/18 16:41
 */
public interface ProductService {

    ShopProduct findByPid(String pid);
}
