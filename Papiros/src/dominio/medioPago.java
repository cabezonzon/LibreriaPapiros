/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Matias
 */
public class medioPago {
private Integer idMedio;
private String nombre;
 @Override
    public String toString() {
        return  nombre.toString();
    }

    public Integer getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(Integer idMedio) {
        this.idMedio = idMedio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
