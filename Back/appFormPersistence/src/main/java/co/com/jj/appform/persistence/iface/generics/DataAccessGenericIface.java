/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface.generics;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * interface para establecer conexión a base de datos
 *
 * @author jeio
 */
public interface DataAccessGenericIface {

    void closeConection() throws Exception;

    void setDataSource() throws Exception;

    BasicDataSource getDataSource() throws Exception;
    
    NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() throws Exception;
    
    JdbcTemplate getJdbcTemplate() throws Exception;
    
    PlatformTransactionManager getDataSourceTransactionManager() throws Exception;
    
    
}
