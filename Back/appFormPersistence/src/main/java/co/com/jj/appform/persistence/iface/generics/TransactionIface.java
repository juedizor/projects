/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface.generics;

import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author julio.izquierdo
 * @param <T>
 */
public interface TransactionIface<T> {

    DefaultTransactionDefinition getDefaultTransactionDefinition() throws Exception;

    public <T extends Object> T execute(TransactionCallbackIface<T> action) throws TransactionException, Exception;

}
