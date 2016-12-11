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
public class Message {

    private String code;
    private String description;

    public Message(Exception exception) {
        this(exception.getClass().getSimpleName(), exception.getMessage());
    }

    public Message(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ApiErrorMessage [error=" + code + ", description=" + description + "]";
    }

}
