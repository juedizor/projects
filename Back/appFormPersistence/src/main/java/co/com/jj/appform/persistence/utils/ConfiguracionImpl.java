/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.utils;

import java.util.ResourceBundle;

/**
 *
 * @author jeio
 */
public class ConfiguracionImpl implements ConfiguracionIface {

    private String driver;
    private String url;
    private String user;
    private String pass;
    private String bd;
    private String port;
    private String host;
    private static ConfiguracionIface configuracionIface;

    private ConfiguracionImpl() {

    }

    public static ConfiguracionIface getInstance() throws Exception {
        if (configuracionIface == null) {
            configuracionIface = new ConfiguracionImpl();
            try {
                configuracionIface.readParamsConection();
            } catch (Exception e) {
                throw new Exception("Error obteniendo la configuracion inicial " + e.getMessage());
            }
        }

        return configuracionIface;
    }

    @Override
    public void readParamsConection() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE);
        driver = resourceBundle.getString(DRIVER);
        bd = resourceBundle.getString(BD);
        pass = resourceBundle.getString(PASS);
        user = resourceBundle.getString(USER);
        port = resourceBundle.getString(PORT);
        host = resourceBundle.getString(HOST);
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getBd() {
        return bd;
    }

    public String getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
    
    

}
