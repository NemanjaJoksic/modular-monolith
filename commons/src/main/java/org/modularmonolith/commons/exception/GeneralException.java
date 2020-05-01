/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modularmonolith.commons.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author joksin
 */
public class GeneralException extends Exception {
    
    public static final String WARNING = "warning";
    public static final String ERROR = "error";
    
    @Getter
    private final String status;
    @Getter
    private final String message;
    @Getter
    private final HttpStatus httpStatus;

    public GeneralException(String status, String message, HttpStatus httpStatus) {
        super(message);
        this.status = status;
        this.message = message;
        this.httpStatus = httpStatus;
    }
    
    public GeneralException(Exception ex) {
        super(ex);
        this.status = ERROR;
        this.message = ex.getMessage();
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
    
}
