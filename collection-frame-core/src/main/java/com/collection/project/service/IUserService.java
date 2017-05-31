package com.collection.project.service;

import java.util.List;

import com.test.project.po.gen.UserDetail;

public interface IUserService {
	public UserDetail createUser(UserDetail user);// �����û�
	public UserDetail updateUser(UserDetail user);// �����û�
	public void deleteUser(Long userId);// ɾ���û�
	public void changePassword(Long userId, String newPassword); //�޸�����
	UserDetail findOne(Long userId);// ����id �����û�
	List<UserDetail> findAll();// �õ������û�
	public UserDetail findByUsername(String username);// �����û��������û�
}
