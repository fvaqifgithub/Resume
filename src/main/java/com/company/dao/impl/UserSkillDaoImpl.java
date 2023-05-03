package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {
    public UserSkill getUserSkill(ResultSet rs) throws SQLException {
        int skillId = rs.getInt("skill_id");
        int userId = rs.getInt("id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        return new UserSkill(userId, new User(userId), new Skill(skillId, skillName), power);
    }



    @Override
    public List<UserSkill> getAllSkillByUser(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement preparestmt = c.prepareStatement("SELECT" +
                    " u.*," +
                    "  us.skill_id, " +
                    "   s.name as skill_name," +
                    " us.power  " +
                    " from " +
                    " user_skill us " +
                    "    left join user u on us.user_id=u.id " +
                    "   left join skill s on us.skill_id= s.id" +
                    " Where" +
                    " us.user_id =?");
            preparestmt.setInt(1, userId);
            preparestmt.execute();
            ResultSet rt = preparestmt.getResultSet();
            while (rt.next()) {
                UserSkill u = getUserSkill(rt);
                result.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
