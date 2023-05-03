package com.company.dao.impl;



import com.company.entity.User;
import com.company.entity.Country;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.AbstractDao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends AbstractDao implements UserDaoInter {
    private User getUser(ResultSet r) throws Exception {
        int id = r.getInt("id");
        String name = r.getString("name");
        String surname = r.getString("surname");
        String telephone = r.getString("telephone");
        String email = r.getString("email");
        int nationalityId = r.getInt("nationality_id");
        int birthplaceId = r.getInt("birthplace_id");
        String nationalitySt = r.getString("nationality");
        Date birthdate = r.getDate("birthdate");
        String birthplaceSt = r.getString("birthplace");
        Country country = new Country(nationalityId, null, nationalitySt);
        Country birthplace = new Country(birthplaceId, birthplaceSt, null);

        return new User(id, name, surname, telephone, email, birthdate, birthplace, country);

    }


    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection connect = connect()) {
            Statement stmt = connect.createStatement();
            stmt.execute("select u.*," +
                    " n.nationality  as nationality," +
                    " c.name as birthplace" +
                    " from user u" +
                    " left join country n on u.nationality_id=n.id" +
                    " left join country c on u.birthplace_id=c.id;");
            ResultSet r = stmt.getResultSet();
            while (r.next()) {
                User u = getUser(r);

                result.add(u);
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
    public User getById(int userid) {
        User result = null;
        try (Connection connect = connect()) {
            Statement stmt = connect.createStatement();
            stmt.execute("SELECT" +
                    "u.*," +
                    " n.nationality AS nationality," +
                    "c.NAME AS birthplace " +
                    "FROM" +
                    "USER u" +
                    "LEFT JOIN country n ON u.nationality_id = n.id" +
                    "LEFT JOIN country c ON u.birthplace_id = c.id=" + userid);
            ResultSet r = stmt.getResultSet();
            while (r.next()) {
                result = getUser(r);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }



    @Override
    public boolean addUser(User u) {
        try (Connection connect = connect()) {
            PreparedStatement prepare = connect.prepareStatement("insert into user(name,surname,telephone,email) values (?,?,?,?)");
            prepare.setString(1, u.getName());
            prepare.setString(2, u.getSurname());
            prepare.setString(3, u.getPhone());
            prepare.setString(4, u.getEmail());
            return prepare.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}