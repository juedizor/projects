/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.iface;

import co.com.jj.rastreapp.dto.PersonaDTO;

/**
 *
 * @author jeio
 */
public interface GestionPersonalIface {

    PersonaDTO getPersona(int tipoDoc, long numeroDoc) throws Exception;

    PersonaDTO getPersona(String email) throws Exception;

    int registrarPersona(PersonaDTO personaDTO) throws Exception;

}
