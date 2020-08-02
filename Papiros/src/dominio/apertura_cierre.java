/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author Matias
 */
public class apertura_cierre {
    private Integer idApertura_cierre_caja;
    private Date fecha;
    private Integer monto_apertura;
    private Integer monto_cierre;
    private String estado;
    private String turno;
    private Integer idUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdApertura_cierre_caja() {
        return idApertura_cierre_caja;
    }

    public void setIdApertura_cierre_caja(Integer idApertura_cierre_caja) {
        this.idApertura_cierre_caja = idApertura_cierre_caja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getMonto_apertura() {
        return monto_apertura;
    }

    public void setMonto_apertura(Integer monto_apertura) {
        this.monto_apertura = monto_apertura;
    }

    public Integer getMonto_cierre() {
        return monto_cierre;
    }

    public void setMonto_cierre(Integer monto_cierre) {
        this.monto_cierre = monto_cierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
           
}
