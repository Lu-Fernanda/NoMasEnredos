package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Abogado;
import modelo.Diligencia;
import modelo.Informe;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.0.v20130425-rNA", date="2018-05-24T18:10:48")
@StaticMetamodel(Datoscaso.class)
public class Datoscaso_ { 

    public static volatile SingularAttribute<Datoscaso, String> archivoAdicional;
    public static volatile SingularAttribute<Datoscaso, Boolean> estado;
    public static volatile SingularAttribute<Datoscaso, Boolean> abogadoAnterior;
    public static volatile ListAttribute<Datoscaso, Diligencia> diligenciaList;
    public static volatile ListAttribute<Datoscaso, Informe> informeList;
    public static volatile SingularAttribute<Datoscaso, Usuario> idUsuario;
    public static volatile SingularAttribute<Datoscaso, Integer> id;
    public static volatile SingularAttribute<Datoscaso, Abogado> idAbogado;
    public static volatile SingularAttribute<Datoscaso, String> informacionCaso;
    public static volatile SingularAttribute<Datoscaso, String> tipoCaso;

}