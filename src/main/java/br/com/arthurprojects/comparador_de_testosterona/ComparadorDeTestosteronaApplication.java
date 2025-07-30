package br.com.arthurprojects.comparador_de_testosterona;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
@SpringBootApplication
public class ComparadorDeTestosteronaApplication{
			
			// Valores médios de testosterona por idade (ng/dL)
			private static final double[] MEDIA_IDADE = {
				692, 692, 692, 692,  // 15-19
				637, 637, 637, 637,  // 20-24
				608, 608, 608, 608,  // 25-29
				569, 569, 569, 569,  // 30-34
				523, 523, 523, 523,  // 35-39
				468, 468, 468, 468,  // 40-44
				426, 426, 426, 426,  // 45-49
				407, 407, 407, 407   // 50-54
			};
			
			public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("Comparador de Níveis de Testosterona");
				System.out.println("------------------------------------");
				
				// Obter idade do usuário
				System.out.print("Digite sua idade (15-54): ");
				int idade = scanner.nextInt();
				
				if(idade < 15 || idade > 54) {
					System.out.println("Idade fora do intervalo válido (15-54 anos).");
					return;
				}
				
				// Obter os três valores de testosterona
				System.out.print("Digite o primeiro valor de testosterona (mais antigo, em ng/dL): ");
				double testo1 = scanner.nextDouble();
				
				System.out.print("Digite o segundo valor de testosterona (em ng/dL): ");
				double testo2 = scanner.nextDouble();
				
				System.out.print("Digite o terceiro valor de testosterona (mais recente, em ng/dL): ");
				double testo3 = scanner.nextDouble();
				
				// Calcular variações percentuais
				double variacao1Para2 = calcularVariacaoPercentual(testo1, testo2);
				double variacao2Para3 = calcularVariacaoPercentual(testo2, testo3);
				double variacao1Para3 = calcularVariacaoPercentual(testo1, testo3);
				
				// Obter média para a idade
				double mediaIdade = MEDIA_IDADE[idade - 15];
				double comparacaoMedia = (testo3 / mediaIdade) * 100;
				
				// Exibir resultados
				System.out.println("\nResultados:");
				System.out.printf("Variação do primeiro para o segundo período: %.2f%%\n", variacao1Para2);
				System.out.printf("Variação do segundo para o terceiro período: %.2f%%\n", variacao2Para3);
				System.out.printf("Variação total (primeiro para terceiro período): %.2f%%\n", variacao1Para3);
				
				System.out.println("\nComparação com a média para sua idade:");
				System.out.printf("Sua testosterona atual: %.0f ng/dL\n", testo3);
				System.out.printf("Média para sua idade (%d anos): %.0f ng/dL\n", idade, mediaIdade);
				System.out.printf("Você está a %.2f%% da média para sua idade\n", comparacaoMedia);
				
				// Interpretação
				System.out.println("\nInterpretação:");
				if(comparacaoMedia > 120) {
					System.out.println("Seus níveis estão significativamente acima da média para sua idade.");
				} else if(comparacaoMedia > 105) {
					System.out.println("Seus níveis estão acima da média para sua idade.");
				} else if(comparacaoMedia > 95) {
					System.out.println("Seus níveis estão na média alta para sua idade.");
				} else if(comparacaoMedia > 85) {
					System.out.println("Seus níveis estão na média para sua idade.");
				} else if(comparacaoMedia > 70) {
					System.out.println("Seus níveis estão abaixo da média para sua idade.");
				} else {
					System.out.println("Seus níveis estão significativamente abaixo da média para sua idade.");
				}
			} 
			private static double calcularVariacaoPercentual(double valorAntigo, double valorNovo) {
				return ((valorNovo - valorAntigo) / valorAntigo) * 100;
			}
		}

	
