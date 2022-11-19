package com.bdqn.entity;

//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.Version;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author RanGrd
 * @since 2022-10-01
 */
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableId(value = "id", type = IdType.ASSIGN_ID)
    //@JsonSerialize(using = ToStringSerializer.class)
    private Long id;

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
