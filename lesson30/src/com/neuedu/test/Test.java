package com.neuedu.test;

import java.util.Date;

import com.neuedu.dao.impl.EmpDaoImpl;
import com.neuedu.entity.Emp;

public class Test {

	public static void main(String[] args) {
		//测试添加员工
		EmpDaoImpl dao=new EmpDaoImpl();
/*		
		Emp emp=new Emp();
		emp.setEmpno(2020);
		emp.setEname("测试1");
		emp.setHiredate(new Date());
		emp.setDeptno(10);
		
		System.out.println(emp);
		
		int x=dao.addEmp(emp);
		if(x>0){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
		}
		*/
		//测试删除员工
/*		int x=dao.delEmpById(1);
		if(x>0){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}*/
		
		//批量删除
		int arr[]={8888,9999};
		int x=dao.delEmpByIds(arr);
		if(x>0){
			System.out.println("批量删除成功");
		}else{
			System.out.println("批量删除失败");
		}

	}

}
