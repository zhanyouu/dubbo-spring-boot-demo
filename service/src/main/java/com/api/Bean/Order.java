package com.api.Bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private int orderId;
    private int goodId;
    private String desc;
}
