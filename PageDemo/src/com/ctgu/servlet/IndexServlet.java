package com.ctgu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.entity.Employee;
import com.ctgu.service.IEmployeeService;
import com.ctgu.service.impl.EmployeeService;
import com.ctgu.utils.PageBean;

/**
 * 4、控制层开发
 * @author chenjun
 *
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	
	//创建Service实例
	private IEmployeeService employeeService = new EmployeeService();
	
	private String uri;
	
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1、获取当前页参数；(第一次访问当前页为null)
			String currPage = request.getParameter("currentPage");
			if(currPage == null || "".equals(currPage.trim())) {
				currPage = "1";
			}
			
			int currentPage = Integer.parseInt(currPage);
			
			//2、创建PageBean对象，设置当前页参数，传入service参数
			PageBean<Employee> pageBean = new PageBean<Employee>();
			pageBean.setCurrentPage(currentPage);
			
			//3、调用service
			employeeService.getAll(pageBean);
			
			//4、保存pageBean对象到域对象中
			request.setAttribute("pageBean", pageBean);
			
			//5.跳转
			uri = "/WEB-INF/list.jsp";
		} catch (Exception e) {
			uri = "error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
