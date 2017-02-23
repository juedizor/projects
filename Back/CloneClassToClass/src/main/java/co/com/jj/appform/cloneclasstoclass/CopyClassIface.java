/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.cloneclasstoclass;

/**
 *
 * @author julio.izquierdo
 * @param <T1>
 * @param <T2>
 */
public interface CopyClassIface<T1, T2> {

    T2 copyDataClassToClass(T1 class1, T2 class2) throws IllegalArgumentException, IllegalAccessException;
}
