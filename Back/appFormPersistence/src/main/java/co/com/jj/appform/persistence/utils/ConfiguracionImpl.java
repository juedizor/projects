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

    private ConfiguracionImpl() throws Exception {
        ReadProperties.getInstance().setMensajes();
    }

    public static ConfiguracionIface getInstance() throws Exception {
        if (configuracionIface == null) {
            configuracionIface = new ConfiguracionImpl();
            try {
                configuracionIface.readParamsConection();
            } catch (Exception e) {
                throw new Exception(ReadProperties.getInstance().getMapMsgException().get("error_configuracion") + e.getMessage());
            }
        }
        return configuracionIface;
    }

    @Override
    public void readParamsConection() throws Exception {
        driver = ReadProperties.getInstance().getMapMsgConfig().get(DRIVER);
        bd = ReadProperties.getInstance().getMapMsgConfig().get(BD);
        pass = ReadProperties.getInstance().getMapMsgConfig().get(PASS);
        user = ReadProperties.getInstance().getMapMsgConfig().get(USER);
        port = ReadProperties.getInstance().getMapMsgConfig().get(PORT);
        host = ReadProperties.getInstance().getMapMsgConfig().get(HOST);
        gestor = ReadProperties.getInstance().getMapMsgConfig().get(GESTOR);
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
