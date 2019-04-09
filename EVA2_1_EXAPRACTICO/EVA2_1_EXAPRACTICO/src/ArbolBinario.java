
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Littl
 */
public class ArbolBinario {

    private Nodo root;

    public ArbolBinario() {
        root = null;
    }

    public void addNodo(Nodo nNuevo) {
        if (root == null) { //Árbol vacío
            root = nNuevo;
        } else { //Proceso recursivo
            Nodo n = buscar(nNuevo.getValor());
            if (n != null) {
                System.out.println("El valor ya existe en el árbol");
                return;
            }
            addRecursivo(root, nNuevo);
        }
    }

    //Nodo actual, valor a insertar
    private void addRecursivo(Nodo nActual, Nodo nNuevo) {
        //Izquierda
        if (nNuevo.getValor().compareTo(nActual.getValor()) < 1) {
            if (nActual.getIzq() != null) {
                addRecursivo(nActual.getIzq(), nNuevo);
            } else {
                nActual.setIzq(nNuevo);
                nNuevo.setPadre(nActual);
            }
        } else {
            if (nNuevo.getValor().compareTo(nActual.getValor()) >= 0) {
                //Posición ocupada, seguimos avanzando
                if (nActual.getDer() != null) {
                    addRecursivo(nActual.getDer(), nNuevo);
                } else {
                    nActual.setDer(nNuevo);
                    nNuevo.setPadre(nActual);
                }
            } else { //IGUAL --> MENSAJE AL USUARIO
                //LANZAR UNA EXCEPCIÒN
            }
        }
    }

    public void eliminar(String valor) {
        Nodo n = buscar(valor);
        if (n == null) {
            System.out.println("El valor " + valor + " no existe en el árbol");
            return;
        }
        lista = new ArrayList<>();
        lista = new ArrayList<>();
        getSub(n);
        if (n.getPadre() == null) {
            root = null;
        } else {
            if (n.getPadre().getIzq() == n) {
                n.getPadre().setIzq(null);
            } else {
                n.getPadre().setDer(null);
            }
        }
        for (int i = 1; i < lista.size(); i++) {
            addNodo(new Nodo(lista.get(i)));
        }
        System.out.println("Valor " + valor + " eliminado");
    }

    private void getSub(Nodo nActual) {
        if (nActual != null) {
            lista.add(nActual.getValor());
            getSub(nActual.getDer());
            getSub(nActual.getIzq());
        }
    }

    public Nodo buscar(String busqueda) {
        n = null;
        bus(root, busqueda);
        return n;
    }

    private Nodo n;

    private void bus(Nodo nActual, String busqueda) {
        if (nActual != null) {
            if (nActual.getValor().equals(busqueda)) {
                n = nActual;
            } else {
                bus(nActual.getIzq(), busqueda);
                bus(nActual.getDer(), busqueda);
            }
        }
    }

    public void imprimirInOrder() {
        InOrder(root);
    }

    public void imprimirPreOrder() {
        PreOrder(root);
    }

    public void imprimirPostOrder() {
        PostOrder(root);
    }

    private void PreOrder(Nodo nActual) {
        //RECORRER IZQUIERDA, LEER EL VALOR RECORRER DERECHA
        if (nActual != null) {
            System.out.print("[" + nActual.getValor() + "]");
            PreOrder(nActual.getIzq());
            PreOrder(nActual.getDer());
        }
    }

    private void InOrder(Nodo nActual) {
        //RECORRER IZQUIERDA, LEER EL VALOR RECORRER DERECHA
        if (nActual != null) {
            InOrder(nActual.getIzq());
            System.out.print("[" + nActual.getValor() + "]");
            InOrder(nActual.getDer());
        }
    }

    private void PostOrder(Nodo nActual) {
        //RECORRER IZQUIERDA, LEER EL VALOR RECORRER DERECHA
        if (nActual != null) {
            PostOrder(nActual.getIzq());
            PostOrder(nActual.getDer());
            System.out.print("[" + nActual.getValor() + "]");
        }
    }

    private List<String> lista;

    public List<String> getLista() {
        lista = new ArrayList<>();
        toList(root);
        return lista;
    }

    private void toList(Nodo nActual) {
        if (nActual != null) {
            toList(nActual.getIzq());
            lista.add(nActual.getValor());
            toList(nActual.getDer());
        }
    }

}
