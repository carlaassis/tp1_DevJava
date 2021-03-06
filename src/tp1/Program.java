package tp1;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
	private static String[] nomes;
	private static float[] notaAv1;
	private static float[] notaAv2;

	private static final int QTDE = 100;
	private static final Integer[] OPCOES = { 1, 2, 3, 4 };

	private static float calcularMedia(int id) {
		float nota1Aux = notaAv1[id];
		float nota2Aux = notaAv2[id];
		float somatorio = nota1Aux + nota2Aux;
		float media = somatorio / 2;
		return media;
	}

	private static String obterSituacao(float calcularMedia) {
		if (calcularMedia >= 7) {
			return "Aprovado";
		} else if (calcularMedia >= 4 && calcularMedia < 7) {
			return "Prova Final";
		}
		return "Reprovado";
	}

	private static void imprimir(int id) {

		float mediaFinal = calcularMedia(id);

		String situacao = obterSituacao(mediaFinal);

		System.out.printf(
				"{%d}\n Nome do aluno: %s\n Nota da AV1: %.1f\n Nota da AV2: %.1f\n Media Final = %.1f\n Situa��o: (%s)\n",
				id, nomes[id], notaAv1[id], notaAv2[id], mediaFinal, situacao);
	}

	private static void imprimir() {
		for (int i = 0; i < QTDE; i++) {
			if (nomes[i] != null) {
				imprimir(i);
			}
		}
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
			System.out.print("Informe a opcao desejada: ");
			opcao = in.nextInt();

			if (Arrays.asList(OPCOES).contains(opcao)) {

				switch (opcao) {
				case 1:
					if (i < QTDE) {
						System.out.println("Informe o nome do aluno:");
						nomes[i] = in.next();

						System.out.println("Informe a nota da AV1:");
						notaAv1[i] = in.nextFloat();

						System.out.println("Informe a nota da AV2:");
						notaAv2[i] = in.nextFloat();

						System.out.println("x.x.x Inclus�o realizada com sucesso x.x.x");
						imprimir(i);

						i++;
					} else {
						System.out.println("Imposs�vel realizar um novo cadastramento!");
					}
					break;

				case 2:
					System.out.print("Informe a identifica��o do aluno: ");
					int id = in.nextInt();

					if (id >= 0 && id < i) {
						System.out.println("x.x.x Aluno: x.x.x");
						imprimir(id);
						System.out.println(".............................");
					} else {
						System.out.println("Imposs�vel encontrar o aluno!");
					}
					break;

				case 3:
					System.out.println("x.x.x Lista de alunos x.x.x");
					imprimir();
					System.out.println(".............................");
					break;
				}
			} else {
				System.out.println("Op��o inv�lida!!!");
			}
		} while (opcao != 4);

		System.out.println("Cadastramento finalizado com sucesso!");
		System.out.println("Quantidade de Alunos: " + i);

		in.close();
	}

}
