package com.neuedu.test;

import java.util.Date;

import com.neuedu.dao.impl.EmpDaoImpl;
import com.neuedu.entity.Emp;

public class Test {

	public static void main(String[] args) {
		//�������Ա��
		EmpDaoImpl dao=new EmpDaoImpl();
/*		
		Emp emp=new Emp();
		emp.setEmpno(2020);
		emp.setEname("����1");
		emp.setHiredate(new Date());
		emp.setDeptno(10);
		
		System.out.println(emp);
		
		int x=dao.addEmp(emp);
		if(x>0){
			System.out.println("����ɹ�");
		}else{
			System.out.println("����ʧ��");
		}
		*/
		//����ɾ��Ա��
/*		int x=dao.delEmpById(1);
		if(x>0){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}*/
		
		//����ɾ��
		int arr[]={8888,9999};
		int x=dao.delEmpByIds(arr);
		if(x>0){
			System.out.println("����ɾ���ɹ�");
		}else{
			System.out.println("����ɾ��ʧ��");
		}

	}

}
