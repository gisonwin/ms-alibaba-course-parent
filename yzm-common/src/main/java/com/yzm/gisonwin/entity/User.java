package com.yzm.gisonwin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/14 22:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="shop_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "SELECT REPLACE(UUID(),\"-\",\"\")")
    private String id;
    private String username;
    private String password;
    private String telephone;
}
