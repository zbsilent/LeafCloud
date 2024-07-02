package com.leaf.cloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leaf.cloud.entity.UserEntity;
import com.leaf.cloud.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zbsilent
 * @version 1.0
 * @description: TODO
 * @date 2024/7/2 下午8:07
 */
@Service
@Slf4j
public class UserService extends ServiceImpl<UserMapper, UserEntity> {
}
