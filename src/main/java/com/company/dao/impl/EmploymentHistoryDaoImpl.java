package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {
    private EmploymentHistory getAllEmploymentHistory(ResultSet rs) throws Exception {
        String header = rs.getString("header");
        String jobDescription = rs.getString("job_description");
        Date beginDate = rs.getDate("begin_Date");
        Date endDate = rs.getDate("end_Date");
        int userid = rs.getInt("user_id");
        EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userid));
        return emp;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryById(int user_id) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select *from employment_history where user_id=?");
            stmt.setInt(1, user_id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                EmploymentHistory emp = getAllEmploymentHistory(rs);
                result.add(emp);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
