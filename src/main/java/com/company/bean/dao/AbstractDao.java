package com.company.bean.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    public  Connection connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/resumedb";
        String username = "root";
        String password = "root";
        Connection c=DriverManager.getConnection(url, username, password);
        return DriverManager.getConnection(url, username, password);
    }
}
