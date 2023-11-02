//Universidad del valle de Guatemala
//Mishell Ciprian 231169
//POO ejercicio 6 


//se importan las librerias
import java.io.*;
import java.util.*;

//se crea la clase Electrotech 
public class Electrotech {
    private ArrayList<DispositivoElectronico> dispositivos;


    // constructor de la clase 
    public Electrotech() {
        this.dispositivos = new ArrayList<DispositivoElectronico>();
    }
//método para agregar un dispositivo 
    public void agregarDispositivo(DispositivoElectronico dispositivo) {
        this.dispositivos.add(dispositivo);
    }
//metodo para desplegar la información de los dispositivos 
    public void desplegarInformacion() {
        for (DispositivoElectronico dispositivo : this.dispositivos) {
            if (dispositivo instanceof Telefono) {
                Telefono telefono = (Telefono) dispositivo;
                System.out.println("Modelo: " + telefono.getModelo());
            } else if (dispositivo instanceof Computadora) {
                Computadora computadora = (Computadora) dispositivo;
                System.out.println("Marca: " + computadora.getMarca());
            }
        }
    }
// // Método para validar cuántos dispositivos están encendidos y apagados
    public void validarEncendidos() {
        int encendidos = 0;
        int apagados = 0;

        for (DispositivoElectronico dispositivo : this.dispositivos) {
            if (dispositivo.validarEncendido()) {
                encendidos++;
            } else {
                apagados++;
            }
        }

        System.out.println("Elementos encendidos: " + encendidos);
        System.out.println("Elementos apagados: " + apagados);
    }
 // Método para guardar información de dispositivos en un archivo CSV
    public void guardarDispositivos(String archivo) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(archivo));

        for (DispositivoElectronico dispositivo : this.dispositivos) {
            if (dispositivo instanceof Telefono) {
                Telefono telefono = (Telefono) dispositivo;
                writer.println("Telefono," + telefono.getModelo() + "," + telefono.validarEncendido());
            } else if (dispositivo instanceof Computadora) {
                Computadora computadora = (Computadora) dispositivo;
                writer.println("Computadora," + computadora.getMarca() + "," + computadora.validarEncendido());
            }
        }

        writer.close();
    }
// Método para cargar información de dispositivos desde un archivo CSV
    public void cargarDispositivos(String archivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;

        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(",");
            String tipo = partes[0];
            String marcaModelo = partes[1];
            boolean encendido = Boolean.parseBoolean(partes[2]);

            if (tipo.equals("Telefono")) {
                Telefono telefono = new Telefono(marcaModelo);
                telefono.encender();
                if (!encendido) {
                    telefono.apagar();
                }
                this.agregarDispositivo(telefono);
            } else if (tipo.equals("Computadora")) {
                Computadora computadora = new Computadora(marcaModelo);
                computadora.encender();
                if (!encendido) {
                    computadora.apagar();
                }
                this.agregarDispositivo(computadora);
            }
        }

        reader.close();
    }
 // Método principal  donde se crea una instancia de Electrotech y se realizan pruebas
    public static void main(String[] args) throws IOException {
        Electrotech tienda = new Electrotech();

        Telefono telefono1 = new Telefono("iPhone");
        telefono1.encender();
        tienda.agregarDispositivo(telefono1);

        Computadora computadora1 = new Computadora("Dell");
        computadora1.encender();
        tienda.agregarDispositivo(computadora1);

        tienda.guardarDispositivos("dispositivos.csv");
        tienda.cargarDispositivos("dispositivos.csv");

        tienda.desplegarInformacion();
        tienda.validarEncendidos();
    }
}