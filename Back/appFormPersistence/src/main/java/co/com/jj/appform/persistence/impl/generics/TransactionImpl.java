/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl.generics;

import co.com.jj.appform.persistence.iface.generics.TransactionCallbackIface;
import co.com.jj.appform.persistence.iface.generics.TransactionIface;
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

    private TransactionTemplate transactionTemplate;

    public TransactionImpl(PlatformTransactionManager platformTransactionManager) throws Exception {
        super(platformTransactionManager);
    }
    

    @Override
    public TransactionTemplate getTransactionTemplate() throws Exception{
        return transactionTemplate;
    }

    @Override
    public DefaultTransactionDefinition getDefaultTransactionDefinition() {
        return new DefaultTransactionDefinition();
    }

    @Override
    public void setTransactionTemplate(PlatformTransactionManager platformTransactionManager) throws Exception {
        transactionTemplate = new TransactionTemplate(platformTransactionManager);
    }
    
    @Override
    public <T extends Object> T execute(TransactionCallbackIface<T> action) throws TransactionException, Exception {
        T t = null;
        TransactionStatus status = getTransactionManager().getTransaction(getDefaultTransactionDefinition());
        try {
            t = action.ejecutar();
            getTransactionManager().commit(status);
        }catch (Exception e){
            getTransactionManager().rollback(status);
            throw new Exception(e.getMessage(), e);
        }
        return t;
    }
    
    
    
    
}
