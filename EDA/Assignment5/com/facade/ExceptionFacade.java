package com.facade;

import com.dao.ExceptionDao;
import com.enums.Status;
import com.model.CustemException;

public class ExceptionFacade {

	private static ExceptionFacade exceptionFacade = new ExceptionFacade();
	ExceptionDao exceptionDao = new ExceptionDao();

    public static ExceptionFacade getInstance() {
        return exceptionFacade;
    }
    
    public Status create(CustemException exception) {
    	int state = exceptionDao.addException(exception);
        if (state > 0) {
        	return Status.CREATED;
        } else if (state < 0) {
        	return Status.ERROR;
        } else {
        	return Status.NOT_CREATED;
        }
    }
}
