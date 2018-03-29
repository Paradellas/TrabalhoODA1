//package BuscaBinaria;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	static List lista = new ArrayList();
	static int contador=0;
	
	public static long buscaBinariaRecursiva(RandomAccessFile dados, long inicio, long fim, String cep, int contador) throws Exception {
        contador++;    
		long meio = (inicio + fim)/ 2;
        Endereco aux = new Endereco();
        dados.seek((meio)*300);
        aux.leEndereco(dados);
        String cepAtual = aux.getCep() ;
        lista.add(cepAtual);

		if (inicio > fim)
			return -1;
		else if(cepAtual.equals(cep)){
			System.out.println("Numero de buscas: " + contador + '\n' + "Caminho percorrido: " + lista);
			return meio;
			}
		else if ((Long.parseLong(cepAtual)) < (Long.parseLong(cep)))
			return buscaBinariaRecursiva(dados, meio+1, fim, cep, contador);
        else
			return buscaBinariaRecursiva(dados, inicio, meio-1, cep, contador);
	}
}
