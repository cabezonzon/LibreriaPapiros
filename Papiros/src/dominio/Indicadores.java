/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Usuario
 */
public class Indicadores {
private Integer idIdentificador;   
private String nombre;
private Integer valor;

    @Override
    public String toString() {
        return nombre;
    }

    public Integer getIdIdentificador() {
        return idIdentificador;
    }

    public void setIdIdentificador(Integer idIdentificador) {
        this.idIdentificador = idIdentificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

}
