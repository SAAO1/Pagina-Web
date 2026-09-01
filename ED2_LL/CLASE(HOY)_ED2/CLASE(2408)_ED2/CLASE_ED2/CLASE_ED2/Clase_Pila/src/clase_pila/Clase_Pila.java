/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase_pila;

import java.util.Stack;

/**
 *
 * @author llanchero
 */
public class Clase_Pila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Stack <Integer> pila = new Stack<>();
        
        int [] Vector = {2,45,54,25,34};
        
        for (int i : Vector){
            pila.push(i);
            System.out.println("Elemento en el"
            + "tope de la pila:"+pila.peek());
        }
        
        while (!pila.isEmpty() ){
            int b = pila.pop();
            System.out.println("El elemento"
                    + " eliminado es: "+b);
            
            if (!pila.isEmpty()){
                System.out.println("El elemento que esta en el tope es:"
                        + "que esta en la cima es:" + pila.peek());
            }
            
        }
    }
    
}
