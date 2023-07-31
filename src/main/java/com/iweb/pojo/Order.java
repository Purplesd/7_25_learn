package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String pid;
    private String address;

    public Order(String address, String pid) {
        this.address = address;
        this.pid = pid;
    }
}
