/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea_arbol_ll;
/**
 *
 * @author llanchero
 */
public class Tarea_Arbol_LL {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arboles arbolito = new Arboles();
        //CREAR EL ARBOL A PARTIR DEL ARREGLO QUE DA EL EJERCICIO
        System.out.println("ARBOL ORIGINAL ABB    ");
        System.out.println("");

        int[] datos = {8, 3, 1, 20, 10, 5, 4};
        arbolito.crear(datos);
        //FORMA SIMPLE DE IMPRIMIR
        //arbolito.imprimir(arbolito.getRaiz(), 0);
        //QUEDA COMO ACOSTADO, EL EJEMPLO ESTA EN LAS DIAPOSITIVAS
        arbolito.TreePrinter();
        System.out.println("");
        System.out.print("PREORDEN:    ");
        arbolito.preorden(arbolito.getRaiz());
        System.out.println("");
        System.out.print("INORDEN:    ");
        arbolito.inorden(arbolito.getRaiz());
        System.out.println("");
        System.out.print("POSTORDEN:    ");
        arbolito.postorden(arbolito.getRaiz());
        System.out.println("");


        
        
        
        
        
        
        
        //IMPRIMIR ITERATIVOS
        
        
        System.out.println("");
        System.out.print("PREORDEN ITERATIVO:    ");
        arbolito.PreordenIterativo(arbolito.getRaiz());
        System.out.println("");
        System.out.print("INORDEN ITERATIVO:    ");
        arbolito.InordenIterativo(arbolito.getRaiz());
        System.out.println("");
        System.out.print("POSTORDEN ITERATIVO:    ");
        arbolito.posordenIterativo(arbolito.getRaiz());


        System.out.println("");
        System.out.println("");
        
        
        System.out.print("PESO:    ");
        System.out.println(arbolito.peso());
        
        
        System.out.print("");
        System.out.print("ALTURA:    ");
        System.out.println(arbolito.altura());
        
        System.out.print("HOJAS:    ");
        System.out.println(arbolito.contarHojas());
        
        
        
        System.out.println("");
        System.out.println("");
        
        
        

        
        
        
        System.out.print("TIO DE 1:    ");
        System.out.println(arbolito.buscarTio(1));
        
        System.out.print("TIO DE 4:    ");
        System.out.println(arbolito.buscarTio(4));


        System.out.print("TIO DE 3:    ");
        System.out.println(arbolito.buscarTio(3));
        
        System.out.println("");
        System.out.println("");
        
        
        
        System.out.print("EXISTE EL 10 EN EL ARBOL?:    ");
        System.out.println(arbolito.existe(10));
        

        
        
        System.out.print("EXISTE EL 15 EN EL ARBOL?:    ");
        System.out.println(arbolito.existe(15));
        
        
        
        System.out.println("");
        System.out.println("");

        Arboles arbolEliminar = new Arboles();
        arbolEliminar.crear(datos);
        System.out.println("");
        System.out.println("ANTES DE ELIMINAR EL 3:");
        arbolEliminar.TreePrinter();
        arbolEliminar.eliminar(3);
        System.out.println("");
        System.out.println("");

        System.out.println("DESPUES DE ELIMINAR EL 3:");
        arbolEliminar.TreePrinter();
    }
}