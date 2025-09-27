/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 *
 * @author jeiso
 */
public class Evento {
    private String numeroEvento;
    private String tipoEvento;
    private String descripcionEvento;
    private String fecha;

    public Evento(String tipoEvento, String descripcionEvento,String fecha,
            String numeroEvento) {
        this.numeroEvento=numeroEvento;
        this.tipoEvento = tipoEvento;
        this.descripcionEvento = descripcionEvento;
        this.fecha = fecha;
    }

    public String getNumeroEvento() {
        return numeroEvento;
    }

    public void setNumeroEvento(String numeroEvento) {
        this.numeroEvento = numeroEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
