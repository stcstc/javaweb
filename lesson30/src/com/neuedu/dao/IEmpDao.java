package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Emp;

public interface IEmpDao {
    //增加员工
	public int addEmp(Emp emp);
	//删除员工:根据员工编号
	public int delEmpById(int empno);
	//批量删除员工：根据员工编号
	public int delEmpByIds(int empno[]);
	//修改员工
	public int updateEmp(Emp emp);
	//查询所有员工
	public List<Emp> getAllEmps();
	//查询员工：根据名字
	public List<Emp> getEmpByName(String ename);
	//查询员工：根据员工编号
	public Emp getEmpById(int empno);
	
}
