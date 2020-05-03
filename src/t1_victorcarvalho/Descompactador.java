/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1_victorcarvalho;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.*;

/**
 *
 * @author victor lopes de carvalho
 */
public class Descompactador extends Object {

    public static void main(String[] args) {
        ListaEncadeada lst = new ListaEncadeada(); //declara o compactador 
        String[] palavrasDaLinha; //lista de palavras
        String textoDescompactado = null; //texto final

        String indiceDaPalavra;
        try {
            List<String> textoCompactado = Files.readAllLines(Paths.get("descompactar.txt")); //lê o arquivo inteiro e seta na list textoCompleto
            textoDescompactado = String.join("\n", textoCompactado); //texto final já copiado

            BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt")); //gera o arquivo saida e declara o writer

            for (String linha : textoCompactado) { //anda pelo texto completo
                if (linha.equals("0")) {//condição de parada da leitura
                    break;
                }

                palavrasDaLinha = linha.split("\\W+"); //splita as palavras da linha atual

                for (String palavra : palavrasDaLinha) { //anda na linha atual
                    indiceDaPalavra = lst.buscaElemento(palavra);//verifica se a palavra está na lista encadeada e retorna a posição
                    if (indiceDaPalavra == null) {//se for igual a -1, ele adiciona a palavra na lista encadeada
                        if (palavra.equals("")) {//.split(\\W+) não identifica o identador, se for "", não faz nada
                        } else {
                            lst.insereInicio(palavra); //adiciona a palavra na lista encadeada
                        }
                    } else {

                        int indiceDaPrimeiraOcorrencia = textoDescompactado.indexOf(indiceDaPalavra); //indice da primeira ocorrencia da palavra no texto final
                        String inicioDoTexto = textoDescompactado.substring(0, indiceDaPrimeiraOcorrencia + indiceDaPalavra.length());//separa a primeira parte do texto antes da segunda ocorrencia
                        String finalDoTexto = textoDescompactado.substring(indiceDaPrimeiraOcorrencia + indiceDaPalavra.length());//separa a segunda a parte do texto junto da segunda ocorrencia

                        textoDescompactado = inicioDoTexto + finalDoTexto.replaceFirst(palavra, indiceDaPalavra);
                        lst.remove(indiceDaPalavra);//remove a palavra da lista
                        lst.insereInicio(indiceDaPalavra);//insera a palavra no inicio da lista novamente
                        indiceDaPalavra = "";//zera o indice da palavra
                    }
                }
            }

            writer.write(textoDescompactado);

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
