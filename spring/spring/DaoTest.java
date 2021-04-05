package spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
public static void main(String[] args) {
	ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
	DBDao dao=ctx.getBean("dao",DBDao.class);
	dao.getNoofrows();
	dao.getUID("sai");
	System.out.print(dao.getUserByUID(3));
	System.out.println(dao.getUsersByFlag(1));
}
}
