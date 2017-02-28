/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.msginternacionalizacion.factory;

import co.com.jj.appform.msginternacionalizacion.ReadMsgIface;
import co.com.jj.appform.msginternacionalizacion.ReadMsgImpl;

/**
 *
 * @author julio.izquierdo
 */
public class ConcretRead implements Creator {

    private static Creator creator;

    private ConcretRead() {
    }

    public static Creator getInstance() {
        if (creator == null) {
            creator = new ConcretRead();
        }
        return creator;
    }

    @Override
    public ReadMsgIface newInstance() {
        return new ReadMsgImpl();
    }

}
