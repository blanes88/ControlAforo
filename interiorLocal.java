package TrabajoServiciosProcesos;

public class interiorLocal {
        private int aforototal;

        public interiorLocal(int aforoInicial) {

            aforototal = aforoInicial;
        }


        public synchronized int get()
        {
            return aforototal;
        }

        public synchronized void entrar(int personasAEntrar){
            entrada entrada = new entrada(this, personasAEntrar);
            if (aforototal < 10){
                aforototal += personasAEntrar;
            }
        }

        public synchronized void salir(){
            if (aforototal > 0){
                aforototal--;
            }
        }

}
