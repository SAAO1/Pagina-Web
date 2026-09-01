/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasesalaarbol;

/**
 *
 * @author llanchero
 */
public class Nodo {

    //Atributo
    private char dato;
    private Nodo izquierdo; //N mayuscula porque es el tipo de dato
    private Nodo derecho; //N mayuscula porque es el tipo de dato
    //Metodo

    public Nodo(char dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    //Falta como acceder

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

}
