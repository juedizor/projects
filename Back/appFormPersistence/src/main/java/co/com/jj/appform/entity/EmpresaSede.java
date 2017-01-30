/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.entity;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author jeio
 */
@Entity
@Table(name = "empresa_sede")
@NamedQueries({
    @NamedQuery(name = "EmpresaSede.findAll", query = "SELECT e FROM EmpresaSede e"),
    @NamedQuery(name = "EmpresaSede.findByIdEmpresaSede", query = "SELECT e FROM EmpresaSede e WHERE e.idEmpresaSede = :idEmpresaSede")})
public class EmpresaSede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa_sede")
    private Integer idEmpresaSede;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false, cascade = {CascadeType.ALL})
    private Empresa idEmpresa;
    @JoinColumn(name = "id_empresa_principal", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa idEmpresaPrincipal;

    public EmpresaSede() {
    }

    public EmpresaSede(Integer idEmpresaSede) {
        this.idEmpresaSede = idEmpresaSede;
    }

    public Integer getIdEmpresaSede() {
        return idEmpresaSede;
    }

    public void setIdEmpresaSede(Integer idEmpresaSede) {
        this.idEmpresaSede = idEmpresaSede;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa getIdEmpresaPrincipal() {
        return idEmpresaPrincipal;
    }

    public void setIdEmpresaPrincipal(Empresa idEmpresaPrincipal) {
        this.idEmpresaPrincipal = idEmpresaPrincipal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresaSede != null ? idEmpresaSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaSede)) {
            return false;
        }
        EmpresaSede other = (EmpresaSede) object;
        if ((this.idEmpresaSede == null && other.idEmpresaSede != null) || (this.idEmpresaSede != null && !this.idEmpresaSede.equals(other.idEmpresaSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.jj.appform.entity.EmpresaSede[ idEmpresaSede=" + idEmpresaSede + " ]";
    }
    
}
