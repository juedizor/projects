/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.iface;

/**
 *
 * @author julio
 * @param <T>
 */
public interface GestionBusinessIface <T>{
    
    void registrar(T t);
    void actualizar(T t);
    
}
