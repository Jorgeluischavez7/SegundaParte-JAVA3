/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author T-107
 */
@Entity
@Table(name = "tarjeta")
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t")})
public class Tarjeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TARJETA")
    private Integer idTarjeta;
    @Size(max = 120)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DIACORTE")
    private Integer diacorte;
    @OneToMany(mappedBy = "idTarjeta")
    private List<Gastos> gastosList;

    public Tarjeta() {
    }

    public Tarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDiacorte() {
        return diacorte;
    }

    public void setDiacorte(Integer diacorte) {
        this.diacorte = diacorte;
    }

    public List<Gastos> getGastosList() {
        return gastosList;
    }

    public void setGastosList(List<Gastos> gastosList) {
        this.gastosList = gastosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarjeta != null ? idTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.idTarjeta == null && other.idTarjeta != null) || (this.idTarjeta != null && !this.idTarjeta.equals(other.idTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.unitec.maven.Tarjeta[ idTarjeta=" + idTarjeta + " ]";
    }
    
}
