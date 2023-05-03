package com.company.dao.inter;


import com.company.entity.UserSkill;

import java.sql.ResultSet;
import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getAllSkillByUser(int id);

}
