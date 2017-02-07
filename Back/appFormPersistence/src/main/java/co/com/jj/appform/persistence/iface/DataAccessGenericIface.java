/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * interface para establecer conexión a base de datos
 *
 * @author jeio
 */
public interface DataAccessGenericIface {

    void closeConection() throws Exception;

    void openConection() throws Exception;

    void getConection() throws Exception;
    
    NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() throws Exception;
    
    JdbcTemplate getJdbcTemplate() throws Exception;
    
    
}
