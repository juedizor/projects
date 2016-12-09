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
public class ExceptionGenerics extends Exception{
    
    private static String descripcion;
    private static int codigo;

    public ExceptionGenerics() {
        this("");
    }

    public ExceptionGenerics(String detail) {
        super(descripcion + ". " + detail + ". CODE: " + codigo);
    }

    public static String getDescripcion() {
        return descripcion;
    }

    public static void setDescripcion(String descripcion) {
        ExceptionGenerics.descripcion = descripcion;
    }

    public static int getCodigo() {
        return codigo;
    }

    public static void setCodigo(int codigo) {
        ExceptionGenerics.codigo = codigo;
    }
    
    
    
    
    
}
