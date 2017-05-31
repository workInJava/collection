package com.collection.project.service;

import com.test.project.po.gen.Role;

public interface IRoleService {
	public Role createRole(Role role);

	public void deleteRole(Long roleId);

	// ��ӽ�ɫ-Ȩ��֮���ϵ
	public void correlationPermissions(Long roleId, Long... permissionIds);

	// �Ƴ���ɫ-Ȩ��֮���ϵ
	public void uncorrelationPermissions(Long roleId, Long... permissionIds);//
}