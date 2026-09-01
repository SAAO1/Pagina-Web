package tarea_arbol_ll;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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

    public void agregar (int valor){
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //ALTURA DE MI ARBOL 
    
    public static int alturaArbol(Nodo n1) {
        if (n1 == null) {
            return 0;
        }
        return Math.max(alturaArbol(n1.getIzquierdo()), alturaArbol(n1.getDerecho())) + 1;
    }
     
    
    
    
    public int altura(){
        return altura(raiz);
    }

    private int altura (Nodo nodo){
        if (nodo == null){
            return 0;
        }
        
        int izq = altura(nodo.getIzquierdo());
        int der = altura(nodo.getDerecho());
        if (izq>der){
            return 1 + izq;
        }
        else{
            return 1 + der;
        }

    }
    
    
    
    
    
    
    
    
    
    //PRINT DE PROFE
    
    
    
    
    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
 
    public static void printTree(int[][] M, Nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.getDato();
        printTree(M, root.getIzquierdo(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getDerecho(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }
 
    public void TreePrinter() {
        int h = alturaArbol(this.raiz);
        if (h == 0){
            System.out.println("(arbol vacio)");
            return;
        }
        int col = getcol(h);
        int[][] M = new int[h][col];
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
        


    
    
    

    
    
    
    
    
    
    
    //PESO (NUM DE NODOS)
    
    

    public int peso(){
        return peso(raiz);
    }

    private int peso (Nodo nodo){
        if (nodo == null){
            return 0;
        }

        return 1 + peso(nodo.getDerecho())+peso(nodo.getIzquierdo());
    }











    
    
    
    
    
    
    
    
    
    

    
    

    //ELIMINAR UN NODO DEL ARBOL

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getDato()) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), valor));
        } else {
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            Nodo temp = encontrarMinimo(nodo.getDerecho());
            nodo.setDato(temp.getDato());
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), temp.getDato()));
        }

        return nodo;
    }

    
    
    
    public void crear (int[] datos){
        for (int i = 0; i <datos.length; i++){
            agregar (datos[i]);
        }
    }
    
    
    
    
    
    
        //SABER SI EL ARBOL ES COMPLETO


    public boolean esCompleto(){
        int totalNodos = peso();
        int h = altura();
        int maximoPosible = (int) Math.pow(2, h) - 1;
        return totalNodos == maximoPosible;
    }

    
    
        //HOJAS

    public int contarHojas(){
        return contarHojas(raiz);
    }

    private int contarHojas (Nodo nodo){
        if (nodo == null){
            return 0;
        }
        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null){
            return 1;
        }
        return contarHojas(nodo.getDerecho()) + contarHojas(nodo.getIzquierdo());
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        //TIO



    public Integer buscarTio(int valor){
        Nodo padre = buscarPadre(raiz, valor);
        if (padre == null){
            return null;
        }

        Nodo abuelo = buscarPadre(raiz, padre.getDato());
        if (abuelo == null){
            return null;
        }

        if (abuelo.getIzquierdo() == padre){
            if (abuelo.getDerecho() == null){
                return null;
            }
            return abuelo.getDerecho().getDato();
        }
        else{
            if (abuelo.getIzquierdo() == null){
                return null;
            }
            return abuelo.getIzquierdo().getDato();
        }
    }

    private Nodo buscarPadre(Nodo nodo, int valor){
        if (nodo == null){
            return null;
        }

        if ((nodo.getIzquierdo() != null && nodo.getIzquierdo().getDato() == valor) ||
            (nodo.getDerecho() != null && nodo.getDerecho().getDato() == valor)){
            return nodo;
        }

        if (valor < nodo.getDato()){
            return buscarPadre(nodo.getIzquierdo(), valor);
        }
        return buscarPadre(nodo.getDerecho(), valor);
    }




    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //DADO UN ELEMENTO, DECIR SI SE ENCUENTRA O NO EN EL ABB

    public boolean existe(int valor){
        return existe(this.raiz, valor);
    }

    private boolean existe(Nodo nodo, int valor){
        if (nodo == null){
            return false;
        }
        if (valor == nodo.getDato()){
            return true;
        }
        if (valor < nodo.getDato()){
            return existe(nodo.getIzquierdo(), valor);
        }
        else{
            return existe(nodo.getDerecho(), valor);
        }
    }

}