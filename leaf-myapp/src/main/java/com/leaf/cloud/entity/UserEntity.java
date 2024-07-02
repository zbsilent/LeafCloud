package com.leaf.cloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述
 *
 * @author zbsilent
 * @version 1.0
 * @createDate 2024/7/2 下午4:58
 **/
@TableName("t_user")
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    @JsonProperty("userName")
    @TableField("user_name")
    private String userName;
    @JsonProperty("passWord")
    @TableField("pass_word")
    private String passWord;
    private Integer age;
    private String email;
    @JsonProperty("phoneNumber")
    @TableField("phone_number")
    private String phoneNumber;
    @TableLogic
    private Integer deleted = 0;
    @JsonProperty("createdTime")
    @TableField("created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @JsonProperty("updatedTime")
    @TableField("updated_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

}
