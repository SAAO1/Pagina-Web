/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolavl;

/**
 *
 * @author llanc
 */
public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public int altura_nodo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getHeight();
    }

    public int factor_equilibrio(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura_nodo(nodo.getIzquierdo()) - altura_nodo(nodo.getDerecho());
    }

    public Nodo rotacion_derecha(Nodo Y) {
        Nodo X = Y.getIzquierdo();
        Nodo temp = X.getDerecho();

        X.setDerecho(Y);
        Y.setIzquierdo(temp);

        Y.setHeight(Math.max(altura_nodo(Y.getIzquierdo()), altura_nodo(Y.getDerecho())) + 1);
        X.setHeight(Math.max(altura_nodo(X.getIzquierdo()), altura_nodo(X.getDerecho())) + 1);

        return X;
    }

    public Nodo rotacion_izquierda(Nodo X) {
        Nodo Y = X.getDerecho();
        Nodo temp = Y.getIzquierdo();

        Y.setIzquierdo(X);
        X.setDerecho(temp);

        X.setHeight(Math.max(altura_nodo(X.getIzquierdo()), altura_nodo(X.getDerecho())) + 1);
        Y.setHeight(Math.max(altura_nodo(Y.getIzquierdo()), altura_nodo(Y.getDerecho())) + 1);

        return Y;
    }

    public void insertar(int valor) {
        this.raiz = insertar(this.raiz, valor);
    }

    public Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(insertar(nodo.getDerecho(), valor));
        } else {
            return nodo;
        }

        nodo.setHeight(1 + Math.max(altura_nodo(nodo.getIzquierdo()), altura_nodo(nodo.getDerecho())));
        int fe = factor_equilibrio(nodo);

        if (fe > 1 && factor_equilibrio(nodo.getIzquierdo()) >= 0) {
            System.out.println("ROTACION DERECHA");
            return rotacion_derecha(nodo);
        }
        if (fe < -1 && factor_equilibrio(nodo.getDerecho()) <= 0) {
            System.out.println("ROTACION IZQUIERDA");
            return rotacion_izquierda(nodo);
        }
        if (fe > 1 && factor_equilibrio(nodo.getIzquierdo()) < 0) {
            System.out.println("ROTACION IZQUIERDA-DERECHA");
            nodo.setIzquierdo(rotacion_izquierda(nodo.getIzquierdo()));
            return rotacion_derecha(nodo);
        }
        if (fe < -1 && factor_equilibrio(nodo.getDerecho()) > 0) {
            System.out.println("ROTACION DERECHA-IZQUIERDA");
            nodo.setDerecho(rotacion_derecha(nodo.getDerecho()));
            return rotacion_izquierda(nodo);
        }

        return nodo;
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

    public static void printTree(int[][] M, Nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.getValor();
        printTree(M, root.getIzquierdo(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getDerecho(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }

    public void TreePrinter() {
        int h = alturaArbol(this.raiz);
        if (h == 0) {
            System.out.println("(árbol vacío)");
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


    //ELIMINAR  mismas rotaciones simples y dobles

    public void eliminar(int valor) {
        this.raiz = delete(this.raiz, valor);
    }

    public Nodo delete(Nodo root, int valor) {
        if (root == null) {
            return root;
        }

        if (valor < root.getValor()) {
            root.setIzquierdo(delete(root.getIzquierdo(), valor));
        } else if (valor > root.getValor()) {
            root.setDerecho(delete(root.getDerecho(), valor));
        } else {
            if (root.getIzquierdo() == null) {
                return root.getDerecho();
            } else if (root.getDerecho() == null) {
                return root.getIzquierdo();
            }

            root.setValor(minValue(root.getDerecho()));
            root.setDerecho(delete(root.getDerecho(), root.getValor()));
        }

        root.setHeight(Math.max(altura_nodo(root.getIzquierdo()), altura_nodo(root.getDerecho())) + 1);
        int balance = factor_equilibrio(root);

        if (balance > 1 && factor_equilibrio(root.getIzquierdo()) >= 0) {
            System.out.println("ROTACION DERECHA");
            return rotacion_derecha(root);
        }
        if (balance > 1 && factor_equilibrio(root.getIzquierdo()) < 0) {
            System.out.println("ROTACION IZQUIERDA-DERECHA");
            root.setIzquierdo(rotacion_izquierda(root.getIzquierdo()));
            return rotacion_derecha(root);
        }
        if (balance < -1 && factor_equilibrio(root.getDerecho()) <= 0) {
            System.out.println("ROTACION IZQUIERDA");
            return rotacion_izquierda(root);
        }
        if (balance < -1 && factor_equilibrio(root.getDerecho()) > 0) {
            System.out.println("ROTACION DERECHA-IZQUIERDA");
            root.setDerecho(rotacion_derecha(root.getDerecho()));
            return rotacion_izquierda(root);
        }

        return root;
    }

    public int minValue(Nodo node) {
        int minValue = node.getValor();
        while (node.getIzquierdo() != null) {
            minValue = node.getIzquierdo().getValor();
            node = node.getIzquierdo();
        }
        return minValue;
    }
}