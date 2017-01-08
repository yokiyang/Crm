package com.tz.emp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.emp.service.IEmployeeService;
import com.tz.entity.Employee;
import com.tz.util.BeanFactory;

@SuppressWarnings("serial")
@WebServlet(name="EmpEditAction",urlPatterns="/permission/emp/editSalary")
public class EmpEditAction extends HttpServlet {
	IEmployeeService employeeService = (IEmployeeService) BeanFactory
			.getBean("employeeService");
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		String salary=request.getParameter("salary");
		Employee emp=employeeService.editSalaryById(Long.parseLong(id)
				, Double.parseDouble(salary));
		if(emp!=null){
			out.print("0");
		}else{
			out.print("1");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
