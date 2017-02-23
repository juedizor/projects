/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.msginternacionalizacion;

import java.util.Map;

/**
 *
 * @author julio.izquierdo
 */
public interface ReadMsgIface {
    
    public Map<String, String> getEtiquetas(String pathProperties) throws Exception;
    
}
