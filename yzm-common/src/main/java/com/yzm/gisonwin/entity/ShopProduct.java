package com.yzm.gisonwin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/14 22:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shop_product")
public class ShopProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT REPLACE(UUID(),\"-\",\"\")")
    private String id;
    private String pname;//商品名称
    private String pprice;//价格
    @Column(columnDefinition = "stock")
    private Integer stock;//库存


}
