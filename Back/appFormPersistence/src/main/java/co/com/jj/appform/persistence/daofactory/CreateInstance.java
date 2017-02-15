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
public class CreateInstance<T> {

    private static CreateInstance createInstance;

    private CreateInstance() {
    }

    public static CreateInstance getInstance() {
        if (createInstance == null) {
            createInstance = new CreateInstance();
        }
        return createInstance;
    }

    public T newInstance(FactoryIface<T> factoryIface) throws Exception {
        return factoryIface.newInstance();
    }

}
