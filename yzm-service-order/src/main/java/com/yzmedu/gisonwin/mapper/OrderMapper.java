package com.yzmedu.gisonwin.mapper;

import com.yzm.gisonwin.entity.Order;
import com.yzm.gisonwin.mapper.ShopBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/18 16:42
 */
@Mapper
public interface OrderMapper extends ShopBaseMapper<Order> {
}
