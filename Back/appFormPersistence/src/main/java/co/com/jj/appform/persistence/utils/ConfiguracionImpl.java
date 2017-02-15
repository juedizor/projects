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
    private String gestor;
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
        gestor = resourceBundle.getString(GESTOR);
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public String getBd() {
        return bd;
    }

    @Override
    public String getPort() {
        return port;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public String getGestor() {
        return gestor;
    }


}
