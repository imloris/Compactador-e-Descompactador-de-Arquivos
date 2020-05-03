/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1_victorcarvalho;

import java.io.*;

/**
 *
 * @author victor
 */
public class mainClass {

    public static void main(String[] args) {
        Compactador compactador = new Compactador();
        String close = "0", linha, vetor[];
        int pos;
        try {

            BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"));

            linha = reader.readLine();
            vetor = linha.split("\\W");
            
            for(int i = 0; i < vetor.length; i++){
                pos =  compactador.buscaLinearIt(vetor[i]);
                System.out.println(pos);
                if(pos == -1){
                    compactador.insereInicio(vetor[i]);
                    writer.write(vetor[i]);
                    System.out.println(vetor[i]);
                    i++;
                }
                else{
                    writer.write(Integer.toString(pos));
                    System.out.println(pos);
                    i++;
                }
                
            }
            
            

            while (!linha.equals(close)) {
                linha = reader.readLine();                
                writer.write(linha+"\n");
                
            }

            reader.close();
            writer.flush();
            writer.close();

        } catch (Exception e) {
        }

    }

}
