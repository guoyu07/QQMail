package cn.lonecloud.model;

import java.io.Serializable;

public class Department implements Serializable{
	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -5466600720526389435L;
	private String id;
	private String name;
	private String parentid;
	private String order;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", parentid="
				+ parentid + ", order=" + order + "]";
	}
	
}
