package com.leaf.cloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @author zbsilent
 * @version 1.0
 * @description: TODO
 * @date 2024/7/2 下午10:04
 */
@Data
@TableName(value = "t_user_class")
public class UserClassEntity {
    @TableId(value = "user_class_id", type = IdType.ASSIGN_UUID)
    private String userClassId;

    //@NotNull(message="[班级ID]不能为空")
    @TableField("class_id")
    //@ApiModelProperty("班级ID")
    private String classId;
    /**
     * 用户ID
     */
    //@NotNull(message="[用户ID]不能为空")
    //@ApiModelProperty("用户ID")
    @TableField("user_id")
    private Long userId;
}
