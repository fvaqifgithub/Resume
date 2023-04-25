package com.company.bean.dao.impl;


import com.company.bean.User;
import com.company.bean.dao.inter.UserDaoInter;
import com.company.bean.dao.AbstractDao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends AbstractDao implements UserDaoInter {


    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection connect = connect()) {
            Statement stmt = connect.createStatement();
            stmt.execute("select * from user");
            ResultSet r = stmt.getResultSet();
            while (r.next()) {
                int id = r.getInt("id");
                String name = r.getString("name");
                String surname = r.getString("surname");
                String telephone = r.getString("telephone");
                String email = r.getString("email");
                result.add(new User(id, name, surname, telephone, email));
            }
            System.out.println(connect.getClass().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stm = c.prepareStatement("update user set name=?, surname=?,telephone=?,email=? where id=? ");
            stm.setString(1, u.getName());
            stm.setString(2, u.getSurname());
            stm.setString(3, u.getPhone());
            stm.setString(4, u.getEmail());
            stm.setInt(5, u.getId());

            return stm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stm = c.createStatement();
            return stm.execute("delete from user where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public User getbyId(int userid) {
        User result = null;
        try (Connection connect = connect()) {
            Statement stmt = connect.createStatement();
            stmt.execute("select * from user where id =" + userid);
            ResultSet r = stmt.getResultSet();
            while (r.next()) {
                int id = r.getInt("id");
                String name = r.getString("name");
                String surname = r.getString("surname");
                String telephone = r.getString("telephone");
                String email = r.getString("email");
                result = new User(id, name, surname, telephone, email);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    @Override
    public boolean addUser(User u) throws Exception {
        try(Connection connect=connect()){
            PreparedStatement prepare=connect.prepareStatement("insert into user(name,surname,telephone,email) values (?,?,?,?)");
                    prepare.setString(1,u.getName());
                    prepare.setString(2, u.getSurname());
                    prepare.setString(3, u.getPhone());
                    prepare.setString(4, u.getEmail());
                    return prepare.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}