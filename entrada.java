package TrabajoServiciosProcesos;
import java.util.Random;

public class entrada extends Thread {
    private interiorLocal aforototal;
    private int completo;
    private Random random = new Random();

    public entrada(interiorLocal aforototal, int completo) {
        this.aforototal = aforototal;
        this.completo = completo;
    }


    public void run() {
        int tiempoEntrada = random.nextInt(5000) + 1000; //Tiempo de entrada aleatorio entre 1 y 5 segundos.

        while (true) {
            if(aforototal.get() < 10){
                int espacioDisponible = 10 - aforototal.get();
                int personasAEntrar = random.nextInt(espacioDisponible) + 1;
                synchronized (aforototal){
                    aforototal.entrar(personasAEntrar);
                }
                System.out.println("Ha entrado " + personasAEntrar + " persona(s).");
                System.out.println("En el interior del local hay: " + aforototal.get() + " personas.");
            }
            try {
                Thread.sleep(tiempoEntrada);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
