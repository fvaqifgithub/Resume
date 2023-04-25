package com.company.context;

import com.company.bean.dao.impl.UserDaoImpl;
import com.company.bean.dao.inter.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
}
