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
 * Description: һ�Զ����
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: hibernate_day03
 * @author fupengpeng
 * @date 2017��8��8�� ����3:30:44
 */
public class HibernateManytoMany {
	
	//��Զ�������Ƴ�
	@Test
	public void testUpdateDemo2(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.��ʹ��SessionFactory����Session����
			//��⣺������jdbc���������ݿ�
			session = HibernateUtils.getSessionObject();
			//2.����������
			transaction = session.beginTransaction();
			//3.��д�����crud����
			
			//3-1.����id��ѯ��Ҫ�Ƴ���ɫ���û�����Ҫ�Ƴ��Ľ�ɫ
			User user = session.get(User.class, 2);
			Role role = session.get(Role.class, 3);
			//3-2.���û������set�������Ƴ�ĳ��ɫ����
			user.getSetRole().remove(role);
			
			//4.���ύ����
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.�ع�����
			transaction.rollback();
		} finally {
			//6.���ر���Դ     ��ʹ�����뱾���̰߳󶨵�session����֮�󣬾Ͳ���Ҫ�ֶ��ر�session��
//			session.close();
		}
	}
	
	//��Զ���������
	@Test
	public void testUpdateDemo1(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.��ʹ��SessionFactory����Session����
			//��⣺������jdbc���������ݿ�
			session = HibernateUtils.getSessionObject();
			//2.����������
			transaction = session.beginTransaction();
			//3.��д�����crud����
			//��ĳ���û�����ĳ����ɫ
			//3-1.����id��ѯ��Ҫ��ӽ�ɫ���û�����Ҫ��ӵĽ�ɫ
			User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 2);
			//3-2.���û������set������������ɫ����
			user.getSetRole().add(role);
			
			//4.���ύ����
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.�ع�����
			transaction.rollback();
		} finally {
			//6.���ر���Դ     ��ʹ�����뱾���̰߳󶨵�session����֮�󣬾Ͳ���Ҫ�ֶ��ر�session��
//			session.close();
		}
	}
	
	//��Զ�ļ���ɾ��
	@Test
	public void testDeleteDemo1(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.��ʹ��SessionFactory����Session����
			//��⣺������jdbc���������ݿ�
			session = HibernateUtils.getSessionObject();
			//2.����������
			transaction = session.beginTransaction();
			//3.��д�����crud����
			//ɾ��ĳһ���û���������ϵ��
			 
			//1.����id��ѯ�û���������ɾ��
			User user = session.get(User.class, 1);
			session.delete(user);
			
			//4.���ύ����
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.�ع�����
			transaction.rollback();
		} finally {
			//6.���ر���Դ     ��ʹ�����뱾���̰߳󶨵�session����֮�󣬾Ͳ���Ҫ�ֶ��ر�session��
//			session.close();
		}
	}
	
	//��Զ�ļ��������д����ͨ�������ļ�ʵ�֣�
	@Test
	public void testAddDemo1(){
		Session session = null;
		Transaction transaction = null;
		try {
			
			//1.��ʹ��SessionFactory����Session����
			//��⣺������jdbc���������ݿ�
			session = HibernateUtils.getSessionObject();
			//2.����������
			transaction = session.beginTransaction();
			//3.��д�����crud����
			//���һ���ͻ���Ϊ�ͻ����һ����ϵ��
			//1.��������û���Ϊ�����û����������ɫ
			User user1 = new User();
			user1.setUser_name("����");
			user1.setUser_password("159357");
			User user2 = new User();
			user2.setUser_name("����");
			user2.setUser_password("951753");
			Role role1 = new Role();
			role1.setRole_name("�ܲ�");
			role1.setRole_memo("��������");
			Role role2 = new Role();
			role2.setRole_name("����");
			role2.setRole_memo("�����ļ�");
			Role role3 = new Role();
			role3.setRole_name("˾��");
			role3.setRole_memo("����");
			//2.������ϵ���ѽ�ɫ��ӵ��û�����
			user1.getSetRole().add(role1);
			user1.getSetRole().add(role3);
			user2.getSetRole().add(role2);
			user2.getSetRole().add(role3);
			//3.�����û�
			session.save(user1);
			session.save(user2);
			
			//4.���ύ����
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.�ع�����
			transaction.rollback();
		} finally {
			//6.���ر���Դ     ��ʹ�����뱾���̰߳󶨵�session����֮�󣬾Ͳ���Ҫ�ֶ��ر�session��
//			session.close();
		}
	}
	
	
}
