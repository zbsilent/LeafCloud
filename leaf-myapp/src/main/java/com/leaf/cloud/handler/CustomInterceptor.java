package com.leaf.cloud.handler;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class CustomInterceptor implements InnerInterceptor {

    @Override
    public void beforeUpdate(Executor executor, MappedStatement ms, Object parameter) throws SQLException {
        InnerInterceptor.super.beforeUpdate(executor, ms, parameter);
    }

//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        StatementHandler statementHandler = PluginUtils.realTarget(invocation.getTarget());
//        BoundSql boundSql = statementHandler.getBoundSql();
//        String sql = boundSql.getSql();
//
//        // 如果是更新操作（通常根据SQL语句的内容判断）
//        if (sql.toLowerCase().startsWith("update")) {
//            // 这里只是打印SQL，你可以添加自己的逻辑来修改SQL或其他
//            System.out.println("即将执行的更新SQL：" + sql);
//            // 注意：你不能直接修改boundSql的内容，因为它是不可变的
//            // 如果你需要修改SQL，通常你需要创建新的BoundSql实例或使用其他方法
//        }
//
//        // 继续执行后续操作
//        return invocation.proceed();
//    }


//    @Override
//    public Object plugin(Object target) {
//        // 使用MyBatis提供的Plugin工具类来包装目标对象
//        return Plugin.wrap(target, this);
//    }

    @Override
    public void setProperties(Properties properties) {
        // 如果你的拦截器需要配置属性，可以在这里设置
    }
}