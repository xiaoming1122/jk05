package com.itheima.web.action.sysadmin;

import com.itheima.domain.Dept;
import com.itheima.service.DeptService;
import com.itheima.utils.Page;
import com.itheima.web.action.BaseAction;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;



public class DeptAction extends BaseAction implements ModelDriven<Dept> {
	private Dept model = new Dept();
	public Dept getModel() {
		return model;
	}
	
	//注入业务逻辑
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	//分页组件
	private Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}


	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		//1.调用业务逻辑，实现分页查询
		deptService.findPage("from Dept", page, Dept.class, null);
		
		//2.设置分页组件的url
		  page.setUrl("deptAction_list");//相对路径   http://localhost:8080/jksz05/sysadmin/deptAction_list
		//page.setUrl(ServletActionContext.getRequest().getContextPath()+"/sysadmin/deptAction_list");//绝对定位
		
		//3.将page对象放入值栈的栈顶
		super.push(page);
		
		//4.跳页面
		return "list";
	}
	
	
	/**
	 * 查看详情
	 * 
	 * <input type="checkbox" name="id" value="${dept.id }"/>
	 * model  
	 *     id
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toview() throws Exception {
		//1.根据用户选中的部门编号 ，进行查询
		Dept obj = deptService.get(Dept.class, model.getId());
		//2.将查询的部门对象，放入值栈中
		super.push(obj);
		
		//3.跳页面
		return "toview";
	}

	
}
