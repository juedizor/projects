/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.vo.DireccionVO;

/**
 *
 * @author julio.izquierdo
 */
public interface DireccionIfaceDAO extends PersistenciaIfaceDAO<DireccionVO>{

    DireccionVO findByIdPersona(int idPersona) throws Exception;

}
