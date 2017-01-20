package co.com.jj.appform.entity;

import co.com.jj.appform.entity.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-18T09:27:16")
@StaticMetamodel(TipoDocumento.class)
public class TipoDocumento_ { 

    public static volatile SingularAttribute<TipoDocumento, String> codigo;
    public static volatile ListAttribute<TipoDocumento, Persona> personaList;
    public static volatile SingularAttribute<TipoDocumento, Integer> idTipoDocumento;
    public static volatile SingularAttribute<TipoDocumento, String> nombre;

}