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
 * Description: һ�Զ����
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: hibernate_day03
 * @author fupengpeng
 * @date 2017��8��8�� ����3:30:44
 */
public class HibernateOnetoMany {
	
	//һ�Զ�������޸�
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
			//��һ����ϵ�������Ŀͻ��ı����һ���ͻ�:����Ҫ�ı����ϵ�˲��������Ҫ�ı䵽�Ŀͻ���ѯ����������ϵ�˷Ž�Ҫ�ı�Ŀͻ���ȥ��
			//01.����id��ѯ��ϵ�˶��󣬸���id��ѯ��ϵ����Ҫ�����Ŀͻ�����
			Customer customer = session.get(Customer.class, 7);
			LinkMan linkMan = session.get(LinkMan.class,7);
			//02.���ó־�̬�����ֵ
			//02-1.����ϵ�˷ŵ��ͻ�ʵ��������set������ȥ
			customer.getSetLinkMan().add(linkMan);
			//02-2.�ѿͻ�����ŵ���ϵ�˿ͻ���������ȥ
			linkMan.setCustomer(customer);
			
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
	
	//һ�Զ�ļ���ɾ��
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
			//01.����id��ѯcustomer����
			Customer customer = session.get(Customer.class, 8);
			//02.ִ��ɾ������
			session.delete(customer);
			
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
	
	//һ�Զ�ļ��������д����ͨ�������ļ�ʵ�֣�
	@Test
	public void testAddDemo2(){
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
			//01.����һ���ͻ�����ϵ��
			Customer customer = new Customer();
			customer.setCustName("ʮһ������");
			customer.setCustLevel("��ͨ�û�");
			customer.setCustMobile("634343");
			customer.setCustPhone("34340");
			customer.setCustSource("�Ǵ󷨹�");
			
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("С��");
			linkMan.setLkm_gender("������");
			linkMan.setLkm_phone("9��˹�ٷ�");
			
		    //02.�����ͻ��������ϵ�˶���֮��Ĺ�ϵ
			//����ϵ�˷ŵ��ͻ�ʵ��������set������ȥ
			customer.getSetLinkMan().add(linkMan);
			
			//03.�������ݵ����ݿ�
			session.save(customer);
			
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
	
	//һ�Զ�ļ������渴��д���������ã�
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
			//01.����һ���ͻ�����ϵ��
			Customer customer = new Customer();
			customer.setCustName("�ŵ�����");
			customer.setCustLevel("vip");
			customer.setCustMobile("999");
			customer.setCustPhone("110");
			customer.setCustSource("����");
			
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("����");
			linkMan.setLkm_gender("��");
			linkMan.setLkm_phone("911");
			
		    //02.�����ͻ��������ϵ�˶���֮��Ĺ�ϵ
			//02-1.����ϵ�˷ŵ��ͻ�ʵ��������set������ȥ
			customer.getSetLinkMan().add(linkMan);
			//02-2.�ѿͻ�����ŵ���ϵ�˿ͻ���������ȥ
			linkMan.setCustomer(customer);
			
			//03.�������ݵ����ݿ�
			session.save(customer);
			session.save(linkMan);
			
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
