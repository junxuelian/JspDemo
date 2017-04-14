package com.ctgu.dao.impl;

/**
 * 2、数据访问层实现
 */
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.ctgu.dao.IEmployeeDao;
import com.ctgu.entity.Employee;
import com.ctgu.utils.JdbcUtils;
import com.ctgu.utils.PageBean;

public class EmployeeDao implements IEmployeeDao {

	@Override
	public void getAll(PageBean<Employee> pb) {
		
		//2、查询总记录数；设置到pd对象中
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		
		/**
		 * 问题：当前页为0，点击上一页会报错，当前页为末页，下一页会报错
		 * 解决：当前<0,设置为1.当前页>末页，设置为末页。
		 */
		if(pb.getCurrentPage() <= 0) {
			pb.setCurrentPage(1);
		} else if (pb.getCurrentPage()> pb.getTotalPage()) {
			pb.setCurrentPage(pb.getTotalPage());
		}
		//1、获取当前页，计算查询的起始行、返回的行数
				int currentPage = pb.getCurrentPage();
				int index = (currentPage - 1) * pb.getPageCount();
				int count = pb.getPageCount();
		
		//3、分页查询数据；把查询的数据设置到pb对象中
		String sql = "select * from employee limit ?,?";
		//得到QueryRunner对象
		try {
			QueryRunner qr = JdbcUtils.getQueryRunner();
			List<Employee> pagedata = qr.query(sql, new BeanListHandler<Employee>(Employee.class), index, count);
			pb.setPageData(pagedata);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from employee";
		try {
			//创建QueryRunner对象
			QueryRunner qr = JdbcUtils.getQueryRunner();
			//执行查询，返回结果的第一行第一列
			Long count = qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
