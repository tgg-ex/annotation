package com.zj.demo;

import lombok.Data;

@Data
public class TestInfo {

    @Info(min = "3", value = "校验错误")
    private String name;
}
