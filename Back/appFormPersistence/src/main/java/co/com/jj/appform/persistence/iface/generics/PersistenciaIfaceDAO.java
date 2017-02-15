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
 * @param <T2>
 */
public interface PersistenciaIfaceDAO<T, T2> {

    void save(T object) throws Exception;

    void merge(T object, T2 objectAct) throws Exception;

    List<T> findAll() throws Exception;

    List<T> findByPrimaryKey(T object) throws Exception;
    

}
