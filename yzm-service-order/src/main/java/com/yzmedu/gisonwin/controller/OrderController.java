package com.yzmedu.gisonwin.controller;

import com.alibaba.nacos.common.utils.UuidUtils;
import com.yzm.gisonwin.entity.Order;
import com.yzm.gisonwin.entity.ShopProduct;
import com.yzmedu.gisonwin.feign.ProductFeignService;
import com.yzmedu.gisonwin.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigInteger;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/5 16:36
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private ProductFeignService productFeignService;

    @GetMapping("/order/prod/{pid}")
    public Order placeOrder(@PathVariable("pid") String pid) {
        log.info("received {} product order request", pid);
//        去产品微服务查询商品
        ShopProduct product = productFeignService.findByPid(pid);
//        ShopProduct product = restTemplate.getForObject("http://service-product/product/" + pid, ShopProduct.class);
        log.info("product micro service return is {} ", product);
//        try {
//            TimeUnit.MICROSECONDS.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //根据商品id下单
        log.info("place an order with Product {}", pid);
        Order order = Order.builder().id(UuidUtils.generateUuid().replaceAll("-", ""))
                .createtime(BigInteger.valueOf(System.currentTimeMillis()))
                .uid(UuidUtils.generateUuid().replaceAll("-", ""))
                .pid(pid).pname(product.getPname()).pprice(product.getPprice())
                .number(1)
                .build();
        orderService.createOrder(order);
        log.info("place an order ===> {}", order);
        return order;
    }


//    @GetMapping("/order/prod/{pid}")
//    public Order placeOrder(@PathVariable("pid") String pid) {
//        log.info("received {} product order request", pid);
////        去产品微服务查询商品
//        ShopProduct product = restTemplate.getForObject("http://localhost:8150/product/" + pid, ShopProduct.class);
//        log.info("product micro service return is {} ", product);
//        try {
//            TimeUnit.MICROSECONDS.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //根据商品id下单
//        log.info("place an order with Product {}", pid);
//        Order order = Order.builder().id(UuidUtils.generateUuid().replaceAll("-", ""))
//                .createtime(System.currentTimeMillis())
//                .uid(UuidUtils.generateUuid().replaceAll("-", ""))
//                .pid(pid).pname(product.getPname()).pprice(product.getPprice())
//                .number(1)
//                .build();
//        orderService.createOrder(order);
//        log.info("place an order ===> {}", order);
//        return order;
//    }

//    @GetMapping("/order/prod/{pid}")
//    public Order placeOrder(@PathVariable("pid") String pid) {
//        log.info("received {} product order request", pid);
////        去产品微服务查询商品
//        ShopProduct product = restTemplate.getForObject("http://localhost:8150/product/" + pid, ShopProduct.class);
//        log.info("product micro service return is {} ", product);
//        try {
//            TimeUnit.MICROSECONDS.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //根据商品id下单
//        log.info("place an order with Product {}", pid);
//        Order order = Order.builder().id(UuidUtils.generateUuid().replaceAll("-", ""))
//                .createtime(System.currentTimeMillis())
//                .uid(UuidUtils.generateUuid().replaceAll("-", ""))
//                .pid(pid).pname(product.getPname()).pprice(product.getPprice())
//                .number(1)
//                .build();
//        orderService.createOrder(order);
//        log.info("place an order ===> {}", order);
////        try {
////            TimeUnit.MICROSECONDS.sleep(20000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        return order;
//    }
}
