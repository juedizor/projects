/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.cloneclasstoclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 *
 * @author julio.izquierdo
 * @param <T1>
 * @param <T2>
 */
public class CopyClassImpl<T1, T2> implements CopyClassIface<T1, T2> {

    private void setFieldClassToClass(Field[] fieldClassRaiz, Field[] fieldClassDestino, T1 class1, T2 class2) throws IllegalArgumentException, IllegalAccessException {
        for (Field field1 : fieldClassRaiz) {
            field1.setAccessible(true);
            int i = 0;
            for (Field field2 : fieldClassDestino) {
                if (field1.getName().equals(field2.getName())) {
                    field2.setAccessible(true);
                    field2.set(class2, field1.get(class1));
                    fieldClassDestino[i] = field2;
                    break;
                }
                i++;
            }
        }
    }

    @Override
    public T2 copyDataClassToClass(T1 class1, T2 class2) throws IllegalArgumentException, IllegalAccessException {
        if (class1 == null) {
            throw new IllegalAccessException("Params 1 no posee instancia");
        }

        if (class2 == null) {
            throw new IllegalAccessException("Params 2 no posee instancia");
        }

        Class classRaiz = class1.getClass();
        Class classDestino = class2.getClass();
        Field[] fieldClassRaiz = classRaiz.getDeclaredFields();
        Field[] fieldClassDestino = classDestino.getDeclaredFields();
        setFieldClassToClass(fieldClassRaiz, fieldClassDestino, class1, class2);
        return class2;
    }

}
