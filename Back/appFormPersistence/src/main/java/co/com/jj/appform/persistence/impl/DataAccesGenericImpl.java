/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.persistence.iface.DataAccessGenericIface;
import co.com.jj.appform.persistence.utils.ConfiguracionIface;
import co.com.jj.appform.persistence.utils.ConfiguracionImpl;
import java.sql.Connection;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author jeio
 */
public class DataAccesGenericImpl implements DataAccessGenericIface {

    private static DataAccessGenericIface dataAccessGenericIface;
    private DriverManagerDataSource dataSource;
    private Connection connection;
    private static ConfiguracionIface CONFIGURACION_IFACE;

    private DataAccesGenericImpl() {

    }

    public static DataAccessGenericIface getInstance() throws Exception {
        if (dataAccessGenericIface == null) {
            dataAccessGenericIface = new DataAccesGenericImpl();
            CONFIGURACION_IFACE = ConfiguracionImpl.getInstance();
        }

        return dataAccessGenericIface;
    }

    @Override
    public void closeConection() throws Exception {
    }

    @Override
    public void openConection() throws Exception {
        String driver = CONFIGURACION_IFACE.getDriver();
        String bd = CONFIGURACION_IFACE.getBd();
        String host = CONFIGURACION_IFACE.getHost();
        String user = CONFIGURACION_IFACE.getUser();
        String pass = CONFIGURACION_IFACE.getPass();
        String port = CONFIGURACION_IFACE.getPort();
        String url = "jdbc:mysql://" + host + ":" + port + "/" + bd + "";
        if (dataSource == null) {
            dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(pass);
        }
    }

    @Override
    public void getConection() throws Exception {
        if (connection == null) {
            if (dataSource == null) {
                openConection();
            }
            connection = dataSource.getConnection();
        }
    }

    @Override
    public void initTransaction() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commitTransaction() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rollBackTransaccion() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
