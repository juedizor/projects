/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl.generics;

import co.com.jj.appform.persistence.iface.generics.DataAccessGenericIface;
import co.com.jj.appform.persistence.utils.ConfiguracionIface;
import co.com.jj.appform.persistence.utils.ConfiguracionImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author jeio
 */
public class DataAccesGenericImpl implements DataAccessGenericIface {

    private DataSourceTransactionManager txManager;
    private BasicDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static ConfiguracionIface CONFIGURACION_IFACE;

    protected DataAccesGenericImpl() throws Exception {
        CONFIGURACION_IFACE = ConfiguracionImpl.getInstance();
    }

    @Override
    public void closeConection() throws Exception {
        if (dataSource != null) {
            dataSource.close();
            dataSource = null;
            txManager = null;
        }
    }

    @Override
    public void setDataSource() throws Exception {
        if (dataSource == null) {
            String driver = CONFIGURACION_IFACE.getDriver();
            String bd = CONFIGURACION_IFACE.getBd();
            String host = CONFIGURACION_IFACE.getHost();
            String user = CONFIGURACION_IFACE.getUser();
            String pass = CONFIGURACION_IFACE.getPass();
            String port = CONFIGURACION_IFACE.getPort();
            String gestor = CONFIGURACION_IFACE.getGestor();
            String url = "jdbc:" + gestor + "://" + host + ":" + port + "/" + bd + "";
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(pass);
            txManager = new DataSourceTransactionManager(dataSource);
        }
    }

    @Override
    public BasicDataSource getDataSource() throws Exception {
        if (dataSource == null) {
            setDataSource();
        }

        return dataSource;
    }

    private void setJdbcTemplate() throws Exception {
        if (dataSource != null) {
            if (jdbcTemplate == null) {
                jdbcTemplate = new JdbcTemplate(txManager.getDataSource());
            }
        } else {
            setDataSource();
            setJdbcTemplate();
        }
    }

    private void setNamedParameterJdbcTemplate() throws Exception {
        if (dataSource != null) {
            namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(txManager.getDataSource());
        } else {
            setDataSource();
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

    @Override
    public PlatformTransactionManager getDataSourceTransactionManager() throws Exception {
        setDataSource();
        return txManager;
    }

}
