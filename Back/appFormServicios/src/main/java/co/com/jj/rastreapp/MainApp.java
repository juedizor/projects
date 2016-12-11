/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp;

import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.appform.persistence.impl.PerfilImplDAO;
import co.com.jj.appform.persistence.impl.PersonaImplDAO;
import co.com.jj.appform.persistence.impl.TipoDocumentoImplDAO;
import co.com.jj.appform.persistence.impl.UsuarioImplDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author jeio
 */
@SpringBootApplication
public class MainApp  extends SpringBootServletInitializer {

    
    private static UsuarioIfaceDAO usuarioIfaceDAO;
    private static PersonaIfaceDAO personaIfaceDAO;
    private static TipoDocumentoIfaceDAO tipoDocumentoIfaceDAO;
    private static PerfilIfaceDAO perfilIfaceDAO;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
    
    // generacion de bean 
    
    @Bean
    public UsuarioIfaceDAO getUsuarioIfaceDAO(){
        usuarioIfaceDAO = new UsuarioImplDAO();
        return usuarioIfaceDAO;
    }
    
    @Bean
    public PersonaIfaceDAO getPersonaIfaceDAO(){
        personaIfaceDAO = new PersonaImplDAO();
        return personaIfaceDAO;
    }
    
    @Bean
    public TipoDocumentoIfaceDAO getTipoDocumentoIfaceDAO(){
        tipoDocumentoIfaceDAO = new TipoDocumentoImplDAO();
        return tipoDocumentoIfaceDAO;
    }
    
    @Bean
    public PerfilIfaceDAO getPerfilIfaceDAO(){
        perfilIfaceDAO = new PerfilImplDAO();
        return perfilIfaceDAO;
    }
}
