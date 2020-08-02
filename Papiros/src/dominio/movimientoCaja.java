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
public class movimientoCaja {
   private Integer idMovimiento;
   private String descripcion;
   private String entrada_salida;
   private Date fecha;
   private Integer monto;
   private Integer idapertura_cierre_caja;
   private Integer idUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdapertura_cierre_caja() {
        return idapertura_cierre_caja;
    }

    public void setIdapertura_cierre_caja(Integer idapertura_cierre_caja) {
        this.idapertura_cierre_caja = idapertura_cierre_caja;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEntrada_salida() {
        return entrada_salida;
    }

    public void setEntrada_salida(String entrada_salida) {
        this.entrada_salida = entrada_salida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }
   
}
