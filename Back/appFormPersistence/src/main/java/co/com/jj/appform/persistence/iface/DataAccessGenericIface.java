/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

/**
 * interface para establecer conexión a base de datos
 *
 * @author jeio
 */
public interface DataAccessGenericIface {

    void closeConection() throws Exception;

    void openConection() throws Exception;

    void getConection() throws Exception;
    
    void initTransaction() throws Exception;
    
    void commitTransaction() throws Exception;
    
    void rollBackTransaccion() throws Exception;
}
