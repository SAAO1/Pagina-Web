/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasesalaarbol;

/**
 *
 * @author llanchero
 */
public class ClaseSalaArbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //M-E-Z-A-G-P-Q Hacer un arbol binario de busqueda
        //Imprimir y recorrer con recursividad

        Arboles arbolito = new Arboles();
        arbolito.agregar('M');
        arbolito.agregar('E');
        arbolito.agregar('Z');
        arbolito.agregar('A');
        arbolito.agregar('G');
        arbolito.agregar('P');
        arbolito.agregar('Q');

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
        System.out.print("PESO:    ");
        System.out.println(arbolito.peso());
        
        
        
        
        
        
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

    }

}