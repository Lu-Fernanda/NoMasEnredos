package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Datoscaso;

@Generated(value="EclipseLink-2.5.0.v20130425-rNA", date="2018-05-23T14:33:45")
@StaticMetamodel(Diligencia.class)
public class Diligencia_ { 

    public static volatile SingularAttribute<Diligencia, String> descripcion;
    public static volatile SingularAttribute<Diligencia, String> diligencias;
    public static volatile SingularAttribute<Diligencia, Date> fechaLimite;
    public static volatile SingularAttribute<Diligencia, Datoscaso> idProceso2;
    public static volatile SingularAttribute<Diligencia, Integer> id;

}