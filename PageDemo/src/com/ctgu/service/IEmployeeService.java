package com.ctgu.service;

import com.ctgu.entity.Employee;
import com.ctgu.utils.PageBean;

/**
 * 3、业务逻辑层接口设计
 * @author chenjun
 *
 */
public interface IEmployeeService {
	/**
	 * 分页查询
	 */
	public void getAll(PageBean<Employee> pb);
}
