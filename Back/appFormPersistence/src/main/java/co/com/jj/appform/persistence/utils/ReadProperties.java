/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.utils;

import co.com.jj.appform.msginternacionalizacion.ReadMsgIface;
import co.com.jj.appform.msginternacionalizacion.factory.ConcretRead;
import co.com.jj.appform.msginternacionalizacion.factory.Creator;
import java.util.Map;

/**
 *
 * @author julio.izquierdo
 */
public class ReadProperties {

    private Map<String, String> mapMsgException;
    private Map<String, String> mapMsgConfig;
    private ReadMsgIface readMsgIface;
    private static final String LANGUAGE_CONFIGURACION = "language/configuracionimpl/msg_exception";
    static final String RESOURCE_CONFIG = "config/config";
    private static ReadProperties readProperties;
    

    private ReadProperties() {
        
    }
    
    public static ReadProperties getInstance(){
        if(readProperties == null){
            readProperties = new ReadProperties();
        }
        return readProperties;
    }

    public void setMensajes() throws Exception {
        Creator creator = ConcretRead.getInstance();
        readMsgIface = creator.newInstance();
        mapMsgException = readMsgIface.getEtiquetas(LANGUAGE_CONFIGURACION);
        mapMsgConfig = readMsgIface.getEtiquetas(RESOURCE_CONFIG);
    }

    public Map<String, String> getMapMsgException() {
        return mapMsgException;
    }

    public Map<String, String> getMapMsgConfig() {
        return mapMsgConfig;
    }


    
    
    

}
