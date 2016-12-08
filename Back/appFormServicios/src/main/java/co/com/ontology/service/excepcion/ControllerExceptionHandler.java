/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ontology.service.excepcion;

import org.apache.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author jeio
 */
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ExceptionGenerics.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: NOT_FOUND, " + errorMessage);
        return errorMessage;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ExceptionGenerics.class})
    @ResponseBody
    public ErrorMessage success(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: NOT_FOUND, " + errorMessage);
        return errorMessage;
    }

}
