/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.util;

import co.com.jj.appform.msginternacionalizacion.ReadMsgIface;
import co.com.jj.appform.msginternacionalizacion.factory.ConcretRead;
import co.com.jj.appform.msginternacionalizacion.factory.Creator;
import java.util.Map;

/**
 *
 * @author julio.izquierdo
 */
public class ReadProperties {

    private Map<String, String> mapMsgServices;
    private ReadMsgIface readMsgIface;
    private static final String LANGUAGE_MSG_SERVICES = "language/services/msg_services";
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
        mapMsgServices = readMsgIface.getEtiquetas(LANGUAGE_MSG_SERVICES);
    }

    public Map<String, String> getMapMsgServices() {
        return mapMsgServices;
    }
    
    



    
    
    

}
