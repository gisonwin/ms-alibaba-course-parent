package com.yzmedu.gisonwin.feign;

import com.yzm.gisonwin.entity.ShopProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/18 22:04
 */
@FeignClient(value = "service-product")
public interface ProductFeignService {
    @GetMapping("product/{pid}")
    ShopProduct findByPid(@PathVariable("pid") String pid);
}
