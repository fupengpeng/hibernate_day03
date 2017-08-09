package com.jiudianlianxian.manytomany;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * Title: Role
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: hibernate_day03
 * @author fupengpeng
 * @date 2017年8月9日 上午9:29:38
 */
public class Role {
	private Integer role_id;
	private String role_name;
	private String role_memo;
	
	//一个角色有多个用户
	private Set<User> setUser = new HashSet<User>();

	
	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_memo() {
		return role_memo;
	}

	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}

	public Set<User> getSetUser() {
		return setUser;
	}

	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
	}
	
}
