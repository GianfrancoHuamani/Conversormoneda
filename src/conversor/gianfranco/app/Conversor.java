package adaros.andres.app;

import java.util.HashMap;
import java.util.Map;

public class Conversor {
	
	//variables internas
	private String tipoConversion; 
	private String origen;
	private String destino;
	private double valor;
	private double resultado;
	
	//Valor de conversión de peso chileno a otra moneda
	private double dolar;
	private double pesoChileno;
	private double euros;
	private double librasEsterlinas; /*Revisar como actualizar en tiempo real*/
	private double yenJapones;
	private double wonSulCoreano;
	
	private double kilometrosHora;
	private double millasHora;
	private double pieSegundos;
	
	private double kilogramo;
	private double libra;
	private double onza;
	
	Map<String, Double> diccionarioMonedas = new HashMap<String, Double>(); //Declarando un diccionario
	
	/**
	 * Constructor de clase
	 * @param tipoConversion
	 * @param origen
	 * @param destino
	 * @param valor
	 */
	public Conversor(String tipoConversion, String origen, String destino, double valor) {
		this.tipoConversion = tipoConversion;
		this.origen = origen;
		this.destino = destino;
		this.valor = valor;
	}
	
	/* Valores de conversión de moneda*/
	public double resultadoMoneda() { //calculando el resultado con ayuda de un diccionario
		
		switch (this.origen) { //Si el origen de la moneda coincide con "Peso Chileno" asigne los siguientes valores de conversión equivalentes a 1 peso chileno
			case "Peso Chileno": {
				this.dolar = 0.00120573; // = 1 peso chileno
				this.pesoChileno = 1; // = 1 peso chileno
				this.euros = 0.0010932016; // = 1 peso chileno
				this.librasEsterlinas = 0.00093691759; // = 1 peso chileno
				this.yenJapones = 0.16996787; // = 1 peso chileno
				this.wonSulCoreano = 1.5401445; // = 1 peso chileno
				break;
			}
			case "Dólar": {  //Misma lógica que arriba pero con la moneda de origen Dólar
				this.dolar = 1;
				this.pesoChileno = 829.373;
				this.euros = 0.9060557;
				this.librasEsterlinas = 0.77672368;
				this.yenJapones = 140.83017;
				this.wonSulCoreano = 1276.1516;
				break;
			}
			case "Euro": {
				this.dolar = 1.1034333;
				this.pesoChileno = 914.8325;
				this.euros = 1;
				this.librasEsterlinas = 0.85707404;
				this.yenJapones = 155.35892;
				this.wonSulCoreano = 1408.382;
				break;
			}
			case "Libra Esterlina": {
				this.dolar = 1.2876925;
				this.pesoChileno = 1067.2769;
				this.euros = 1.1669907;
				this.librasEsterlinas = 1;
				this.yenJapones = 181.27583;
				this.wonSulCoreano = 1643.0639;
				break;
			}
			case "Yen Japonés": {
				this.dolar = 0.0071027219;
				this.pesoChileno = 5.8901541;
				this.euros = 0.0064376319;
				this.librasEsterlinas = 0.005515915;
				this.yenJapones = 1;
				this.wonSulCoreano = 9.0610289;
				break;
			}
			case "Won Sul-coreano": {
				this.dolar = 0.00078378069;
				this.pesoChileno = 0.64974907;
				this.euros = 0.00071040897;
				this.librasEsterlinas = 0.00060869689;
				this.yenJapones = 0.11037519;
				this.wonSulCoreano = 1;
				break;
			}
		}
		
		//Definiendo valores para el diccionario según la moneda de origen configurada en la sentencia switch-case
		diccionarioMonedas.put("Dólar", this.dolar);
		diccionarioMonedas.put("Peso Chileno", this.pesoChileno);
		diccionarioMonedas.put("Euro", this.euros);
		diccionarioMonedas.put("Libra Esterlina", this.librasEsterlinas);
		diccionarioMonedas.put("Yen Japonés", this.yenJapones);
		diccionarioMonedas.put("Won Sul-coreano", this.wonSulCoreano);
		
		//Recorriendo el diccionario con ayuda de un for each
		for (Map.Entry<String, Double> valores : diccionarioMonedas.entrySet()) {
			if (valores.getKey() == this.destino) { //Si la clave del diccionario coincide con la moneda de destino;
				this.resultado = this.valor * valores.getValue(); // Multiplica por el valor de esa clave
			}
		}
		return this.resultado;
	}
	
	/* Valores de conversión de velocidad*/
	public double resultadoVelocidad() { 
		
		switch (this.origen) { 
			case "Kilometros/hora": {
				this.millasHora = 0.621371; // =1
				this.pieSegundos = 3.28084; // = 1	
				this.kilometrosHora = 1; // =1
				break;
			}
			case "Millas/hora": {  
				this.kilometrosHora = 1.60934; // =1
				this.pieSegundos = 1.46667;
				this.millasHora = 1;
				break;
			}
			case "Pie/segundo": {
				this.kilometrosHora = 1.09728;
				this.millasHora = 0.681818;
				this.pieSegundos = 1;
				break;
			}
		}
		
		diccionarioMonedas.put("Kilometros/hora", this.kilometrosHora);
		diccionarioMonedas.put("Millas/hora", this.millasHora);
		diccionarioMonedas.put("Pie/segundo", this.pieSegundos);
		
		//Recorriendo el diccionario con ayuda de un for each
		for (Map.Entry<String, Double> valores : diccionarioMonedas.entrySet()) {
			if (valores.getKey() == this.destino) { //Si la clave del diccionario coincide con la moneda de destino;
				this.resultado = this.valor * valores.getValue(); // Multiplica por el valor de esa clave
			}
		}
		return this.resultado;
	}
	
	/* Valores de conversión de velocidad*/
	public double resultadoPeso() { 
		
		switch (this.origen) { 
			case "Kilogramo": {
				this.kilogramo = 1; // =1
				this.libra = 2.20462; // = 1	
				this.onza = 35.274; // =1
				break;
			}
			case "Libra": {  
				this.kilogramo = 0.453592; // =1
				this.libra = 1; // = 1	
				this.onza = 16; // =1
				break;
			}
			case "Onza": {
				this.kilogramo = 0.0283495; // =1
				this.libra = 0.0625; // = 1	
				this.onza = 1; // =1
				break;
			}
		}
		
		diccionarioMonedas.put("Kilogramo", this.kilogramo);
		diccionarioMonedas.put("Libra", this.libra);
		diccionarioMonedas.put("Onza", this.onza);
		
		//Recorriendo el diccionario con ayuda de un for each
		for (Map.Entry<String, Double> valores : diccionarioMonedas.entrySet()) {
			if (valores.getKey() == this.destino) { //Si la clave del diccionario coincide con la moneda de destino;
				this.resultado = this.valor * valores.getValue(); // Multiplica por el valor de esa clave
			}
		}
		return this.resultado;
	}

}
