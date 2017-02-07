/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.vo.ClienteVO;
import java.util.List;

/**
 *
 * @author jeio
 */
public interface ClienteIfaceDAO extends PersistenciaIfaceDAO<ClienteVO>{
    
    List<ClienteVO> findByIdEmpresa(int idEmpresa) throws Exception;

}
