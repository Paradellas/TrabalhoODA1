//package BuscaBinaria;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) 
    {
       try{
        
       RandomAccessFile f = new RandomAccessFile("cep_ordenado.dat", "r");
       Endereco e = new Endereco();
       Scanner ler = new Scanner(System.in);
       System.out.println("Digite o cep para pesquisa :");
       String cep = ler.nextLine();
       long primeiro = 0;
       long ultimo = (f.length()/300)-1;
       long resultado = Utils.buscaBinariaRecursiva(f, primeiro, ultimo, cep, 0);
       f.seek(resultado*300);
       e.leEndereco(f);
       System.out.println("Informacoes do cep pesquisado:" +e);
       f.close();
       }
       catch(Exception e){
            System.out.println("Cep nao encontrado.");
       }
    }
}
