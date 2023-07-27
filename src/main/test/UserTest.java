import com.iweb.DAO.impl.UserDaoImpl;
        import com.iweb.pojo.User;

public class UserTest {
    public static void main(String[] args) {
        User user = new User("1","ljps","123");
        UserDaoImpl userDao = new UserDaoImpl();
//        System.out.println(userDao.addUser(user));
        System.out.println(userDao.login(user));
        System.out.println(userDao.verifyUserName("wzf"));
    }
}
