package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Datoscaso;

@Generated(value="EclipseLink-2.5.0.v20130425-rNA", date="2018-05-23T14:33:45")
@StaticMetamodel(Informe.class)
public class Informe_ { 

    public static volatile SingularAttribute<Informe, Integer> nHoras;
    public static volatile SingularAttribute<Informe, Date> fecha;
    public static volatile SingularAttribute<Informe, String> factura;
    public static volatile SingularAttribute<Informe, Datoscaso> idProceso1;
    public static volatile SingularAttribute<Informe, Integer> id;
    public static volatile SingularAttribute<Informe, String> comentarioUsuario;
    public static volatile SingularAttribute<Informe, String> archivoAdjunto;
    public static volatile SingularAttribute<Informe, String> informes;

}