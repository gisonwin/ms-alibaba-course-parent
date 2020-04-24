package com.yzmedu.gisonwin.controller;

import com.yzm.gisonwin.entity.ShopProduct;
import com.yzmedu.gisonwin.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/6 12:14
 */
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("product/{pid}")
    public ShopProduct getProduct(@PathVariable("pid") @NotNull String pid) {
        log.info("对商品{}进行查询", pid);

        ShopProduct product = productService.findByPid(pid);

//        sleep();
        log.info("get product info ==> {}",product.toString());
        return product;
    }

    private void sleep() {
        try {
            TimeUnit.MICROSECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
