package com.company.dao.inter;

import com.company.entity.User;

import java.util.List;

public interface UserDaoInter {
    public List<User> getAll();
    public boolean updateUser(User u);
    public boolean addUser(User u) throws Exception;

    public boolean removeUser(int id);
    public User getById(int i);
}
