import com.iweb.DAO.impl.CategoryDaoImpl;
import com.iweb.DAO.impl.UserDaoImpl;
import com.iweb.pojo.Category;
import com.iweb.pojo.User;
import com.iweb.util.MD5Util;
import com.iweb.util.UUIDUtil;
import org.junit.Test;

public class Tests {

    @Test
    public void userTest(){
        User user = new User(UUIDUtil.uuid(),"ljps", MD5Util.getMD5("741741"));
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.addUser(user));
        System.out.println(userDao.login(user));
    }
    @Test
    public void categoryTest(){
        Category category1 = new Category(UUIDUtil.uuid(),"电脑");
        Category category2 = new Category(UUIDUtil.uuid(),"鼠标");
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        System.out.println(categoryDao.add(category1));
        System.out.println(categoryDao.add(category2));
    }
}
