/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface.generics;

import java.util.List;

/**
 *
 * @author jeio
 * @param <T>
 */
public interface PersistenciaIfaceDAO<T> {

    void save(T object) throws Exception;

    void merge(T object) throws Exception;

    List<T> findAll() throws Exception;

    List<T> findById(T object) throws Exception;
    

}
