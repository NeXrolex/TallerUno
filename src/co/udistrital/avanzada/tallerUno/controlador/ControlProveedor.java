package co.udistrital.avanzada.tallerUno.controlador;



import co.udistrital.avanzada.tallerUno.modelo.ProvedorInsumo;
import co.udistrital.avanzada.tallerUno.modelo.ProvedorServicio;
import co.udistrital.avanzada.tallerUno.modelo.Provedor;
import java.util.ArrayList;
import java.util.List;

///**
// *
// * @author santi
// */

public class ControlProveedor {
    private List<Provedor> proveedores;
    public ControlProveedor(){
        this.proveedores = new ArrayList<>();
    
    }
    public void agregarProveedor(Provedor proveedor) {
        proveedores.add(proveedor);
    }

    public List<Provedor> getProveedores() {
        return proveedores;
    }
    /**
     * Crea un provedor
     *
     * @param tipo provedor de insumos o servicios
     * @param nombre nombre del provedor
     * @param apellido apellido del provedor
     * @param cedula documento del provedor
     * @param numero numero de contacto
     * @param correo correo de contacto
     * @param password contrasena del provedor
     * @return 
     */
    public Provedor crearProveedor(String tipo, String nombre, String apellido, 
                                    String cedula, String numero, String correo, String password) {
        Provedor nuevo = null;

        if (tipo.equalsIgnoreCase("insumos")) {
            nuevo = new ProvedorInsumo(nombre, apellido, cedula, numero, correo, password);
        } else if (tipo.equalsIgnoreCase("servicios")) {
            nuevo = new ProvedorServicio(nombre, apellido, cedula, numero, correo, password);
        }

        if (nuevo != null) {
            proveedores.add(nuevo);
        }
        return nuevo;
    }

    public List<Provedor> getProvedor() {
        return proveedores;
    }
}    


