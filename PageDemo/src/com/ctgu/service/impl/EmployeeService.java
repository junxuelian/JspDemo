package com.ctgu.service.impl;

import com.ctgu.dao.IEmployeeDao;
import com.ctgu.dao.impl.EmployeeDao;
import com.ctgu.entity.Employee;
import com.ctgu.service.IEmployeeService;
import com.ctgu.utils.PageBean;

/**
 * 业务逻辑层，实现
 * @author chenjun
 *
 */

public class EmployeeService implements IEmployeeService {
	
	//创建Dao实例
	private IEmployeeDao employeeDao = new EmployeeDao();
	
	@Override
	public void getAll(PageBean<Employee> pb) {
		try {
			employeeDao.getAll(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
