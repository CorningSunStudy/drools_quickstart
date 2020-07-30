package com.corning.drools.entity;

import lombok.Data;

@Data
public class Order {

    /**
     * 原始价格
     */
    private Double originalPrice;

    /**
     * 优惠后价格
     */
    private Double realPrice;

}
