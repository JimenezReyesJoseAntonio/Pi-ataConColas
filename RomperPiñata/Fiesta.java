//
public class Fiesta
{
    Queue<String> queue = new Queue<String>();
    String [] filaAux;
    int porPiñata = 100;
    /**Este metodo recibe un arreglo de Strings y los guarda en la cola queue que es una variable de clase */
    public void formarFila(String [] fila){
        for(int i = 0; i < fila.length;i++){
            String aux = fila[i];  
            queue.enqueue(aux);

        }
    }

    /**En este metodo los niños pasan a pegarle a la piñata si no le pegan lo suficientemente fuerte se vuelven a formar
    y si un niño la rompe la piñata la fila se rompe, para esto se usa una variable llamda daño que se genera aleatoriamente  entre 
    30 y 68 donde si es menor de 33 la piñata no se rompe y si es mayor de 66 la piñata se rompe */
    public void primeraOportunidad(){
        int daño;
        int numero = 0;
        System.out.println("\nLos niños empiezan a pasar a la piñata\n");
        while(!queue.isEmpty()){

            daño = pegarPiñata();
            if(daño <=33) {
                if(numero >= filaAux.length) numero =0;
                System.out.println("Pasa " + filaAux[numero] + " a pegarle a la piñata");
                System.out.println("!ya le diste uno, ya le diste dos, ya le diste tres y tu tiempo se acabó!!!\n");
                queue.enqueue(queue.dequeue());
                //System.out.println(daño);
                numero++;
            }
            else if(daño == 66) {
                System.out.println(queue.dequeue() + " rompio la piñata" );
                //System.out.println(daño);
                //queue = null;
                /**Como ya se rompio la piñata se desace la fila */
                while(!queue.isEmpty()){
                    queue.dequeue();
                }
            }

        }
    }

    /**Este metodo nos genera un numero de porcentaje de daño para cada niño de la cola*/
    public int pegarPiñata(){
        int porcentaje  = (int)(Math.random()* 68 + 25);
        return porcentaje;
    } 

    /**Con este metodo podemos saber los nombres de los niños en la fila */
    public void filaAux(String fila[]){
        filaAux = fila;
        for(int i = 0; i < fila.length; i++){
            System.out.print(filaAux[i] + ", ");
        }

    }

    /**Segunda vuelta
    En este metodo los niños escogen un numero de la tombola y el que tenga el numero sorteado se queda en su lugar y los demas se pasan atras de el 
    siendo el el primero en pasar a pegarle a la piñata, para romper la piñata es parecido al de la primera ronda*/
    public void piñataAleatorio(int [] tombola){
        String filaNueva[];
        Queue<String> cola = new Queue<String>();
        cola = queue;
        int i = 0;
        int daño;
        int numero = 0;
        int sorteado = (int)(Math.random()*5)+1;
        System.out.println("\nLos niños pasan por un papel\n");
        int numeros[] = tombola;
        for(int j = 0; j< tombola.length; j++){
            System.out.print(tombola[j] + ", " );
        }

        while(!queue.isEmpty()){
            if(i >= tombola.length) i =0;

            if(numeros[i]== sorteado){
                System.out.println("\nEl numero sorteado es: " + sorteado);
                System.out.println("Los niños se forman detras del numero sorteado\n");
                while(!queue.isEmpty()){

                    daño = pegarPiñata();
                    if(daño <=33) {
                        if(numero >= tombola.length) numero =0;
                        System.out.println("Pasa a pegarle a la piñata");
                        System.out.println("!ya le diste uno, ya le diste dos, ya le diste tres y tu tiempo se acabó!!!\n");
                        queue.enqueue(queue.dequeue());
                        //System.out.println(daño);
                        numero++;
                    }
                    else if(daño == 66) {
                        System.out.println(queue.dequeue() + " rompio la piñata" );
                        //System.out.println(daño);
                        //queue = null;
                        /**Como ya se rompio la piñata se desace la fila */
                        while(!queue.isEmpty()){
                            queue.dequeue();
                        }
                    }
                }

            }else{
                queue.enqueue(queue.dequeue());

            }
            i++;
        }

    }

    /** Este metodo nos genera un arreglo con n numeros aleatorios dependiendo de la cantidad de niños en la cola, los numeros van de 1 a n sin que se repitan */
    public int [] tombola(){
        int n = filaAux.length;

        int array[] = new int[n];
        for(int i = 0; i <array.length; i++){
            array[i] = (int)(Math.random()*n)+1;
            for(int j = 0; j < i; j++){
                if(array[i]==array[j]){
                    i--;
                }
            }
        }
        return array;
    }
}
