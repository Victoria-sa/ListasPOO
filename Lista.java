package com.cursoceat.listas;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

/*Implementamos las listas con tablas de tipo Integr que iremos
 *redimensionando segun vaya haciendo falta. El indice de un elemeto 
 *en la lista coincide con el indice del lugsar que ocupa en la tabla 
 * 
 */
public class Lista {
Integer []tabla;
public Lista  () {
	tabla = new Integer[0];
}
void insertarPrincipio (Integer nuevo) {//constructor que inicializa la tabla en 0
	tabla = Arrays.copyOf(tabla, tabla.length +1);
	System.arraycopy(tabla, 0, tabla, 1, tabla.length-1);
	tabla[0]=nuevo;
}//Insertar
void insertarFinal(Integer nuevo) {
	tabla =Arrays.copyOf(tabla ,tabla.length+ 1);
	tabla[tabla.length-1]= nuevo;
}
void  insertarFinal(Lista otraLista) {
	int tamiIni = tabla.length;//tamaño inicial de la tabla
	tabla = Arrays.copyOf(tabla,tabla.length+otraLista.tabla.length);
	System.arraycopy(otraLista.tabla,0,tabla, tamiIni,otraLista.tabla.length);	
}
//El primer parametro es el indice del lugar que queremos insertar, el valor
//del segundo parametro
void insertar (int posicion, Integer nuevo) {
	tabla =Arrays.copyOf(tabla, tabla.length+1);
	System.arraycopy(tabla, posicion, tabla, posicion+1, tabla.length -posicion-1);
	tabla [posicion]=nuevo;	
}//se elimina el elemento correspondiente al indice y se devuelve
Integer eliminar (int indice) {
Integer eliminado = null;
if(eliminado >= 0 && indice < tabla.length) {
	eliminado = tabla[indice];
	for ( int i= indice+1; i < tabla.length; i++) {
		tabla  [i -1]= tabla[i];
	}
	tabla = Arrays.copyOf(tabla, tabla.length -1);
}
return eliminado;
}
//Al siguiente metodo le pasaremos un indice y nos devolvera el elemto correspondiente
//de la tabla sin modificarla,En el caso de que el indice no sea valido nos devolvera un null
Integer get(int indice) {
	Integer resultado=null;
	if(indice>= 0 && indice < tabla.length) {//indice invalido
		resultado = tabla[indice];
		
	}
	return resultado;

}
int buscar (Integer claveBusqueda) {
	int indice = -1;
	for (int i = 0;i < tabla.length;i++) {
		if (tabla[i].equals(claveBusqueda)) {//
			indice = i;
		}
	}
return indice;
}
//el numero de elementos de la lista es el numero de elementos de la tabla 


public int numeroElementos() {
	return tabla.length;		
			
}
//muestra por consola el contenido de la lista
public void mostrar( ) {
	System.out.print("Lista: "+ Arrays.toString(tabla));
}
}









