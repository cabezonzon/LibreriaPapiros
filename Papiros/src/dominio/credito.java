/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class credito {
private Integer idCredito;
private Date fechaFin;
private String saldo;
private Integer ci_cliente;
private Integer idVenta;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public Integer getCi_cliente() {
        return ci_cliente;
    }

    public void setCi_cliente(Integer ci_cliente) {
        this.ci_cliente = ci_cliente;
    }

}
