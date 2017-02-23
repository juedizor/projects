/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.appformtransaction.iface;

/**
 *
 * @author julio.izquierdo
 * @param <T>
 */
public interface TransactionCallbackIface<T extends Object> {

    public T ejecutar() throws Exception;

}
