/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesalaarbol;

import java.util.Stack;

/**
 *
 * @author llanchero
 */
public class Arboles {

    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Arboles() {
        this.raiz = null;
    }

    public void agregar (char valor){
        Nodo nuevonodo = new Nodo(valor);
        if (this.raiz == null){
            this.raiz = nuevonodo;
        }
        else{
            //FUNCION RECURSIVA
            agregar_recursivo(this.raiz, nuevonodo);
        }

    }

    public void agregar_recursivo(Nodo nodo, Nodo nuevonodo){
        if (nuevonodo.getDato() < nodo.getDato()){
            if (nodo.getIzquierdo() == null){
                nodo.setIzquierdo(nuevonodo);
            }
            else{
                agregar_recursivo(nodo.getIzquierdo(), nuevonodo);
            }
        }
        else{
            if (nodo.getDerecho() == null){
                nodo.setDerecho(nuevonodo);
            }
            else{
                agregar_recursivo(nodo.getDerecho(), nuevonodo);
            }
        }
    }

    public void imprimir (Nodo nl, int nivel){
        if ( nl != null ){
            imprimir (nl.getDerecho(), nivel+1);
            for (int i = 0; i < nivel; i++){
                System.out.print("        ");
            }

            System.out.println(nl.getDato());
            imprimir (nl.getIzquierdo(), nivel+1);
        }
    }

    public void preorden (Nodo nodo){
        if (nodo == null){
            return;
        }

        System.out.print(nodo.getDato()+" - ");
        preorden(nodo.getIzquierdo());
        preorden(nodo.getDerecho());

    }

    public void inorden (Nodo nodo){
        if (nodo == null){
            return;
        }

        inorden(nodo.getIzquierdo());
        System.out.print(nodo.getDato()+" - ");
        inorden(nodo.getDerecho());

    }

    public void postorden (Nodo nodo){
        if (nodo == null){
            return;
        }

        postorden(nodo.getIzquierdo());
        postorden(nodo.getDerecho());
        System.out.print(nodo.getDato()+" - ");

    }
    
    
    public void impila(Stack <Nodo> pila, int
            tope, int tamp, Nodo p){
        pila.push(p);
    }
    
    public void campila(Stack <Nodo> pila){
        if(!pila.isEmpty()){
                pila.pop();
            }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static int alturaArbol(Nodo n1) {
        if (n1 == null) {
            return 0;
        }
        return Math.max(alturaArbol(n1.getIzquierdo()), alturaArbol(n1.getDerecho())) + 1;
    }
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
 
    public static void printTree(char[][] M, Nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.getDato();
        printTree(M, root.getIzquierdo(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getDerecho(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }
 
    public void TreePrinter() {
        int h = alturaArbol(this.raiz);
        int col = getcol(h);
        char[][] M = new char[h][col];
        printTree(M, this.raiz, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(M[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
 
    
    
    
    
    
    
    
    //PREORDEN ITERATIVO
    
    
    public void PreordenIterativo(Nodo raiz){
        Stack<Nodo> pila = new Stack<>();
        Nodo actual = raiz;

        while (actual != null || !pila.isEmpty()){
            if (actual != null){
                System.out.print(actual.getDato()+" - ");
                impila(pila, 0, 0, actual);
                actual = actual.getIzquierdo();
            }
            else{
                actual = pila.peek();
                campila(pila);
                actual = actual.getDerecho();
            }
        }
    }
    
    
    
    
    
    //INORDEN ITERATIVO
    
    public void InordenIterativo(Nodo raiz){
        Stack<Nodo> pila = new Stack<>();
        Nodo actual = raiz;

        while (actual != null || !pila.isEmpty()){
            if (actual != null){
                impila(pila, 0, 0, actual);
                actual = actual.getIzquierdo();
            }
            else{
                actual = pila.peek();
                campila(pila);
                System.out.print(actual.getDato()+" - ");
                actual = actual.getDerecho();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //POSORDEN ITERATIVO
    
    
    
    public void posordenIterativo(Nodo raiz){
        Stack<Nodo> pila = new Stack<>();
        Nodo ultimo = null;
        Nodo actual = raiz;

        while (actual != null || !pila.isEmpty()){
            if (actual != null){
                impila(pila, 0, 0, actual);
                actual = actual.getIzquierdo();//voy bajando
            }
            else{
                Nodo tope = pila.peek(); //miro donde estoy

                if (tope.getDerecho() != null && ultimo != tope.getDerecho()){
                    actual = tope.getDerecho();
                } //si el ultimo su derecho es null la condicione es falsa
                else{
                    System.out.print(tope.getDato()+" - "); //se imprime el tope si no tiene hijos
                    ultimo = tope; //tope se vuelve su padre
                    campila(pila);
                }
            }
        }
    }
        


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public int peso(){
        return peso(raiz);
    }

    private int peso (Nodo nodo){
        if (nodo == null){
            return 0;
        }

        return 1 + peso(nodo.getDerecho())+peso(nodo.getIzquierdo());
    }

}