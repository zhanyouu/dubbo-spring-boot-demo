package com.api.Bean;

import lombok.Data;

import java.util.Date;

@Data
public class Lock {
    private int id;
    private int status;
    private Date startTime;
    private Date endTime;
}
