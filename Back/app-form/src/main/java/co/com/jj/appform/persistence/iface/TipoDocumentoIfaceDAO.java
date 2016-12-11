/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.TipoDocumento;
import java.util.List;

/**
 *
 * @author jeio
 */
public interface TipoDocumentoIfaceDAO {
    
    public List<TipoDocumento> findAll() throws Exception;
    public TipoDocumento findById(int idTipoDocumento) throws Exception;
    
}
