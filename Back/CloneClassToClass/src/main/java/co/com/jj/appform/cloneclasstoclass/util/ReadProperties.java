/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.cloneclasstoclass.util;

import co.com.jj.appform.msginternacionalizacion.ReadMsgIface;
import co.com.jj.appform.msginternacionalizacion.factory.ConcretRead;
import co.com.jj.appform.msginternacionalizacion.factory.Creator;
import java.util.Map;

/**
 *
 * @author julio.izquierdo
 */
public class ReadProperties {

    private Map<String, String> mapMsg;
    private ReadMsgIface readMsgIface;
    private static final String LANGUAGE_CONFIGURACION = "language/msg_error";
    private static ReadProperties readProperties;

    private ReadProperties() {

    }

    public static ReadProperties getInstance() {
        if (readProperties == null) {
            readProperties = new ReadProperties();
        }
        return readProperties;
    }

    public void setMensajes() throws Exception {
        Creator creator = ConcretRead.getInstance();
        readMsgIface = creator.newInstance();
        mapMsg = readMsgIface.getEtiquetas(LANGUAGE_CONFIGURACION);
    }

    public Map<String, String> getMapMsg() {
        return mapMsg;
    }

}
