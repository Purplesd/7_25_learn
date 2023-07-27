import com.iweb.DAO.impl.UserDaoImpl;
import com.iweb.pojo.User;
import org.junit.Test;

public class Tests {


    @Test
    public void userTest(){
        User user = new User("1","ljps","123");
        UserDaoImpl userDao = new UserDaoImpl();
//        System.out.println(userDao.addUser(user));
        System.out.println(userDao.login(user));
        System.out.println(userDao.verifyUserName("wzf"));
    }
    @Test
    public void test2(){
        User user = new User("1","ljps","123");
        UserDaoImpl userDao = new UserDaoImpl();
//        System.out.println(userDao.addUser(user));
        System.out.println(userDao.login(user));
        System.out.println(userDao.verifyUserName("wzf"));
    }
}
