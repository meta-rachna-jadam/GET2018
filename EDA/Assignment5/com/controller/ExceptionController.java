package com.controller;

import com.enums.Status;
import com.facade.ExceptionFacade;
import com.model.CustemException;;

public class ExceptionController {

private ExceptionFacade exceptionFacade = ExceptionFacade.getInstance();
    
    public Status createExeption(CustemException exception) {
        return exceptionFacade.create(exception);
    }
}
