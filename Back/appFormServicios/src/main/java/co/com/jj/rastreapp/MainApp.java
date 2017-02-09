/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp;

import co.com.jj.appform.persistence.daofactory.CreateInstance;
import co.com.jj.appform.persistence.daofactory.createdao.FactoryPersonaDAO;
import co.com.jj.appform.persistence.impl.generics.FactoryDataAccesGenerics;
import co.com.jj.appform.persistence.daofactory.createdao.FactoryTransaction;
import co.com.jj.appform.persistence.daofactory.createdao.FactoryUsuarioDAO;
import co.com.jj.appform.persistence.iface.CiudadIfaceDAO;
import co.com.jj.appform.persistence.iface.ClienteIfaceDAO;
import co.com.jj.appform.persistence.iface.DepartamentoIfaceDAO;
import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
import co.com.jj.appform.persistence.iface.EmpresaIfaceDAO;
import co.com.jj.appform.persistence.iface.PaisIfaceDAO;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.appform.persistence.iface.generics.DataAccessGenericIface;
import co.com.jj.appform.persistence.iface.generics.TransactionIface;
import co.com.jj.appform.persistence.impl.generics.DataAccesGenericImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author jeio
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MainApp extends SpringBootServletInitializer {

    private static UsuarioIfaceDAO usuarioIfaceDAO;
    private static TransactionIface transactionIface;
    private static PersonaIfaceDAO personaIfaceDAO;
    private static TipoDocumentoIfaceDAO tipoDocumentoIfaceDAO;
    private static PerfilIfaceDAO perfilIfaceDAO;
    private static DireccionIfaceDAO direccionIfaceDAO;
    private static EmpresaIfaceDAO empresaIfaceDAO;
    private static ClienteIfaceDAO clienteIfaceDAO;
    private static PaisIfaceDAO paisIfaceDAO;
    private static DepartamentoIfaceDAO departamentoIfaceDAO;
    private static CiudadIfaceDAO ciudadIfaceDAO;
    

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    // generacion de bean 
    @Bean
    public UsuarioIfaceDAO getUsuarioIfaceDAO() throws Exception {
        if (usuarioIfaceDAO == null) {
            CreateInstance<UsuarioIfaceDAO> instace = new CreateInstance<>();
            usuarioIfaceDAO =  instace.newInstance(FactoryUsuarioDAO.getInstance());
        }
        return usuarioIfaceDAO;
    }
    
    @Bean
    public TransactionIface getTransactionIface() throws Exception{
        CreateInstance<DataAccessGenericIface> instace = new CreateInstance<>();
        DataAccessGenericIface dataAccesGenericIface = instace.newInstance(FactoryDataAccesGenerics.getInstance());
        transactionIface = FactoryTransaction.getInstance().newInstance(dataAccesGenericIface.getDataSourceTransactionManager());
        return transactionIface;
    }

    @Bean
    public PersonaIfaceDAO getPersonaIfaceDAO() throws Exception {
        if (personaIfaceDAO == null) {
            CreateInstance<PersonaIfaceDAO> instace = new CreateInstance<>();
            personaIfaceDAO = instace.newInstance(FactoryPersonaDAO.getInstance());
        }
        return personaIfaceDAO;
    }
//
//    @Bean
//    public TipoDocumentoIfaceDAO getTipoDocumentoIfaceDAO() {
//        if (tipoDocumentoIfaceDAO == null) {
//            tipoDocumentoIfaceDAO = new TipoDocumentoImplDAO();
//        }
//        return tipoDocumentoIfaceDAO;
//    }
//
//    @Bean
//    public PerfilIfaceDAO getPerfilIfaceDAO() {
//        if (perfilIfaceDAO == null) {
//            perfilIfaceDAO = new PerfilImplDAO();
//        }
//        return perfilIfaceDAO;
//    }
//
//    @Bean
//    public DireccionIfaceDAO getDireccionIfaceDAO() {
//        if (direccionIfaceDAO == null) {
//            direccionIfaceDAO = new DireccionImplDAO();
//        }
//
//        return direccionIfaceDAO;
//    }
//
//    @Bean
//    public EmpresaIfaceDAO getEmpresaIfaceDAO() {
//        if (empresaIfaceDAO == null) {
//            empresaIfaceDAO = new EmpresaImplDAO();
//        }
//
//        return empresaIfaceDAO;
//    }
//
//    @Bean
//    public ClienteIfaceDAO getClienteIfaceDAO() {
//        if (clienteIfaceDAO == null) {
//            clienteIfaceDAO = new ClienteImplDAO();
//        }
//
//        return clienteIfaceDAO;
//    }
//
//    @Bean
//    public PaisIfaceDAO getPaisIfaceDAO() {
//        if (paisIfaceDAO == null) {
//            paisIfaceDAO = new PaisImplDAO();
//        }
//
//        return paisIfaceDAO;
//    }
//
//    @Bean
//    public DepartamentoIfaceDAO getDepartamentoIfaceDAO() {
//        if (departamentoIfaceDAO == null) {
//            departamentoIfaceDAO = new DepartamentoImplDAO();
//        }
//
//        return departamentoIfaceDAO;
//    }
//
//    @Bean
//    public CiudadIfaceDAO getCiudadIfaceDAO() {
//        if (ciudadIfaceDAO == null) {
//            ciudadIfaceDAO = new CiudadImplDAO();
//        }
//
//        return ciudadIfaceDAO;
//    }

}
