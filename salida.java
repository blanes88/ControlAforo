package TrabajoServiciosProcesos;
import java.util.Random;

public class salida extends Thread {
    private interiorLocal aforototal;
    private int completo;
    private Random random = new Random();

    public salida(interiorLocal aforototal, int completo) {
        this.aforototal = aforototal;
        this.completo = completo;
    }


    public void run() {
        int tiempoSalida = random.nextInt(5000) + 1000; //Estoy generando un tiempo aleatorio entre 1 y 5 segundos.
        while (true) {
            if (aforototal.get() != 0) {
                int personasASalir = random.nextInt(aforototal.get() + 1); //Genera un numero aleatorio entre 1 y el numero total de personas que hay en el interior del local.

                synchronized (aforototal) {
                    for (int j = 0; j < personasASalir; j++) {
                        aforototal.salir();
                    }
                }
                if( personasASalir != 0){
                    System.out.println("Han salido " + personasASalir + " persona(s).");
                }

            }


            try {
                Thread.sleep(tiempoSalida);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
