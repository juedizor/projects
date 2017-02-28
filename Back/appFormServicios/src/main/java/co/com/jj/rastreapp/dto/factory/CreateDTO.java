/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.dto.factory;

/**
 *
 * @author julio
 * @param <T>
 */
public class CreateDTO<T> {
    
    public T createInstance(FactoryDTOIface<T> factoryDTOIface){
        return factoryDTOIface.createInstance();
    } 
    
}
