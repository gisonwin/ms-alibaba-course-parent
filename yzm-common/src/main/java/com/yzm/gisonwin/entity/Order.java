package com.yzm.gisonwin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/14 22:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shop_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT REPLACE(UUID(),\"-\",\"\")")
    private String id;
    private String uid;//用户id
    private String pid;//商品id
    private String pname;//商品名称
    private String pprice;//商品单价
    @Column(columnDefinition = "number")
    private Integer number;//购买数量
    @Column(columnDefinition = "createtime")
    private BigInteger createtime;//创建时间
}
