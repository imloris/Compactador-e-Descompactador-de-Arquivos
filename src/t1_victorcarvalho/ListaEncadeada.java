/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1_victorcarvalho;

/**
 *
 * @author victor lopes de carvalho
 */
public class ListaEncadeada {

    private No ini;

    public ListaEncadeada() {
        this.ini = null;
    }

    public boolean vazia() {
        return ini == null;
    }

    public void insereInicio(String elemento) {
        No novo = new No(elemento, ini);
        ini = novo;
    }

    @Override
    public String toString() {
        String strLista = "";
        No temp = ini;

        while (temp != null) {
            strLista = strLista + temp.getElemento() + " ";
            temp = temp.getProx(); //ir para o próximo nó da lista
        }
        return strLista;
    }

    public void remove(String elemento) {
        if (vazia()) {
            System.out.println("Lista Vazia!");
        } else {
            No temp = ini;
            No anterior = null;

            while (temp != null && !temp.getElemento().equals(elemento)) {
                anterior = temp;
                temp = temp.getProx();
            }
            //Somente 1 nó na lista
            if (anterior == null) {
                ini = ini.getProx(); //Remove do início
            } else {
                if (temp != null && temp.getElemento().equals(elemento)) {
                    anterior.setProx(temp.getProx()); //removendo o vínculo temp
                } else {
                    System.out.println(elemento + " NÃO está lista");
                }
            }
        }

    }

    public int buscaLinearIt(String x) {
        No temp = ini;
        int pos = 1;

        while (temp != null) {
            if (temp.getElemento().equals(x)) {//Achou
                return pos;
            } else {
                pos++;
                temp = temp.getProx();
            }
        }
        return -1;//Não achou
    }

}
