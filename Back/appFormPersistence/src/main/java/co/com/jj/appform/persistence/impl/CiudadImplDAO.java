/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.vo.CiudadVO;
import co.com.jj.appform.persistence.iface.CiudadIfaceDAO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author julio.izquierdo
 */
public class CiudadImplDAO implements CiudadIfaceDAO {

    @Override
    public List<CiudadVO> findByIdDepartamento(int idDepartamento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(CiudadVO object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void merge(CiudadVO object, CiudadVO objectAct) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CiudadVO> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CiudadVO> findByPrimaryKey(CiudadVO object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
