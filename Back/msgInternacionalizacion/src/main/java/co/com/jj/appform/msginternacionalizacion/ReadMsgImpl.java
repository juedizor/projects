/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.msginternacionalizacion;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author julio.izquierdo
 */
public class ReadMsgImpl implements ReadMsgIface {

    private ResourceBundle resourceBundle;
    private Map<String, String> map;

    public ReadMsgImpl() {
    }

    private void setProperties(String pathProperties) throws Exception {
        try {
            resourceBundle = ResourceBundle.getBundle(pathProperties);
        } catch (Exception e) {
            throw e;
        }
    }

    private ResourceBundle getProperites(String pathProperties) throws Exception {
        setProperties(pathProperties);
        return resourceBundle;
    }

    @Override
    public Map<String, String> getEtiquetas(String pathProperties) throws Exception {
        getProperites(pathProperties);
        Enumeration<String> enums = resourceBundle.getKeys();
        String key;
        map = new LinkedHashMap<>();
        while (enums.hasMoreElements()) {
            key = enums.nextElement();
            map.put(key, resourceBundle.getString(key));
        }
        return map;
    }

}
