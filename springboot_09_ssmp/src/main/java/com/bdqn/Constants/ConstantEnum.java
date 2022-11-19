package com.bdqn.Constants;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/1 16:27
 * FileName: ConstantEnum
 * Description: 常量
 */
public enum ConstantEnum {
    /**
     * 成功标识
     */
    PAGE_BEAN_SUCCESS_CODE(1),
    /**
     * 错误标识
     */
    PAGE_BEAN_FAIL_CODE(0);

    private final Integer code;

    ConstantEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
