/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolavl;

/**
 *
 * @author llanchero
 */
public class ArbolAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Arbol arbolito = new Arbol();
        int []V = {20, 30, 40, 35, 15, 50, 55, 56, 57, 58};
        for (int i:V){
            arbolito.insertar(i);
        }
        arbolito.TreePrinter();

    }
    
}
