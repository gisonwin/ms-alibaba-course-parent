package com.yzmedu.gisonwin.controller;

import com.yzmedu.gisonwin.service.impl.OrderServiceImpl2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/5 16:36
 */
@RestController
@Slf4j
public class OrderController3 {

    @Autowired
    private OrderServiceImpl2 orderServiceimpl2;
    @GetMapping("/order/message1")
    public String message1(){
        orderServiceimpl2.message();
        return "message1";
    }

    @GetMapping("/order/message2")
    public String message2(){
        orderServiceimpl2.message();
        return "message2";
    }
}
