package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.JobTitle;

public class JobTitleDao implements AdminDao<JobTitle> {

    @Override
    public JobTitle getFieldById(int id) {
	    
        return null;
    }

    @Override
    public List<JobTitle> getListOfField() {
        return null;
    }

    @Override
    public boolean deleteFieldById(int id) {
         return false;
    }

    @Override
    public boolean updateFieldById(JobTitle jobTitle) {
        return false;
    }

    @Override
    public boolean createField(JobTitle jobTitle) {
        return false;
    }
}
