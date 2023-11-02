
// se crea la clase computadora
public class Computadora implements DispositivoElectronico { // se define que computadora implementa la interfaz 
    //metodos de la clase computadora
    private String marca;
    private boolean encendido;
 // Constructor para crear una instancia de Computadora con una marca dada.
    public Computadora(String marca) {
        this.marca = marca;
        this.encendido = false;// Inicialmente, la computadora está apagada.
    }
 // Método para encender la computadora.
    public void encender() {
        this.encendido = true;
    }
//  // Método para apagar la computadora.
    public void apagar() {
        this.encendido = false;
    }
// Método para validar si la computadora está encendida.
    public boolean validarEncendido() {
        return this.encendido;
    }
    // Método para obtener la marca de la computadora.

    public String getMarca() {
        return this.marca;
    }
}
