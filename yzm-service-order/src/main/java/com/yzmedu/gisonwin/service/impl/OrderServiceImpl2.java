package com.yzmedu.gisonwin.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/18 16:41
 */
@Service
public class OrderServiceImpl2 {
    //定义 定义资源  value 指定资源名称.
    @SentinelResource("message")
    public String message() {
        return "message method";
    }
}
