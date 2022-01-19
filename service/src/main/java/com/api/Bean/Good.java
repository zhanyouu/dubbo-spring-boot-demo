package com.api.Bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Good implements Serializable {
    private int id;
    private String goodName;
    private int num;
}
