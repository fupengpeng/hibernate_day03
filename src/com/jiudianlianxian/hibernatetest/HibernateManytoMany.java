package com.jiudianlianxian.hibernatetest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.jiudianlianxian.entity.Customer;
import com.jiudianlianxian.entity.LinkMan;
import com.jiudianlianxian.manytomany.Role;
import com.jiudianlianxian.manytomany.User;
import com.jiudianlianxian.utils.HibernateUtils;


/**
 * 
 * Title: HibernateOnetoMany
 * Description: 一对多操作
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: hibernate_day03
 * @author fupengpeng
 * @date 2017年8月8日 下午3:30:44
 */
public class HibernateManytoMany {
	
	//多对多的数据移除
	@Test
	public void testUpdateDemo2(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.：使用SessionFactory创建Session对象
			//理解：类似于jdbc的连接数据库
			session = HibernateUtils.getSessionObject();
			//2.：开启事务
			transaction = session.beginTransaction();
			//3.：写具体的crud操作
			
			//3-1.根据id查询需要移除角色的用户和需要移除的角色
			User user = session.get(User.class, 2);
			Role role = session.get(Role.class, 3);
			//3-2.在用户对象的set集合中移除某角色对象
			user.getSetRole().remove(role);
			
			//4.：提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.回滚事务
			transaction.rollback();
		} finally {
			//6.：关闭资源     在使用了与本地线程绑定的session对象之后，就不需要手动关闭session了
//			session.close();
		}
	}
	
	//多对多的数据添加
	@Test
	public void testUpdateDemo1(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.：使用SessionFactory创建Session对象
			//理解：类似于jdbc的连接数据库
			session = HibernateUtils.getSessionObject();
			//2.：开启事务
			transaction = session.beginTransaction();
			//3.：写具体的crud操作
			//让某个用户具有某个角色
			//3-1.根据id查询需要添加角色的用户和需要添加的角色
			User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 2);
			//3-2.给用户对象的set集合添加所需角色对象
			user.getSetRole().add(role);
			
			//4.：提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.回滚事务
			transaction.rollback();
		} finally {
			//6.：关闭资源     在使用了与本地线程绑定的session对象之后，就不需要手动关闭session了
//			session.close();
		}
	}
	
	//多对多的级联删除
	@Test
	public void testDeleteDemo1(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.：使用SessionFactory创建Session对象
			//理解：类似于jdbc的连接数据库
			session = HibernateUtils.getSessionObject();
			//2.：开启事务
			transaction = session.beginTransaction();
			//3.：写具体的crud操作
			//删除某一个用户和他的联系人
			 
			//1.根据id查询用户，并进行删除
			User user = session.get(User.class, 1);
			session.delete(user);
			
			//4.：提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.回滚事务
			transaction.rollback();
		} finally {
			//6.：关闭资源     在使用了与本地线程绑定的session对象之后，就不需要手动关闭session了
//			session.close();
		}
	}
	
	//多对多的级联保存简化写法（通过配置文件实现）
	@Test
	public void testAddDemo1(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.：使用SessionFactory创建Session对象
			//理解：类似于jdbc的连接数据库
			session = HibernateUtils.getSessionObject();
			//2.：开启事务
			transaction = session.beginTransaction();
			//3.：写具体的crud操作
			//添加一个客户，为客户添加一个联系人
			//1.添加两个用户，为两个用户添加三个角色
			User user1 = new User();
			user1.setUser_name("黎明");
			user1.setUser_password("159357");
			User user2 = new User();
			user2.setUser_name("王蒙");
			user2.setUser_password("951753");
			Role role1 = new Role();
			role1.setRole_name("总裁");
			role1.setRole_memo("发布命令");
			Role role2 = new Role();
			role2.setRole_name("秘书");
			role2.setRole_memo("整理文件");
			Role role3 = new Role();
			role3.setRole_name("司机");
			role3.setRole_memo("开车");
			//2.建立关系，把角色添加到用户里面
			user1.getSetRole().add(role1);
			user1.getSetRole().add(role3);
			user2.getSetRole().add(role2);
			user2.getSetRole().add(role3);
			//3.保存用户
			session.save(user1);
			session.save(user2);
			
			//4.：提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.回滚事务
			transaction.rollback();
		} finally {
			//6.：关闭资源     在使用了与本地线程绑定的session对象之后，就不需要手动关闭session了
//			session.close();
		}
	}
	
	
}
