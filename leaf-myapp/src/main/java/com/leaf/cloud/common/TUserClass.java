package com.leaf.cloud.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leaf.cloud.entity.TClassEntity;
import com.leaf.cloud.entity.UserClassEntity;
import com.leaf.cloud.entity.UserEntity;
import lombok.Data;

import java.util.List;

/**
 * @author zbsilent
 * @version 1.0
 * @description: TODO
 * @date 2024/7/2 下午11:15
 */
@Data
public class TUserClass {
    private String id;
    @JsonProperty(value = "class_id")
    private TClassEntity classEntity;
    @JsonProperty(value = "user_id")
    private List<UserEntity> userEntityList;
}
