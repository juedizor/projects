/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.appformtransaction.factory;

import co.com.jj.appform.appformtransaction.iface.TransactionIface;
import co.com.jj.appform.appformtransaction.impl.TransactionImpl;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author julio.izquierdo
 */
public class FactoryTransaction implements FactoryTransactionIface{
    
    private static FactoryTransactionIface factoryIface;
    
    private FactoryTransaction(){
        
    }
    
    public static FactoryTransactionIface getInstance(){
        if(factoryIface == null){
            factoryIface = new FactoryTransaction();
        }
        return factoryIface;
    }

    @Override
    public TransactionIface newInstance(PlatformTransactionManager platformTransactionManager) throws Exception {
        return new TransactionImpl(platformTransactionManager);
    }


    
}
