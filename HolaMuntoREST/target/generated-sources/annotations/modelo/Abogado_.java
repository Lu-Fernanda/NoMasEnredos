package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Datoscaso;

@Generated(value="EclipseLink-2.5.0.v20130425-rNA", date="2018-05-23T14:33:45")
@StaticMetamodel(Abogado.class)
public class Abogado_ { 

    public static volatile SingularAttribute<Abogado, Integer> cc;
    public static volatile ListAttribute<Abogado, Datoscaso> datoscasoList;
    public static volatile SingularAttribute<Abogado, String> entidad;
    public static volatile SingularAttribute<Abogado, String> nombreEntidad;
    public static volatile SingularAttribute<Abogado, String> correo;
    public static volatile SingularAttribute<Abogado, String> areaEspecializacion;
    public static volatile SingularAttribute<Abogado, String> tarjetaProfesional;
    public static volatile SingularAttribute<Abogado, String> nombre;

}