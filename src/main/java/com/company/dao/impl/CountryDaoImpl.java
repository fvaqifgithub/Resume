package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    public Country getCountry(ResultSet rs) throws Exception {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");
        Country country = new Country(id, name, nationality);

        return country;
    }

    @Override
    public List<Country> getAllCountry() {
        List<Country> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement s = c.createStatement();
            s.execute(" select * from country where id = id");
            ResultSet rt = s.getResultSet();
            while (rt.next()) {
                Country u = getCountry(rt);
                result.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
