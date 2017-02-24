/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.cloneclasstoclass;

import co.com.jj.appform.cloneclasstoclass.util.ReadProperties;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julio.izquierdo
 * @param <T1>
 * @param <T2>
 */
public class CopyClassImpl<T1, T2> implements CopyClassIface<T1, T2> {

    static {
        try {
            ReadProperties.getInstance().setMensajes();
        } catch (Exception ex) {
            Logger.getLogger(CopyClassImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setFieldClassToClass(Field[] fieldClassRaiz, Field[] fieldClassDestino, T1 class1, T2 class2) throws IllegalArgumentException, IllegalAccessException {
        for (Field field1 : fieldClassRaiz) {
            field1.setAccessible(true);
            int i = 0;
            for (Field field2 : fieldClassDestino) {
                if (field1.getName().equals(field2.getName())) {
                    field2.setAccessible(true);
                    field2.set(class2, field1.get(class1));
                    fieldClassDestino[i] = field2;
                    field2.setAccessible(false);
                    break;
                }
                i++;
                
            }
            field1.setAccessible(false);
        }
    }

    @Override
    public T2 copyDataClassToClass(T1 class1, T2 class2) throws IllegalArgumentException, IllegalAccessException {
        if (class1 == null) {
            throw new IllegalAccessException(ReadProperties.getInstance().getMapMsg().get("error_class_params_1"));
        }

        if (class2 == null) {
            throw new IllegalAccessException(ReadProperties.getInstance().getMapMsg().get("error_class_params_2"));
        }

        Class classRaiz = class1.getClass();
        Class classDestino = class2.getClass();
        Field[] fieldClassRaiz = classRaiz.getDeclaredFields();
        Field[] fieldClassDestino = classDestino.getDeclaredFields();
        setFieldClassToClass(fieldClassRaiz, fieldClassDestino, class1, class2);
        return class2;
    }

}
