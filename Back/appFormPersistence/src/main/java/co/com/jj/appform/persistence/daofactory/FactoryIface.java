/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.daofactory;

/**
 *
 * @author jeio
 * @param <T>
 */
public interface FactoryIface<T> {
    
    public T newInstance() throws Exception;
    
}
