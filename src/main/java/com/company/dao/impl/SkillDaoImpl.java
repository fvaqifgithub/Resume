package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {
    public Skill getSkill(ResultSet rt) throws Exception {
        int id = rt.getInt("id");
        String name = rt.getString("name");
        return new Skill(id, name);
    }

    @Override
    public List<Skill> getAllSkill() {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement s = c.createStatement();
            s.execute("select * from skill where id = id; ");
            ResultSet r = s.getResultSet();
            while (r.next()) {
                Skill s2 = getSkill(r);
                result.add(s2);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
