package com.metacube.training.dao.query;

public interface AddressQuery {

	String CREATE_ADDRESS = "INSERT INTO address (emp_code, add_line_1, add_line_2, city, state, pincode) "
			              + "VALUES (?, ?, ?, ?, ?, ?)";

    String UPDATE_ADDRESS_BY_ID = "UPDATE address SET emp_code = ?, add_line_1 = ?, add_line_2 = ?, city= ?, "
    		                    + "state= ? WHERE address_id = ?";

    //String DELETE_ADDRESS_BY_ID = "UPDATE address SET enabled = ? WHERE address_id = ?";

    String GET_ALL_ADDRESS_OF_EMPLOYEE_BY_EMPLOYEE_ID = "SELECT address_id, emp_code, add_line_1, add_line_2, "
    		                                          + "city, state, pincode FROM address "
    		                                          + "WHERE emp_code = ?";

    String GET_ADDRESS_BY_ID = "SELECT address_id, emp_code, add_line_1, add_line_2, city, state, pincode "
    		                 + "FROM address WHERE address_id = ?"; 
    
}
