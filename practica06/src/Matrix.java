package src;

/**
 * Clase que modela una matriz a partir de un arreglo bidemensional y permite
 * realizar operaciones
 * 
 * @author David Hernández Uriostegui
 */
public class Matrix {
    private double[][] matriz;

    // Construye una matriz vacia de n por m
    /**
     * Constructor que produce una matriz de nxm vacia
     * 
     * @param n - Renglones
     * @param m - Columnas
     */
    public Matrix(int n, int m) {
        if (n > 0 && m > 0) {
            matriz = new double[n][];
            for (int i = 0; i < n; i++) {
                matriz[i] = new double[m];
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = 0;
                }
            }
        } else
            new Error("Valores incorrectos");
    }

    // Construye una matriz dado un arreglo
    /**
     * Constructor que produce a partir de un arreglo bidemensional declarado
     * 
     * @param array - Arreglo bidemensional
     */
    public Matrix(double[][] array) {
        matriz = new double[array.length][];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new double[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                matriz[i][j] = array[i][j];
            }
        }
    }

    // Funcion que calcula producto escalar
    /**
     * Metodo que calcula el metodo escalar de una matriz
     * 
     * @param scalar - El escalar que se usara para llevar a cabo metodo
     */
    public void scalarProduct(double scalar) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = scalar * matriz[i][j];

            }
        }
    }

    // Funcion que calcula suma de matrices
    /**
     * Metodo que suma 2 matrices del mismo tamaño
     * 
     * @param m - La matriz con la cual se realizara la suma
     */
    public void add(Matrix m) {
        // Las matrices tiene que ser simetricas
        if ((m.matriz.length != matriz.length) || (m.matriz[0].length != matriz[0].length)) {
            new Error("NO SON SIMETRICAS, NO TIENEN LAS MISMAS DIMENSIONES");
        } else {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = matriz[i][j] + m.matriz[i][j];
                }
            }
        }
    }

    // Funcion que calcula producto de matrices
    /**
     * Metodo que multiplica 2 matrices
     * 
     * @param m - Matriz con la cual se realizara el producto
     */
    public double[][] matrixProduct(Matrix m) {
        // Las matrices tiene que ser simetricas
        if (matriz[0].length != m.matriz.length) {
            new Error("NO SON SIMETRICAS, NO TIENEN LAS MISMAS DIMENSIONES");
        }
        double[][] result = new double[matriz.length][m.matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < m.matriz[0].length; j++) {
                for (int k = 0; k < matriz[0].length; k++) {
                    result[i][j] += (matriz[i][k] * m.matriz[k][j]);
                }
            }
        }
        return (result);
    }

    // Funcion que obtiene el elemento i j
    /**
     * Metodo que obtiene el elemento que se encuentra en la posicion que ingresemos
     * 
     * @param i - Renglon
     * @param j - Columna
     * @return - El elemento
     */
    public double getElement(int i, int j) {
        while (i < matriz.length && j < matriz[0].length) {
            return matriz[i][j];
        }
        return 0;
    }

    // function set element
    /**
     * Metodo que permite ingresar y remplazar un elemento en la posicion que
     * ingresemos
     * 
     * @param i - Renglon
     * @param j - Columna
     * @param e - Elemento que se quiere ingresar
     */
    public void setElement(int i, int j, double e) {
        matriz[i][j] = e;

    }

    // Funcion que calcula el determinante si es nxn
    /**
     * Metodo que calcula el determinante de una matriz nxn
     */
    public double determinant() {
        if (matriz.length != matriz[0].length) {
            return 0;
        }
        double resultado = 0;

        if (matriz.length == 1) {
            resultado = matriz[0][0];
            return resultado;
        }

        if (matriz.length == 2) {
            resultado = ((matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]));
            return resultado;
        }
        return resultado;
        /**
         * Aqui ya no supe como implementar un algoritmo el cual me permitiera calcular
         * para una matriz mayor o igual de 3x3 ):
         */
    }

    // Funcion que te dice si 2 matrices son iguales
    /**
     * Metodo que nos dice si 2 matrices son iguales con respecto a su tamaño y a
     * sus elementos
     * 
     * @param o - Matriz a comparar
     * @return - true si son iguales, false en otro caso
     */
    @Override
    public boolean equals(Object o) {
        Matrix z = (Matrix) o;
        if (z.matriz.length != matriz.length || z.matriz[0].length != matriz[0].length)
            return false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != z.getElement(i, j))
                    return false;
            }
        }
        return true;
    }

}