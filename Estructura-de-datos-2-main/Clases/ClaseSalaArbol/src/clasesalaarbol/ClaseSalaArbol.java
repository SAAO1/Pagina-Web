/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasesalaarbol;

/**
 *
 * @author amird
 */
public class ClaseSalaArbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Arbol arbolito = new Arbol();
                arbolito.agregar('M');
         arbolito.agregar('E');
                 arbolito.agregar('Z');
            arbolito.agregar('A');
            arbolito.agregar('G');
        arbolito.agregar('P');
        arbolito.agregar('Q');
        System.out.println("estructura de arbol");
        arbolito.TreePrinter();
        
        System.out.println("vista horizontal ");
        arbolito.imprimir(arbolito.getRaiz(), 0);

        System.out.println("recorrido recursivo ");
            System.out.print("Preorden: ");
                 arbolito.preorden(arbolito.getRaiz());
         System.out.println();

        System.out.print("Inorden: ");
         arbolito.inorden(arbolito.getRaiz());
            System.out.println();

         System.out.print("Posorden: ");
         arbolito.posorden(arbolito.getRaiz());
            System.out.println();

                  System.out.println("recorrido iterativo");
             System.out.print("Preorden IT: ");
          arbolito.preordenIT(arbolito.getRaiz());
            
            System.out.print("Inorden IT: ");
        arbolito.inordenIT(arbolito.getRaiz());
        
         System.out.print("Posorden IT: ");
         arbolito.posordenIT(arbolito.getRaiz());

         System.out.println("datos del arbol");
        System.out.println("Pesar: " + arbolito.pesar(arbolito.getRaiz()));
            System.out.println("Peso: " + arbolito.peso(arbolito.getRaiz()));
            System.out.println("Contar: " + arbolito.contar(arbolito.getRaiz()));
        System.out.println("Altura (static): " + Arbol.alturaArbol(arbolito.getRaiz()));
         System.out.println("Altura: " + arbolito.altura(arbolito.getRaiz()));
        System.out.println("Hojas: " + arbolito.hoja(arbolito.getRaiz()));
         System.out.println("Completo: " + arbolito.completo(arbolito.getRaiz()));
        
            Nodo min = arbolito.minimo(arbolito.getRaiz());
        System.out.println("Minimo: " + (min != null ? min.getDato() : "N/A"));
        
                System.out.println("busqueda y relaciones ");
          System.out.println("Existe 'G': " + arbolito.existe(arbolito.getRaiz(), 'G'));
         System.out.println("Existe 'X': " + arbolito.existe(arbolito.getRaiz(), 'X'));

          Nodo pG = arbolito.padre(arbolito.getRaiz(), 'G');
          System.out.println("Padre de G: " + (pG != null ? pG.getDato() : "null"));

         Nodo tG = arbolito.tio(arbolito.getRaiz(), 'G');
        
         System.out.println("Tio de G: " + (tG != null ? tG.getDato() : "null"));
        
        Nodo tQ = arbolito.tio(arbolito.getRaiz(), 'Q');
       
        System.out.println("Tio de Q: " + (tQ != null ? tQ.getDato() : "null"));

        System.out.println("PRUEBA DE ELIMINACION ");
      
        System.out.println("Eliminando A:");
        arbolito.eliminar('A');
          arbolito.TreePrinter();

        System.out.println("Eliminando M");
       
        arbolito.eliminar('M');
        arbolito.TreePrinter();
    }
    
}
