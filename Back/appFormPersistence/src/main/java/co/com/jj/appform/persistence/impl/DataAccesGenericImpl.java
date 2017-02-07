/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.persistence.iface.DataAccessGenericIface;
import co.com.jj.appform.persistence.utils.ConfiguracionIface;
import co.com.jj.appform.persistence.utils.ConfiguracionImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author jeio
 */
public class DataAccesGenericImpl implements DataAccessGenericIface {

    
    private BasicDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static ConfiguracionIface CONFIGURACION_IFACE;
    public static String sql;

    public DataAccesGenericImpl() throws Exception {
        CONFIGURACION_IFACE = ConfiguracionImpl.getInstance();
    }


    @Override
    public void closeConection() throws Exception {
        if(dataSource != null){
            dataSource.close();
            dataSource = null;
        }
    }

    @Override
    public void openConection() throws Exception {
        String driver = CONFIGURACION_IFACE.getDriver();
        String bd = CONFIGURACION_IFACE.getBd();
        String host = CONFIGURACION_IFACE.getHost();
        String user = CONFIGURACION_IFACE.getUser();
        String pass = CONFIGURACION_IFACE.getPass();
        String port = CONFIGURACION_IFACE.getPort();
        String gestor = CONFIGURACION_IFACE.getGestor();
        String url = "jdbc:"+gestor+"://" + host + ":" + port + "/" + bd + "";
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(pass);
        }
    }

    @Override
    public void getConection() throws Exception {
        if (dataSource == null) {
            openConection();
        }
    }
    
    private void setJdbcTemplate() throws Exception {
        if(dataSource != null){
            jdbcTemplate = new JdbcTemplate(dataSource);
        }else{
            openConection();
            setJdbcTemplate();
        }
    }

    
    private void setNamedParameterJdbcTemplate() throws Exception {
        if(dataSource != null){
            namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        }else{
            openConection();
            setNamedParameterJdbcTemplate();
        }
    }

    @Override
    public JdbcTemplate getJdbcTemplate() throws Exception {
        setJdbcTemplate();
        return jdbcTemplate;
    }

    @Override
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() throws Exception {
        setNamedParameterJdbcTemplate();
        return namedParameterJdbcTemplate;
    }

}
