import com.company.bean.User;
import com.company.bean.dao.impl.UserDaoImpl;
import com.company.bean.dao.inter.UserDaoInter;
import com.company.context.Context;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoImpl u = new UserDaoImpl();
        List<User> l=u.getAll();
        System.out.println(l);
    }
}
