package com.leaf.cloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leaf.cloud.entity.TClassEntity;
import com.leaf.cloud.entity.UserClassEntity;
import com.leaf.cloud.entity.UserEntity;
import com.leaf.cloud.mapper.TClassMapper;
import com.leaf.cloud.mapper.TUserClassMapper;
import com.leaf.cloud.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zbsilent
 * @version 1.0
 * @description: TODO
 * @date 2024/7/2 下午9:55
 */
@Service

public class TUserCalssService extends ServiceImpl<TUserClassMapper, UserClassEntity> {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TClassMapper tClassMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveUserClassWithUser(UserClassEntity userClassEntity, TClassEntity tClassEntity, List<UserEntity> userEntityList) {
        // 先保存用户（如果需要）
        if (tClassEntity != null && StringUtils.isBlank(tClassEntity.getClassId())) {
            int insert = tClassMapper.insert(tClassEntity);
            userClassEntity.setClassId(tClassEntity.getClassId());
        }

        // 设置 user_id（如果尚未设置）
        if (userEntityList != null && !userEntityList.isEmpty()) {
            userEntityList.stream().filter(userEntity -> userEntity.getId() == null)
                    .forEach(user -> {
                        userMapper.insert(user);
                        userClassEntity.setUserId(user.getId());
                    });
        }
        // 保存 user_class
        int insert = getBaseMapper().insert(userClassEntity);
        return insert > 0 ? userClassEntity.getClassId() : "error";

    }
}
