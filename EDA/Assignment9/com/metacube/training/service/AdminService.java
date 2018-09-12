package com.metacube.training.service;

import java.util.List;

public interface AdminService<Type> {

	Type getFieldById(int id);

	List<Type> getListOfField();

	boolean deleteFieldById(int id);

	boolean updateFieldById(Type field);

	boolean createField(Type field);
}
