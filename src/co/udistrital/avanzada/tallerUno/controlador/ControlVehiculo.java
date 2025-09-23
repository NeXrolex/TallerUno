/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.controlador;

import co.udistrital.avanzada.tallerUno.modelo.MotoElectrica;
import co.udistrital.avanzada.tallerUno.modelo.Scooter;
import co.udistrital.avanzada.tallerUno.modelo.Vehiculo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author santi
 */
public class ControlVehiculo {

    private static final String SCOOTER = "scooter";
    private static final String MOTOELECTICA = "motoelectrica";

    private ArrayList<Vehiculo> vehiculosRegistrados;

    private ControlVehiculo() {

    }

    // creamos un metodo para crear un vehiculo de tipo scooter
    public void crearVehiculo(String tipo, String id, String potencia, String marca, String numChasis, String referencia) {
        //instanciamos una variable auxiliar para agragar vehiculos
        Vehiculo aux;
        // realizamos una comparacion para diferenciar entre agregar un scooter o moto electrica
        if (SCOOTER.equalsIgnoreCase(tipo)) {
            aux = new Scooter(tipo, id, potencia, marca, numChasis, referencia);
            // agregamosel vehiculo al arraylist al arraylist
            this.vehiculosRegistrados.add(aux);
        } else if (MOTOELECTICA.equalsIgnoreCase(tipo)) {
            aux = new MotoElectrica(tipo, id, potencia, marca, numChasis, referencia);
            // agregamosel vehiculo al arraylist al arraylist
            this.vehiculosRegistrados.add(aux);
        }

    }

    public void editarVehiculo(String id, Scooter scooter) {
        // definimos un contador para establecer la "posicion del objeto a modificar"
        int i = 0;
        //definimos un ciclo 
        for (Vehiculo vehiculosRegistrado : vehiculosRegistrados) {
            // encontramos el objeto y cambiamos los datos
            if (vehiculosRegistrado.getId().equalsIgnoreCase(id)) {
                vehiculosRegistrados.get(i).setMarca(scooter.getMarca());
                vehiculosRegistrados.get(i).setPotencia(scooter.getPotencia());
                vehiculosRegistrados.get(i).setReferencia(scooter.getReferencia());
            }
            //contador para saber la posicion del objeto a cambiar
            i++;
        }

    }

    public void eliminarVehiculo(String id) {
        int i = 0;
        //definimos un ciclo 
        for (Vehiculo vehiculosRegistrado : vehiculosRegistrados) {
            // encontramos el objeto y eliminamos los datos
            if (vehiculosRegistrado.getId().equalsIgnoreCase(id)) {
                vehiculosRegistrados.remove(i);
            }
            //contador para saber la posicion del objeto a eliminar
            i++;
        }
    }

    public Vehiculo buscarScooter(String id) {
        Vehiculo vehiculo = null;
        //definimos un ciclo para encontar el vehiculo a registrar
        for (Vehiculo vehiculosRegistrado : vehiculosRegistrados) {
            // encontramos el objeto 
            if (vehiculosRegistrado.getId().equalsIgnoreCase(id)) {
                vehiculo = vehiculosRegistrado;
            }
        }
        return vehiculo;
    }

}
