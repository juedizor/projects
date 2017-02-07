/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.vo.DepartamentoVO;
import java.util.List;

/**
 *
 * @author julio.izquierdo
 */
public interface DepartamentoIfaceDAO extends PersistenciaIfaceDAO<DepartamentoVO>{
    
    public List<DepartamentoVO> findByIdPais(int idPais) throws Exception;
    
}
