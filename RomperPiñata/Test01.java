
/**
 *  clase de prueba
 *  se muestra como los niños rompen la piñata de dos maneras primero pasando como llegaron y despues se forman y escogen un papel con un numero
 *  que se sortea quien tenga el numero sera el primero en pasar los demas se forman detras del que salio sorteado. 
 */
public class Test01
{
    public static void main(String args[]){
        System.out.println("-------------------Primera oportunidad -------------------------");
        String [] fila ={"jose","antonio","maury","rosa","joel","carlos","karim"};
        Fiesta f = new Fiesta();
        System.out.println("Los niños formados en la fila son los siguientes:");
        f.filaAux(fila);
        f.formarFila(fila);
        f.primeraOportunidad();
        System.out.println("\n-------------------Segunda vuelta -------------------------");
        
        System.out.println("Los niños se vuelven a formar pero ahora deben de tomar un papel para saber quien va ser el numero sorteado que pasara primero los demas niños se foman atras");
        Fiesta n = new Fiesta();
        System.out.println("\nLos niños que llegaron son los siguientes");
        n.filaAux(fila);
        n.formarFila(fila);
        int numeros[]= n.tombola();
        n.piñataAleatorio(numeros);
    }
}
