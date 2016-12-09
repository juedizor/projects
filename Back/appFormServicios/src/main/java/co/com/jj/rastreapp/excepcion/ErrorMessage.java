/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.excepcion;

/**
 *
 * @author jeio
 */
public class ErrorMessage {

    private String error;
    private String description;

    public ErrorMessage(Exception exception) {
        this(exception.getClass().getSimpleName(), exception.getMessage());
    }

    public ErrorMessage(String error, String description) {
        this.error = error;
        this.description = description;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ApiErrorMessage [error=" + error + ", description=" + description + "]";
    }

}
