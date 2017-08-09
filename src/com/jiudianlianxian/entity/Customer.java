package com.jiudianlianxian.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Title: Customer
 * Description: 一      客户实体类
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: hibernate_day03
 * @author fupengpeng
 * @date 2017年8月8日 下午2:48:00
 */
public class Customer {
	private Integer cid;
	private String custName;
	private String custLevel;
	private String custSource;
	private String custPhone;
	private String custMobile;

	// 在客户实体类里面表示多个联系人，一个客户有多个联系人
	// hibernate要求使用集合表示多的数据，使用set集合（固定要求，无序）
	private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();

	
	
	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}

	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}

	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
}
