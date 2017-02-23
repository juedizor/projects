/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.msginternacionalizacion.factory;

import co.com.jj.appform.msginternacionalizacion.ReadMsgIface;

/**
 *
 * @author julio.izquierdo
 */
public interface Creator {
    
    ReadMsgIface newInstance();
    
}
