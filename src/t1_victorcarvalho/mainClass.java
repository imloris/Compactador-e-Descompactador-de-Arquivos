/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1_victorcarvalho;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author victor
 */
public class mainClass {

    public static void main(String[] args) {
        Compactador compactador = new Compactador(); //declara o compactador 
        String[] palavrasDaLinha; //lista de palavras
        String textoCompactado = ""; //texto final

        int indiceDaPalavra;
        try {
            List<String> textoCompleto = Files.readAllLines(Paths.get("arquivo.txt")); //lê o arquivo inteiro e seta na list textoCompleto
            textoCompactado = String.join("\n", textoCompleto); //texto final já copiado

            BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt")); //gera o arquivo saida e declara o writer

            for (String linha : textoCompleto) { //anda pelo texto completo
                if (linha.equals("0")) {//verifica se o texto e sai do texto quando ocorrido
                    break;
                }

                palavrasDaLinha = linha.split("\\W+"); //splita as palavras da linha atual

                for (String palavra : palavrasDaLinha) { //anda na linha atual
                    indiceDaPalavra = compactador.buscaLinearIt(palavra);//verifica se a palavra está na lista encadeada e retorna a posição
                    if (indiceDaPalavra == -1) {//se for igual a -1, ele adiciona a palavra na lista encadeada
                        if (palavra.equals("")) {//.split(\\W+) não identifica o identador, se for "", não faz nada
                        } else {
                            compactador.insereInicio(palavra); //adiciona a palavra na lista encadeada
                        }
                    } else {

                        int indiceDaPrimeiraOcorrencia = textoCompactado.indexOf(palavra); //indice da primeira ocorrencia da palavra no texto final
                        String inicioDoTexto = textoCompactado.substring(0, indiceDaPrimeiraOcorrencia + palavra.length());//separa a primeira parte do texto antes da segunda ocorrencia
                        String finalDoTexto = textoCompactado.substring(indiceDaPrimeiraOcorrencia + palavra.length());//separa a segunda a parte do texto junto da segunda ocorrencia

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        System.out.println(palavra);
                        System.out.println(finalDoTexto);

                        textoCompactado = inicioDoTexto + finalDoTexto.replaceFirst(
                                palavra, Integer.toString(indiceDaPalavra));

                        System.out.println(textoCompactado);
                        compactador.remove(palavra);//remove a palavra da lista
                        compactador.insereInicio(palavra);//insera a palavra no inicio da lista novamente
                        indiceDaPalavra = 0;//zera o indice da palavra
                    }
                }
            }

            writer.write(textoCompactado);

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
