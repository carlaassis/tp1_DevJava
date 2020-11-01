package tp1;

import java.util.Arrays;

public class Program {
	
	private static String[] nomes;
	private static float[] notaAv1;
	private static float[] notaAv2;
	
	private static final int QTDE = 3;
	private static final Integer[] OPCOES = {1,2,3,4};
	

	private static float calcularMedia(int id){
		return notaAv1[id] + notaAv2[id] / 2;
	}
	
	private static String obterSituacao(float nFinal){
		return nFinal >= 7 ? "Aprovado" : "pobre";
	}
	
	private static void imprimir(int id) {
		
		float salarioLiquido = calcularSalarioLiquido(id);
		
		String situacao = obterSituacao(salarioLiquido);
		
		System.out.printf("{%d} %s - %d - %.2f - %.2f - %.2f :: Salário Líquido = R$%.2f (%s)\n", 
				id, 
				nomes[id], idades[id], salarios[id], bonus[id], descontos[id], 
				salarioLiquido, situacao);
	}
		

	}

}
