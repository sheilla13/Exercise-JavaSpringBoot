package com.batm.Day2.services;

import com.batm.Day2.entities.Role;

import java.util.List;

public interface RoleService {
    public boolean saveRole(Role role);
    public List<Role> findAllRoles();
    public Role findRoleById(int id);
    public boolean deleteRoleById(int id);
}