package com.yzm.gisonwin.exception;

import java.util.Objects;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/5/24 10:21
 */
public abstract class Asserts {

    public static  void assertNotNull(Object obj,String msg) throws Exception {
        if (Objects.isNull(obj)) {
            throw new RuntimeException(msg);
        }
    }

}
