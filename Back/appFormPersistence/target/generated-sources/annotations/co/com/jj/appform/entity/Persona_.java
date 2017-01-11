package co.com.jj.appform.entity;

import co.com.jj.appform.entity.TipoDocumento;
import co.com.jj.appform.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-10T19:28:12")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apellido2;
    public static volatile SingularAttribute<Persona, Date> fechaModificacion;
    public static volatile ListAttribute<Persona, Usuario> usuarioList;
    public static volatile SingularAttribute<Persona, String> apellido1;
    public static volatile SingularAttribute<Persona, Date> fechaRegistro;
    public static volatile SingularAttribute<Persona, TipoDocumento> idTipoDocumento;
    public static volatile SingularAttribute<Persona, Long> numeroDocumento;
    public static volatile SingularAttribute<Persona, String> nombre2;
    public static volatile SingularAttribute<Persona, String> nombre1;
    public static volatile SingularAttribute<Persona, Integer> idPersona;
    public static volatile SingularAttribute<Persona, String> email;

}