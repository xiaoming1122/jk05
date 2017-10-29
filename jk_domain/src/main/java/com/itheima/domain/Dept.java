package com.itheima.domain;

import java.io.Serializable;

public class Dept implements Serializable {
   private String id;
   private String deptName;//部门名称
   private Dept parent;     //自关联      父部门       子部门与父部门    多对一
   
   private Integer state;//状态   0代表停用    1启用，默认为启用

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getDeptName() {
	return deptName;
}

public void setDeptName(String deptName) {
	this.deptName = deptName;
}

public Dept getParent() {
	return parent;
}

public void setParent(Dept parent) {
	this.parent = parent;
}

public Integer getState() {
	return state;
}

public void setState(Integer state) {
	this.state = state;
}
   

}
