/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.daofactory;

import co.com.jj.appform.persistence.iface.generics.TransactionIface;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author julio.izquierdo
 */
public interface FactoryTransactionIface {
    
    public TransactionIface newInstance(PlatformTransactionManager platformTransactionManager) throws Exception;
    
}
