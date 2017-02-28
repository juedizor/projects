/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.utils;

/**
 *
 * @author jeio
 */
public interface ConfiguracionIface {

    static final String DRIVER = "driver";
    static final String BD = "bd";
    static final String PASS = "pass";
    static final String USER = "user";
    static final String PORT = "port";
    static final String HOST = "host";
    static final String GESTOR = "gestor";
    static final String RESOURCE = "config/config";
    

    public void readParamsConection() throws Exception;

    public String getDriver();

    public String getUrl();

    public String getUser();

    public String getPass();

    public String getBd();

    public String getPort();

    public String getHost();
    
    public String getGestor();

}
