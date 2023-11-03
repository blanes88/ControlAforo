package TrabajoServiciosProcesos;

public class Main {
    public static void main(String[] args) {
        //Vamos a crear un programa que haga el control de aforo de una discoteca. Este aforo se controla desde una sala de ordenadores. Tenemos además una entrada y una salida.
        //Vamos a utilizar el problema productor-consumidor.

        interiorLocal aforo = new interiorLocal(0);
        entrada entrada = new entrada(aforo, 10);
        salida salida = new salida(aforo, 10);
        entrada.start();
        salida.start();
    }
}
