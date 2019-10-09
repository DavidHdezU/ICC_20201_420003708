import java.util.Arrays;

/**
 * Clase que ejecuta los problemas de la practica05
 */
public class Control {

    /**
     * Metodo que permite saber si una palabra es palindromo
     * 
     * @param palabra - Palabra que se evaluara si es palindromo
     * @return true si la palabra es un palindromo, false en otro caso
     */
    public static boolean problema1(String palabra) {
        String reversa = ""; // Se declara que una String vacia que servira para la palabra en su reversa
        int longitud = palabra.length(); // longitud de la palabra

        // En el for lo que hace es checar caracter por caracter y luego
        // concatenar la variable reversa con los caracteres al reves
        for (int i = longitud - 1; i >= 0; i--) {
            reversa = reversa + palabra.charAt(i);
        }
        return palabra.equals(reversa);
    }

    /**
     * Metodo que dado un arreglo A y un numero K, determinar si hay 2 numeros en el
     * arreglo que sumen K.
     * 
     * @param arreglo - Es el arreglo en el que evaluaremos si se encuentran los
     *                numeros
     * @param k       - El numero que queremos que los 2 numeros sumados dentro del
     *                arreglo nos de como resultado
     * @return - true en caso de que los numeros esten en el arreglo y nos den K,
     *         false en otro caso
     */
    public static boolean problema2(int[] arreglo, int k) {
        // Se declaran 2 variables que seran los numeros que se encuentran en el arreglo
        int num1;
        int num2;

        // Se declara un for para asignar el primer numero y despues se declara un for
        // dentro del for para asignar el segundo numero
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                num1 = arreglo[i];
                num2 = arreglo[j];

                // En el if preguntamos si la suma de los numeros es igual a K
                if (num1 + num2 == k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo que dado un arreglo A, regresa el mismo arreglo pero ordenado.
     * 
     * @param arreglo - El arreglo en el que se evaluara
     */
    public static void problema3(int[] arreglo) {

        int intercambio; // Creamos la variable intercambio que mas adelante nos servira para cambiar la
                         // posicion
        int longitud = arreglo.length; // Longitud del arreglo

        // Lo que hacemos en los 2 for es asignar 2 numeros y compararlos. Y si uno es
        // mas grande que otro cambian de posicion. Y asi sucesivamente hasta que el
        // arreglo este ordenado
        // A ESTO SE LE CONOCE COMO METODO BURBUJA
        for (int i = 0; i < longitud - 1; i++) {
            for (int j = 0; j < longitud - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    intercambio = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = intercambio;
                }
            }
        }
        return;
    }

    /**
     * Metodo Busqueda binaria, dado un arreglo ordenado A, busca un numero K y
     * regresa true si esta, false en otro caso.
     * 
     * @param arreglo  - El arreglo en el que haremos la busqueda binaria
     * @param buscando - Es el numero que buscaremos
     * @return - true si el numero esta, false en otro caso
     */
    public static boolean problema4(int[] arreglo, int buscando) {

        // Como vamos a realizar busqueda binaria necesitamos asignar la posicion el
        // primer elemento y el ultimi elemento PARA PODER HACER BUSQUEDA BINARIA EL
        // ARREGLO DEBE ESTAR ORDENADO
        int a = 0;
        int b = arreglo.length; // La posicion del ultimo elemento es igual a la longitud del arreglo

        // Realizaremos la busqueda del numero, mientras nuestro elemento minimo sea
        // menor que el maximo Cuando lleguemos a ese caso, significa que ya habremos
        // encontrado el elemento y no se podra segui haciendo la busqueda
        while (a < b) {
            int mitad = (a + b) / 2; // Necesitamos calcular la mitad del arreglo, ya que a partir de ahi
                                     // comenzaremos la busqueda

            if (buscando == arreglo[mitad]) // En caso de que el elemento buscado sea la mitad regresamos true
                return true;

            if (buscando > arreglo[mitad]) { // En caso de que no este en la mitad y el numero buscado sea mayor a la
                                             // mita
                                             // redefinimos a como la mitad + 1, el mas 1 por si la mitad es un numero
                                             // no entero
                a = mitad + 1;
            } else if (buscando < arreglo[mitad]) {// En caso de que no este en la mitad y el numero buscado sea menor a
                                                   // la mitad
                                                   // redefinimos b como la mitad - 1, el menos 1 por si la mitad es un
                                                   // numero no entero
                b = mitad - 1;
            }
        }
        return false;
    }

    /**
     * Metodo que permite saber si un numero N es primo o no
     * 
     * @param n - Es el numero que se evaluara para saber si es primo o no
     * @return - true en caso de ser primo, false en otro caso
     */
    public static boolean problema5(int n) {
        if (n < 2)
            return false; // Si el numero es menor a 2 regresamos falso ya que 2 es el primer numero primo

        // En el for lo que hacemos es evaluar si el numero es divisible entre 2 y si su
        // modulo 2 es 0
        // Si es asi el numero no es primo, en otro caso si es primo
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que regresa todos los numeros primos menores a N en un arreglo
     * 
     * @param n - Es el numero que pondremos como parametro para regresar los numero
     *          primos anteriores a el
     * @return - El arreglo de numeros primos menores a N que hay en el arreglo
     *         original
     */
    public static int[] problema6(int n) {
        int cont = 0; // Declaramos un contador para los numeros primos menores a n

        // En el for lo que hacemos es encotrar todos los numeros primos anteriores a N,
        // usando el metodo del problema5
        // Y el contador aumenta si encuntra un numero primo
        for (int i = 1; i <= n; i++) {
            if (problema5(i)) {
                cont++;
            }
        }
        int[] primos = new int[cont]; // Definimos el arreglo de los numeros primos, teniendi como parametro en
                                      // contador
        int cont2 = 0; // Volvemos a definir otro contador que nos permitira agregar elementos a
                       // nuestro arreglo de primos

        for (int j = 1; j < n; j++) { // En este for lo que se hace agregar los numeros primos menores n al arreglo
            if (problema5(j)) {
                primos[cont2] = j;
                cont2++;
            }
        }
        return primos;
    }

    public static void main(String[] args) {
        /**
         * Metodo main en el que se prueba la funcionalidad de los metodos
         */
        String resultado = "";
        int[] desordenado = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] ordenado = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] primos10 = { 2, 3, 5, 7 };
        if (problema1("oso") == true && problema1("palabra") == false)
            resultado += "P1 bien\n";
        else
            resultado += "P1 mal\n";
        if (problema2(desordenado, 17) == true)
            resultado += "P2 bien\n";
        else
            resultado += "P2 mal\n";
        problema3(desordenado);
        if (Arrays.equals(desordenado, ordenado) == true)
            resultado += "P3 bien\n";
        else
            resultado += "P3 mal\n";
        if (problema4(desordenado, 2) == true && problema4(desordenado, 18) == false)
            resultado += "P4 bien\n";
        else
            resultado += "P4 mal\n";
        if (problema5(7) == true && problema5(6) == false)
            resultado += "P5 bien\n";
        else
            resultado += "P5 mal\n";
        if (Arrays.equals(problema6(10), primos10) == true)
            resultado += "P6 bien\n";
        else
            resultado += "P6 mal\n";
        System.out.println(resultado);
    }

}