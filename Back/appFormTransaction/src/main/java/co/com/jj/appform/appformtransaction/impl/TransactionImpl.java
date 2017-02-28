/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.appformtransaction.impl;

import co.com.jj.appform.appformtransaction.iface.TransactionCallbackIface;
import co.com.jj.appform.appformtransaction.iface.TransactionIface;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author julio.izquierdo
 * @param <T>
 */
public class TransactionImpl<T> extends TransactionTemplate implements TransactionIface<T> {

    public TransactionImpl(PlatformTransactionManager platformTransactionManager) throws Exception {
        super(platformTransactionManager);
    }

    @Override
    public DefaultTransactionDefinition getDefaultTransactionDefinition() {
        return new DefaultTransactionDefinition();
    }

    @Override
    public <T extends Object> T execute(TransactionCallbackIface<T> action) throws TransactionException, Exception {
        T t;
        TransactionStatus status = getTransactionManager().getTransaction(getDefaultTransactionDefinition());
        try {
            t = action.ejecutar();
            getTransactionManager().commit(status);
            return t;
        } catch (Exception e) {
            getTransactionManager().rollback(status);
            throw new Exception(e.getMessage(), e);
        }
    }

}
