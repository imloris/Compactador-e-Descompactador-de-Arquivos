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
public class No {

    private String elemento;
    private No prox;
    
    public No(String elemento, No proxNo){
        this.elemento = elemento;
        this.prox = prox;
    }

    public String getElemento() {
        return elemento;
    }


    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "No{" + "elemento=" + elemento + ", prox=" + prox + '}';
    }
}
