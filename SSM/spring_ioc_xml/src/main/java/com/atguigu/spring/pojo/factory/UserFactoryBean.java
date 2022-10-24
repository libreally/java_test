package com.atguigu.spring.pojo.factory;

import com.atguigu.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * 工厂bean
 */
public class UserFactoryBean implements FactoryBean<User>{


    @Override
    public User getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
