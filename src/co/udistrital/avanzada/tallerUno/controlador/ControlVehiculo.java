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
 * Clase encargada gestionar los vehiculos
 *
 * @author Alex, Jeison
 * @version 1.0
 */
public class ControlVehiculo {

    private static final String SCOOTER = "scooter";
    private static final String MOTOELECTICA = "motoelectrica";
    private ControlGeneral controlGeneral;
    private ArrayList<Vehiculo> vehiculosRegistrados;

    ControlVehiculo(ControlGeneral controlGeneral) {
        this.vehiculosRegistrados= new ArrayList<>();
        this.controlGeneral = controlGeneral;
    }

    // creamos un metodo para crear un vehiculo de tipo scooter
    /**
     * @param tipo espesifica el tipo entre scooter y moto electrica
     * @param id identificador de vehiculo
     * @param potencia potencia nominal del motor
     * @param marca marca del vehiculo
     * @param numChasis identificcador del chasis
     * @param referencia tipo segun la marca
     */
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

    /**
     *
     * @param id
     * @param scooter
     */
    public void editarVehiculo(Vehiculo vehiculo) {
        // definimos un contador para establecer la "posicion del objeto a modificar"
        int i = 0;
        //definimos un ciclo 
        for (Vehiculo vehiculosRegistrado : vehiculosRegistrados) {
            // encontramos el objeto y cambiamos los datos
            if (vehiculosRegistrado.getId().equalsIgnoreCase(vehiculo.getId())) {
                vehiculosRegistrados.get(i).setMarca(vehiculo.getMarca());
                vehiculosRegistrados.get(i).setPotencia(vehiculo.getPotencia());
                vehiculosRegistrados.get(i).setReferencia(vehiculo.getReferencia());
            }
            //contador para saber la posicion del objeto a cambiar
            i++;
        }

    }

    /**
     *
     * @param id
     */
    public void eliminarVehiculo(String id) {
        int i = 0;
        boolean bandera = false;
        //definimos un ciclo  
        for (Vehiculo vehiculosRegistrado : vehiculosRegistrados) {
            // encontramos el objeto y eliminamos los datos
            if (vehiculosRegistrado.getId().equalsIgnoreCase(id)) {
                bandera = true;
                break;
            }
            //contador para saber la posicion del objeto a eliminar
            i++;
        }
        if(bandera){
            vehiculosRegistrados.remove(i);
        }
    }

    /**
     *
     * @param id
     * @return vehiculo
     */
    public Vehiculo buscarVehiculo(String id) {
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
