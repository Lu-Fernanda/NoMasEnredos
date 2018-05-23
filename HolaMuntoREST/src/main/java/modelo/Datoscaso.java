/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author -948
 */
@Entity
@Table(name = "datoscaso")
@XmlRootElement
public class Datoscaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "tipoCaso")
    private String tipoCaso;
    @Column(name = "abogadoAnterior")
    private Boolean abogadoAnterior;
    @Size(max = 30)
    @Column(name = "informacionCaso")
    private String informacionCaso;
    @Size(max = 30)
    @Column(name = "archivoAdicional")
    private String archivoAdicional;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "idUsuario", referencedColumnName = "cc")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "idAbogado", referencedColumnName = "cc")
    @ManyToOne
    private Abogado idAbogado;
    @OneToMany(mappedBy = "idProceso2", cascade = CascadeType.ALL)
    private List<Diligencia> diligenciaList;
    @OneToMany(mappedBy = "idProceso1", cascade = CascadeType.ALL)
    private List<Informe> informeList;

    public Datoscaso() {
    }

    public Datoscaso(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCaso() {
        return tipoCaso;
    }

    public void setTipoCaso(String tipoCaso) {
        this.tipoCaso = tipoCaso;
    }

    public Boolean getAbogadoAnterior() {
        return abogadoAnterior;
    }

    public void setAbogadoAnterior(Boolean abogadoAnterior) {
        this.abogadoAnterior = abogadoAnterior;
    }

    public String getInformacionCaso() {
        return informacionCaso;
    }

    public void setInformacionCaso(String informacionCaso) {
        this.informacionCaso = informacionCaso;
    }

    public String getArchivoAdicional() {
        return archivoAdicional;
    }

    public void setArchivoAdicional(String archivoAdicional) {
        this.archivoAdicional = archivoAdicional;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Abogado getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(Abogado idAbogado) {
        this.idAbogado = idAbogado;
    }

    public List<Diligencia> getDiligenciaList() {
        return diligenciaList;
    }

    public void setDiligenciaList(List<Diligencia> diligenciaList) {
        this.diligenciaList = diligenciaList;
    }
    
      public void addDiligencia(Diligencia diligencia){
        diligencia.setIdProceso2(this);
        this.diligenciaList.add(diligencia);
    }

    public List<Informe> getInformeList() {
        return informeList;
    }

    public void setInformeList(List<Informe> informeList) {
        this.informeList = informeList;
    }

     public void addInforme(Informe inf){
        inf.setIdProceso1(this);
        this.informeList.add(inf);
    }
      
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datoscaso)) {
            return false;
        }
        Datoscaso other = (Datoscaso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Datoscaso{" + "id=" + id + ", tipoCaso=" + tipoCaso + ", abogadoAnterior=" + abogadoAnterior + ", informacionCaso=" + informacionCaso + ", archivoAdicional=" + archivoAdicional + ", estado=" + estado + ", idUsuario=" + idUsuario + ", idAbogado=" + idAbogado + '}';
    }
    

    
}
