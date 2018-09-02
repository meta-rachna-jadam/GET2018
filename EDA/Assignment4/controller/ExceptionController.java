package com.controller;

import com.enums.Status;
import com.facade.ExceptionFacade;
import com.model.DatabaseException;

public class ExceptionController {

private ExceptionFacade exceptionFacade = ExceptionFacade.getInstance();
    
    public Status createExeption(DatabaseException exception) {
        return exceptionFacade.create(exception);
    }
}
