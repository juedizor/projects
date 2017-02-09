/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.persistence.iface.generics.PersistenciaIfaceDAO;
import co.com.jj.appform.vo.PersonaVO;

/**
 *
 * @author jeio
 */
public interface PersonaIfaceDAO extends PersistenciaIfaceDAO<PersonaVO, PersonaVO>{

    PersonaVO findByTipoDocumentoNumeroDocumento(int tipoDocumento, Long numeroDocumento) throws Exception;
    
    PersonaVO findByEmail(String email) throws Exception;

}
