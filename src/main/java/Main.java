
import com.company.dao.impl.EmploymentHistoryDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.main.Context;


public class Main {

    public static void main(String[] args) {
        SkillDaoInter s=Context.instanceSkill();
        System.out.println(s.getAllSkill());
    }
}
