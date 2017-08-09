package com.jiudianlianxian.hibernatetest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.jiudianlianxian.entity.Customer;
import com.jiudianlianxian.entity.LinkMan;
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
public class HibernateOnetoMany {
	
	//一对多的数据修改
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
			//将一个联系人隶属的客户改变成另一个客户:将所要改变的联系人查出来，将要改变到的客户查询出来，将联系人放进要改变的客户中去。
			//01.根据id查询联系人对象，根据id查询联系人所要隶属的客户对象
			Customer customer = session.get(Customer.class, 7);
			LinkMan linkMan = session.get(LinkMan.class,7);
			//02.设置持久态对象的值
			//02-1.把联系人放到客户实体类对象的set集合中去
			customer.getSetLinkMan().add(linkMan);
			//02-2.把客户对象放到联系人客户属性里面去
			linkMan.setCustomer(customer);
			
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
	
	//一对多的级联删除
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
			//01.根据id查询customer对象
			Customer customer = session.get(Customer.class, 8);
			//02.执行删除操作
			session.delete(customer);
			
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
	
	//一对多的级联保存简化写法（通过配置文件实现）
	@Test
	public void testAddDemo2(){
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
			//01.创建一个客户和联系人
			Customer customer = new Customer();
			customer.setCustName("十一点连线");
			customer.setCustLevel("普通用户");
			customer.setCustMobile("634343");
			customer.setCustPhone("34340");
			customer.setCustSource("是大法官");
			
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("小话");
			linkMan.setLkm_gender("第三方");
			linkMan.setLkm_phone("9阿斯蒂芬");
			
		    //02.建立客户对象和联系人对象之间的关系
			//把联系人放到客户实体类对象的set集合中去
			customer.getSetLinkMan().add(linkMan);
			
			//03.保存数据到数据库
			session.save(customer);
			
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
	
	//一对多的级联保存复杂写法（无配置）
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
			//01.创建一个客户和联系人
			Customer customer = new Customer();
			customer.setCustName("九点连线");
			customer.setCustLevel("vip");
			customer.setCustMobile("999");
			customer.setCustPhone("110");
			customer.setCustSource("网络");
			
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("张三");
			linkMan.setLkm_gender("男");
			linkMan.setLkm_phone("911");
			
		    //02.建立客户对象和联系人对象之间的关系
			//02-1.把联系人放到客户实体类对象的set集合中去
			customer.getSetLinkMan().add(linkMan);
			//02-2.把客户对象放到联系人客户属性里面去
			linkMan.setCustomer(customer);
			
			//03.保存数据到数据库
			session.save(customer);
			session.save(linkMan);
			
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
