package com.bdqn.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/9 15:11
 * FileName: Book
 * Description:
 */
@Data
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    //@TableId(value = "id", type = IdType.ASSIGN_ID)
    //@JsonSerialize(using = ToStringSerializer.class)
    private String id;

    //@TableField("name")
    private String name;

    //@TableField("type")
    private String type;

    //@TableField("description")
    private String description;

    /**
     * 逻辑删除字段 0:未删,1:删除
     */
    //@TableField("deleted")
    //@TableLogic
    private Integer deleted;

    /**
     * 乐观锁
     */
    //@TableField("version")
    //@Version
    private Integer version;

}
