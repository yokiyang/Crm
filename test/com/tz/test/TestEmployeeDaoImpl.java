package com.tz.test;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.tz.emp.dao.IEmployeeDao;
import com.tz.emp.service.IEmployeeService;
import com.tz.entity.Employee;
import com.tz.util.BeanFactory;
import com.tz.util.DateUtil;

public class TestEmployeeDaoImpl {
	
	IEmployeeDao employeeDao = (IEmployeeDao) BeanFactory.getBean("employeeDao");
	IEmployeeService employeeService = (IEmployeeService) BeanFactory.getBean("employeeService");
	@Test
	public void testDDL(){
		Configuration cfg=new Configuration().configure();
		SchemaExport export=new SchemaExport(cfg);
		export.create(true,true);
	}
	
	@Test
	public void testSelectAllEmps(){
		List<Employee> employees=employeeDao.selectAllEmps();
		if(employees!=null && employees.size()>0){
			for(Employee e:employees){
				System.out.println(e);
			}
			
		}
	}
	@Test
	public void testremoveEmpById(){
		boolean b=employeeService.removeEmpById(6L);
		System.out.println(b);
	}
	
	@Test
	public void testSave(){
		Employee emp=new Employee("李四","销售",1000.00,DateUtil.createDate(2014, 10, 9));
		boolean bool=employeeDao.saveOrUpdateEmp(emp);
		System.out.println(bool);
	}
	
	@Test
	public void testSave1(){
		Employee emp=new Employee("李四","销售",6000.00,DateUtil.createDate(2014, 10, 9));
		emp.setId(11L);
		boolean bool=employeeDao.saveOrUpdateEmp(emp);
		System.out.println(bool);
	}
	
	@Test
	public void testRegister(){
		Employee emp=new Employee("rose","销售",10000,DateUtil.createDate(2013, 11, 9));		
		boolean bool=employeeService.registerOrEditEmp(emp);
		System.out.println(bool);
	}
	
	@Test
	public void testFindById(){
		Employee emp=employeeService.findById(11L);
		System.out.println(emp);
	}
	
	@Test
	public void testselectByName(){
		List<Employee> emps=employeeDao.selectByName("a");
		for(Employee e:emps){
			System.out.println(e);
		}
	}
	
	@Test
	public void testselectByTitle(){
		List<Employee> emps=employeeDao.selectByTitle("经理");
		for(Employee e:emps){
			System.out.println(e);
		}
	}
	
	@Test
	public void testselectBySalary(){
		List<Employee> emps=employeeDao.selectBySalary(6000, 8000);
		for(Employee e:emps){
			System.out.println(e);
		}
	}
	
	@Test
	public void testselectByHiredate(){
		List<Employee> emps=employeeDao.selectByHireDate(DateUtil.createDate(2016, 11, 1), DateUtil.createDate(2016, 12, 31));
		for(Employee e:emps){
			System.out.println(e);
		}
	}
	
	@Test
	public void testgetRowCount(){
		long count=employeeService.getRowCount();
		System.out.println(count);
	}
	
	@Test
	public void testselectByPage(){
		List<Employee> emps=employeeDao.selectByPage(1, 5);
		for(Employee e:emps){
			System.out.println(e);
		}
	}
	
	@Test
	public void testUpdateById(){
		Employee emp=employeeDao.updateSalaryById(27L, 8000);
		System.out.println(emp);
	}
	
}
