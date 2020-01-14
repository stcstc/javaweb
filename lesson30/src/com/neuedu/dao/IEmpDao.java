package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Emp;

public interface IEmpDao {
    //����Ա��
	public int addEmp(Emp emp);
	//ɾ��Ա��:����Ա�����
	public int delEmpById(int empno);
	//����ɾ��Ա��������Ա�����
	public int delEmpByIds(int empno[]);
	//�޸�Ա��
	public int updateEmp(Emp emp);
	//��ѯ����Ա��
	public List<Emp> getAllEmps();
	//��ѯԱ������������
	public List<Emp> getEmpByName(String ename);
	//��ѯԱ��������Ա�����
	public Emp getEmpById(int empno);
	
}
