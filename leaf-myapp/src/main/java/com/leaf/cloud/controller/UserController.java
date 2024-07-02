package com.leaf.cloud.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.leaf.cloud.common.R;
import com.leaf.cloud.common.TUserClass;
import com.leaf.cloud.entity.TClassEntity;
import com.leaf.cloud.entity.UserClassEntity;
import com.leaf.cloud.entity.UserEntity;
import com.leaf.cloud.service.TCalssService;
import com.leaf.cloud.service.TUserCalssService;
import com.leaf.cloud.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 描述
 *
 * @author zbsilent
 * @version 1.0
 * @createDate 2024/7/2 下午5:20
 **/
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TCalssService calssService;
    @Autowired
    private TUserCalssService userCalssService;

    @PostMapping("/gateway/user")
    public JSONPObject svaeUser(@RequestBody UserEntity user) {

        boolean save = userService.save(user);
        if (save) {
            return new JSONPObject("success", false);
        }
        return new JSONPObject("fail", false);
    }

    @PostMapping("/gateway/tclass")
    public JSONPObject svaeTClass(@RequestBody TClassEntity classEntity) {

        boolean save = calssService.save(classEntity);
        if (save) {
            return new JSONPObject("success", false);
        }
        return new JSONPObject("fail", false);
    }

    @PostMapping("/gateway/userClass")
    public R<String> svaeUser2(@RequestBody TUserClass userClass) {
        UserClassEntity userClassEntity = new UserClassEntity();
         // !StringUtils.isBlank(userClass.getId()) ? userClassEntity.setUserClassId(userClass.getId()):userClassEntity.setUserClassId("sdfsdf");
        Optional.ofNullable(userClass.getId()).ifPresent(userClassEntity::setUserClassId);
        String primaryKey = userCalssService.saveUserClassWithUser(userClassEntity, userClass.getClassEntity(), userClass.getUserEntityList());
        if (!StringUtils.isBlank(primaryKey)) {
            return R.success(primaryKey);
        }
        return R.success();
    }

}
