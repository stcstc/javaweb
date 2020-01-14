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
		// ���Ա��
		// 1.�������ݿ�
		Connection con = DBUtil.getConnection();
		// 2.����statement����
		String sql = "insert into emp (ename,empno,job,hiredate,mgr,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		int x = 0;
		try {
			pst = con.prepareStatement(sql);
			// ��ֵռλ��
			pst.setString(1, emp.getEname());
			pst.setInt(2, emp.getEmpno());
			pst.setString(3, emp.getJob());
			pst.setDate(4, new Date(emp.getHiredate().getTime()));// ע�⣺��util.Dateת������sql.Date��ʽ
			pst.setInt(5, emp.getMgr());
			pst.setDouble(6, emp.getSal());
			pst.setDouble(7, emp.getComm());
			pst.setInt(8, emp.getDeptno());

			// 3.ִ��sql���
			x = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("����PreparedStatement����ʧ��" + e.getMessage());
		} finally {
			DBUtil.closeAll(con, pst, null);
		}
		return x;
	}

	@Override
	public int delEmpById(int empno) {
		// 1.�������ݿ�
		Connection con = DBUtil.getConnection();
		// 2.����statement����
		String sql = "delete from emp where empno=?";
		PreparedStatement pst = null;
		int x = 0;
		try {
			pst = con.prepareStatement(sql);
			// ��ֵռλ��
			pst.setInt(1, empno);
			// 3.ִ��sql���
			x = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("����PreparedStatement����ʧ��" + e.getMessage());
		} finally {
			DBUtil.closeAll(con, pst, null);
		}
		return x;

	}

	@Override
	public int delEmpByIds(int[] arr) {
		// 1.�������ݿ�
		Connection con = DBUtil.getConnection();
		// 2.����statement����												
		PreparedStatement pst = null;
		int x = 0;
		try {
			String sql = "delete from emp where empno =? "; 
			pst = con.prepareStatement(sql);
			
			for (int i = 0; i < arr.length; i++) {
				pst.setInt(1, arr[i]);
				// 3.ִ��sql���
				x = pst.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println("����PreparedStatement����ʧ��" + e.getMessage());
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
