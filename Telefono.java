
//se crea la clse telefono que implementa la interfaz dispositivo electronico
public class Telefono implements DispositivoElectronico {
    //metodos de la clase telefono 
    private String modelo;
    private boolean encendido;
 // Constructor para crear una instancia de Teléfono con un modelo dado.
    public Telefono(String modelo) {
        this.modelo = modelo;
        this.encendido = false; // Inicialmente, el teléfono está apagado.
    
    }
    // Método para encender el teléfono.

    public void encender() {
        this.encendido = true;
    }

    // Método para apagar el teléfono.

    public void apagar() {
        this.encendido = false;
    }
    // Método para validar si el teléfono está encendido.

    public boolean validarEncendido() {
        return this.encendido;
    }
    // Método para obtener el modelo del teléfono.

    public String getModelo() {
        return this.modelo;
    }
}
