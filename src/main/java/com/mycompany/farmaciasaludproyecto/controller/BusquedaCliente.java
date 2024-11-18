package com.mycompany.farmaciasaludproyecto.controller;

/**
 *
 * @author cesar
 */
public class BusquedaCliente {
    
    public static int BusquedaSecuencial(int []arreglo,int dato){
        int posicion = -1;
        for(int i = 0; i < arreglo.length; i++) //recorremos todo el arreglo
        {
            if(arreglo[i] == dato)  //comparamos el elemento en el arreglo con el buscado
            {
                posicion = i;//Si es verdadero guardamos la posicion
                break;//Para el ciclo
            }
        }
        return posicion;
    }



    public static String BusquedaSecuencial2(int []arreglo,int valor){
        String posicion = "";
        for(int i = 0; i < arreglo.length; i++)
        {
            if(arreglo[i] == valor)
            {   if (!posicion.equals(""))
                posicion += ",";
                posicion += i;
            }
        }
        return posicion;
    }



public static int BusquedaBinaria( int [] arreglo, int dato)
    {
        int inicio = 0;
        int fin = arreglo.length - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( arreglo[pos] == dato )
                return pos;
            else if ( arreglo[pos] < dato ) {
                inicio = pos+1;
            } else {
                fin = pos-1;
            }
        }
        return -1;
    }
    
    
}
