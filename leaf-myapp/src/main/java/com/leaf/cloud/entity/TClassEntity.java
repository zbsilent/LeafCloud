package com.leaf.cloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author zbsilent
 * @version 1.0
 * @description: 班级实体类
 * @date 2024/7/2 下午9:04
 */
@Data
@TableName("t_class") // 指示该实体类对应数据库中的t_class表
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TClassEntity {

    // 班级编号，通常作为主键
    @TableId(value = "class_id", type = IdType.ASSIGN_UUID) // 标识为主键字段
    private String classId; // 假设班级编号是Long类型的

    // 班级名称
    @TableField("class_name") // 如果数据库字段名和Java属性名不一致，可以通过value指定数据库字段名
    private String className;

    // 班级负责人ID
    @TableField("charge_person_id")
    private Long chargePersonId;

    // 删除标记，通常用0表示未删除，1表示已删除（或其他逻辑值）
    @TableField("deleted_flag")
    private Integer deletedFlag;

    // 创建时间
    @TableField("create_time")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    // 创建人ID
    @TableField("create_person_id")
    private Long createPersonId;


}