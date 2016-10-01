import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coders.dao.UsersDao;
import com.coders.model.Users;


public class UsersTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.coders");
		ctx.refresh();
		Users usr=(Users) ctx.getBean("users");
		UsersDao usrdao=(UsersDao) ctx.getBean("usersDao");
//		 List<Users> userslst = usrdao.getAllUser();
//		 System.out.println(userslst.size());
		
		usr.setPwd("sssu");
		usr.setUid("sssssi");
		usr.setUnam("ssssn");
		usr.setEmail("a@gmail.com");
		usrdao.SaveOrUpdate(usr);
		
		
		
		
	}
}
