package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.UserRole;

public class UserRoleDao implements AdminDao<UserRole> {

    @Override
    public UserRole getFieldById(int id) {
	    
        return null;
    }

    @Override
    public List<UserRole> getListOfField() {
        return null;
    }

    @Override
    public boolean deleteFieldById(int id) {
         return false;
    }

    @Override
    public boolean updateFieldById(UserRole userRole) {
        return false;
    }

    @Override
    public boolean createField(UserRole userRole) {
        return false;
    }
}

