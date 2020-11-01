package tp1;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
	private static String[] nomes;
	private static float[] notaAv1;
	private static float[] notaAv2;
	
	private static final int QTDE = 3;
	private static final Integer[] OPCOES = {1,2,3,4};
	

	private static float calcularMedia(int id){
		return notaAv1[id] + notaAv2[id] / 2;
	}
	
	private static String obterSituacao (float calcularMedia){
		if(calcularMedia >= 7) {
			System.out.println("Aprovado");
		}
			else if(calcularMedia >=4 && calcularMedia == 6) {
				System.out.println("Prova Final");
			}
		else {
			System.out.println("Reprovado");}
		return null;
		}

			
	
	private static void imprimir(int id) {
		
		float mediaFinal = calcularMedia(id);
		
		String situacao = obterSituacao(mediaFinal);
		
		System.out.printf("{%d} %s - %f - %f :: Média Final = %f (%s)\n", 
				id, 
				nomes[id], notaAv1[id], notaAv2[id], mediaFinal, situacao);
	}
	
	private static void imprimir() {
		for (int i = 0; i < QTDE; i++) {
			if(nomes[i] != null) {
				imprimir(i);
			}
		}
	}
		
	private static float calcularNotasTurma(int qtde) {
		float somaNotas = 0;
		for(int x = 0; x < qtde; x++) {
			somaNotas = somaNotas + calcularMedia(x);
		}		
		
		return somaNotas;
	}

	public static void main(String[] args) {

		nomes = new String[QTDE];
		notaAv1 = new float[QTDE];
		notaAv2 = new float[QTDE];
		
		
		Scanner in = new Scanner(System.in);
				
		int i = 0;
		int opcao;
		do {
			System.out.println("[1] Registrar as notas de um novo aluno.");
			System.out.println("[2] Consultar boletim de um aluno.");
			System.out.println("[3] Consultar notas da turma.");
			System.out.println("[4] Sair");
			System.out.print("Informe a opção desejada: ");
			opcao = in.nextInt();
			
			if(Arrays.asList(OPCOES).contains(opcao)) {
				
				switch (opcao) {
				case 1:
					if(i < QTDE) {
						System.out.println("Informe o nome do aluno:");
						nomes[i] = in.next();
						
						System.out.println("Informe a nota da AV1:");
						notaAv1[i] = in.nextInt();
						
						System.out.println("Informe a nota da AV2:");
						notaAv2[i] = in.nextFloat();
						
						System.out.println("... Inclusão realizada ...");
						imprimir(i);
						System.out.println("...... com sucesso! ......");
						
						i++;
					}else {
						System.out.println("Impossível realizar um novo cadastramento!");
					}					
					break;

				case 2:
					System.out.print("Informe a identificação do aluno: ");
					int id = in.nextInt();
	
					if(id >= 0 && id < i) {
						System.out.println("... Aluno: ...");
						imprimir(id);
						System.out.println(".............................");
					}else {
						System.out.println("Impossível encontrar o aluno!");
					}
					break;
					
				case 3:
					System.out.println("... Lista de alunos ...");
					imprimir();
					System.out.println(".............................");
					break;
				}
			}else {
				System.out.println("Opção inválida!!!");
			}
		} while (opcao != 4);
		
		System.out.println("Cadastramento finalizado com sucesso!!!");		
		System.out.println("Quantidade de Alunos: " + i);
		System.out.println("Média Final: " + calcularNotasTurma(i));
		System.out.println("Situação: " + obterSituacao(i));
		
		in.close();
	}
	
		

	

}
