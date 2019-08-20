public class IntAndString{


    public static int producto(int a, int b){
    
        return a*b;
    }

    public static int division(int a, int b){
        return a/b;
    }

    public static int suma(int a, int b){
        return a+b;
    }

    public static double potencia(double a, double b){
        return Math.pow(a,b);
    }

    public static double raizCuadrada(double a){
        return Math.sqrt(a);
    }

    public static double chicharronera(double a, double b, double c){
	double x = -b;
	double m = 4*a*c;
	double y = Math.sqrt(b*b - m);
	double z = 2*a;
	double d = x + y;
	return d/z;
	
	    
    }

    public static double hipotenusa(double a, double b){
	double x = Math.sqrt(a*a + b*b);
	return x;
	
    }

    public static String concatenacion(String a, String b){
       
        return a + b;
    }

    public static char ultimaLetra(String string){
	int longitud = string.length();
	
        return string.charAt(longitud -1);
    }

    public static int longitud(String string){
	int longitud = string.length();
        return longitud;
    }

    public static String reemplazaLasA(String string,String reemplazo){
	String cadena = string.replaceAll("a", reemplazo);
	
        return cadena;
    }

    public static String[] parte(String string, String separador){
	return string.split(separador);
    }

    public static String quitaEspacios(String string){
        return string.trim();
    }
    public static void main(String[] args) {
        if(producto(5,5)!=25) System.out.println("Error en producto");else System.out.println("Producto bien");
        if(division(25,5)!=5) System.out.println("Error en division");else System.out.println("division bien");
        if(suma(5,6)!=11) System.out.println("Error en suma");else System.out.println("Suma bien");
        if(potencia(2,2)!=4) System.out.println("Error en potencia");else System.out.println("Potencia bien");
        if(raizCuadrada(25)!=5) System.out.println("Error en raiz");else System.out.println("Raiz bien");
        if(chicharronera(1,-8,16)!=4) System.out.println("Error en chicharronera");else System.out.println("chicharronera bien");
        if(hipotenusa(3, 4)!=5) System.out.println("Error en hipotenusa");else System.out.println("Hipotenusa bien");
        if(!concatenacion("Hola ","mundo").equals("Hola mundo")) System.out.println("Error en concatenacion");else System.out.println("concatenacion bien");
        if(ultimaLetra("Hola")!='a') System.out.println("Error en ultima letra");else System.out.println("Ultima letra bien");
        if(longitud("hola")!=4) System.out.println("Error en longiud");else System.out.println("longitud bien");
        if(!reemplazaLasA("Hola munda","o").equals("Holo mundo")) System.out.println("Error en reemplazar");else System.out.println("Reemplazar bien");
        if(parte("palabras,separadas,por,comas",",").length!=4) System.out.println("Error en partir");else System.out.println("Partir bien");
        if(!quitaEspacios("             Hola mundo         ").equals("Hola mundo")) System.out.println("Error en quitar espacios");else System.out.println("Quitar espacios bien");
    }
}
