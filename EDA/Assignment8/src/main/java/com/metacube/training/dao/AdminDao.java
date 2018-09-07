package com.metacube.training.dao;

import java.util.List;

public interface AdminDao<Type> {

	Type getFieldById(int id);

	List<Type> getListOfField();

	boolean deleteFieldById(int id);

	boolean updateFieldById(Type field);

	boolean createField(Type field);
}
