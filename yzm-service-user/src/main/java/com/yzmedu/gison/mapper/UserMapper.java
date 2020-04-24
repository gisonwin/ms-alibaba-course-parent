package com.yzmedu.gison.mapper;

import com.yzm.gisonwin.entity.User;
import com.yzm.gisonwin.mapper.ShopBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/18 16:42
 */
@Mapper
public interface UserMapper extends ShopBaseMapper<User> {
}
