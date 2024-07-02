package com.leaf.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leaf.cloud.entity.TClassEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TClassMapper extends BaseMapper<TClassEntity> {
    // 你可以根据需要添加自定义的数据库操作方法
    // 例如，根据班级编号查找班级：
    // TClassEntity findByClassId(String classId);

    // 或者根据班级名称查找班级
    // TClassEntity findByClassName(String className);

    // 其他需要的数据库操作方法可以继续在这里添加
}