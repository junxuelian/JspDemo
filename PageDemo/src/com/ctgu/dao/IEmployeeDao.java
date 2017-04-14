package com.ctgu.dao;

import com.ctgu.entity.Employee;
import com.ctgu.utils.PageBean;

/**
 * 2、数据库访问层，接口设计
 * @author chenjun
 *
 */

public interface IEmployeeDao {
	
	/**
	 * 分页查询数据
	 * @param <T>
	 */
	public void getAll(PageBean<Employee> pb);
	
	/**
	 * 查询总记录数
	 */
	public int getTotalCount();
}
