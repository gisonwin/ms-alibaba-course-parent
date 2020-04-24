package com.yzmedu.gisonwin.service.impl;

import com.yzm.gisonwin.entity.Order;
import com.yzmedu.gisonwin.mapper.OrderMapper;
import com.yzmedu.gisonwin.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/18 16:41
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        int insert = orderMapper.insert(order);
        log.info("insert {} record(s)",insert);

    }
}
