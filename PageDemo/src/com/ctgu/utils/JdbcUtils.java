package com.ctgu.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 工具类
 * 初始化c3p0连接池
 * 创建DBUtils核心工具类
 * @author chenjun
 *
 */

public class JdbcUtils {
	/**
	 * 1、初始化C3P0连接池
	 */
	private static DataSource datasource;
	static {
		datasource = new ComboPooledDataSource();
	}
	
	/**
	 * 2、创建DBUtils核心工具类
	 */
	public static QueryRunner getQueryRunner(){
		//创建QueryRunner对象，传入连接池对象
		return new QueryRunner(datasource);
	}
}
