package com.bdqn.Vo;

import lombok.Data;

import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/1 16:24
 * FileName: PageBean
 * Description:
 */
@Data
public class PageBean<T> {
    /**
     * 代码标识
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private List<T> data;

}
