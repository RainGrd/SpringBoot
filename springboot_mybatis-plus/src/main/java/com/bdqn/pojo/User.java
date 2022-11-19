package com.bdqn.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 *
 * @TableName t_user
 */
@Data
//@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     *
     */
    //@TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    @TableField(value = "pwd",select = false)
    private String password;

    /**
     *
     */
    private Integer age;

    /**
     *
     */
    private String tel;

    @TableField(exist = false)
    private Integer online;

    @TableField("deleted")
    //@TableLogic(value = "0",delval = "1")
    private Integer delStatus;

    /**
     * 实现乐观锁
     */
    @Version
    private Integer version;




    private static final long serialVersionUID = 1L;
}