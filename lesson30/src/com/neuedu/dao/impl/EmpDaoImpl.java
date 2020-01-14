package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.dao.IEmpDao;
import com.neuedu.entity.Emp;
import com.neuedu.util.DBUtil;

public class EmpDaoImpl implements IEmpDao {

	@Override
	public int addEmp(Emp emp) {
		// 添加员工
		// 1.连接数据库
		Connection con = DBUtil.getConnection();
		// 2.创建statement对象
		String sql = "insert into emp (ename,empno,job,hiredate,mgr,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		int x = 0;
		try {
			pst = con.prepareStatement(sql);
			// 赋值占位符
			pst.setString(1, emp.getEname());
			pst.setInt(2, emp.getEmpno());
			pst.setString(3, emp.getJob());
			pst.setDate(4, new Date(emp.getHiredate().getTime()));// 注意：将util.Date转成子类sql.Date方式
			pst.setInt(5, emp.getMgr());
			pst.setDouble(6, emp.getSal());
			pst.setDouble(7, emp.getComm());
			pst.setInt(8, emp.getDeptno());

			// 3.执行sql语句
			x = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("创建PreparedStatement对象失败" + e.getMessage());
		} finally {
			DBUtil.closeAll(con, pst, null);
		}
		return x;
	}

	@Override
	public int delEmpById(int empno) {
		// 1.连接数据库
		Connection con = DBUtil.getConnection();
		// 2.创建statement对象
		String sql = "delete from emp where empno=?";
		PreparedStatement pst = null;
		int x = 0;
		try {
			pst = con.prepareStatement(sql);
			// 赋值占位符
			pst.setInt(1, empno);
			// 3.执行sql语句
			x = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("创建PreparedStatement对象失败" + e.getMessage());
		} finally {
			DBUtil.closeAll(con, pst, null);
		}
		return x;

	}

	@Override
	public int delEmpByIds(int[] arr) {
		// 1.连接数据库
		Connection con = DBUtil.getConnection();
		// 2.创建statement对象												
		PreparedStatement pst = null;
		int x = 0;
		try {
			String sql = "delete from emp where empno =? "; 
			pst = con.prepareStatement(sql);
			
			for (int i = 0; i < arr.length; i++) {
				pst.setInt(1, arr[i]);
				// 3.执行sql语句
				x = pst.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println("创建PreparedStatement对象失败" + e.getMessage());
		} finally {
			DBUtil.closeAll(con, pst, null);
		}
		return x;
	}

	@Override
	public int updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Emp> getAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> getEmpByName(String ename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp getEmpById(int empno) {
		// TODO Auto-generated method stub
		return null;
	}

}
