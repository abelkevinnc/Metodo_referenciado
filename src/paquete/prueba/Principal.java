package paquete.prueba;

import java.util.function.Consumer;

public class Principal {
	public static void main(String[] args) {
		Consumer<String> consumidor = (x) -> System.out.println(x); // se limita a pasar por argumento solo de tipo
																	// String
		// La clase generica consumer recibe un parametro y no retorna nada (void)
		// functional interface: unico metodo abstracto es accept
		consumidor.accept("hola");
		
		procesar((x) -> System.out.println("imprimiendo un String: " + x), "cadena");
		procesar((x) -> System.out.println("imprimiendo un entero: " + x), 17);
		
		procesar(Principal::imprimir,"ya no es con expresion lambda");
		procesar(Principal::imprimirDouble,17.0);
		
		Impresora i= new Impresora();
		procesar(i::imprimir,"Imprimiendo desde un metodo de otra clase");

	}

	public static <T> void procesar(Consumer<T> expresion, T mensaje) { // permite pasar por argumento cualquier tipo de
																		// objeto
		expresion.accept(mensaje);
	}

	public static void imprimir(String mensaje) {
		System.out.println("---------");
		System.out.println(mensaje);
		System.out.println("---------");
	}
	
	public static void imprimirDouble(Double decimal) {
		System.out.println("este es un decimal: "+ decimal);
	}
	
	

}
