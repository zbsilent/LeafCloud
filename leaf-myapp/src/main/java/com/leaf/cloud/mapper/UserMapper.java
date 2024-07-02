package com.leaf.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leaf.cloud.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    // 你可以根据需要添加自定义的数据库操作方法
    // 例如，根据用户名查找用户：
    UserEntity findByUserName(@Param("userName") String userName);

    // 示例：根据邮箱查找用户
    // UserEntity findByEmail(@Param("email") String email);

    // 其他需要的数据库操作方法可以继续在这里添加
}