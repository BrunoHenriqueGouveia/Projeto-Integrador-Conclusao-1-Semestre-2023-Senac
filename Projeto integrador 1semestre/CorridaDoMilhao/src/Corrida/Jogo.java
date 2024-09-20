package Corrida;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
	static Random aleatorio = new Random();

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int dado1 = 0, dado2 = 0, posicao1 = 0, posicao2 = 0;
		String exibir = "";
		String novamente = "";

		// recomeçar o jogo
		do {

			// qtd jogadores
			int qtdJogadores = bemvindo();

			// nomes
			String[] nomes = pedirnomes(qtdJogadores);

			// regras e introdução
			regras();

			

			// com um jogador 
			if (qtdJogadores == 1) {
				int carro = 0;
				String nomej2 = "Jogador2";

				// Quem começa o jogo?(com 1 jogador)
				do {
					String espaco = "";
					dado1 = dado();
					dado2 = dado();
					do {
						System.out.print("Jogue o dado " + nomes[0] + ":");
						espaco = ler.nextLine();
					} while (!espaco.equals(" "));
					System.out.println("Dado:" + dado1);
					System.out.println("-----------------------------------------------------");

					System.out.print("Jogue o dado " + nomej2 + ":");
					System.out.println("Dado:" + dado2);

					System.out.println("=====================================================");
					if (dado1 == dado2) {
						System.err.println("===================");
						System.err.println("||dados iguais   ||\n||jogue novamente||");
						System.err.println("===================");
						System.out.println("=====================================================");
					}
				} while (dado1 == dado2);

				if (dado1 > dado2) {
					System.out.printf("O jogador %s começa a corrida %n", nomes[0]);
					System.out.println("=====================================================");
					carro = 1;
				} else {
					System.out.printf("O jogador %s começa a corrida %n", nomej2);
					System.out.println("=====================================================");
					carro = 2;
				}

				System.out.println();
				System.err.println("============FOI DADA A LARGADA A CORRIDA=============");
				System.out.println();

				double dinheiro1 = 5000;
				double dinheiro2 = 5000;

				dado1 = 0;
				dado2 = 0;
				int valor1 = 0, valor2 = 0;
				int jg1 = 0, jg2 = 0;

				if (carro == 1) {

					// se o 1° jogador começa (com 1 jogador)
					do {
						int num = 0;
						String espaco = "";

						// jogador 1(com 1 jogador)
						do {
							System.out.print("Jogue o dado " + nomes[0] + ":");
							espaco = ler.nextLine();
							num = aleatorio.nextInt(1, 11);

						} while (!espaco.equals(" "));

						switch (posicao1) {

						case 7, 11, 15 -> {
							System.out.println("Esta no mecanico");
							System.out.println();
							valor1 = posicao1;
							posicao1 = -1;
						}

						default -> {

							if (posicao1 == -1) {
								posicao1 = valor1;
							}

							if (jg1 != 2) {
								dado1 = dado();
								posicao1 += dado1;
								if (posicao1 <= 20) {
									System.out.println("DADO:" + dado1);
									System.out.println(frases(posicao1, num));
									dinheiro1 += resultados(posicao1, num);
									System.out.println();
								} else {
									if (jg2 != 2) {
										System.out.println("DADO:" + dado1);
										System.out.println(
												"LINHA DE CHEGADA:\nparabéns você ganhou o prêmio de R$ 3000 reais.");
										System.out.println();
										dinheiro1 += 3000;
										jg1 += 2;

									} else {
										System.out.println("DADO:" + dado1);
										System.out.println("LINHA DE CHEGADA:\nvoçe terminou a corrida");
									}
								}

							} else {
								System.out.println("Voçe terminou a corrida");
								System.out.println("Aguarde seu adversario terminar");
							}

						}
						}

						System.out.println();

						// jogador2 (com 1 jogador)

						System.out.println("Jogue o dado " + nomej2 + ":");
						num = aleatorio.nextInt(1, 11);

						switch (posicao2) {
						case 7, 11, 15 -> {
							System.out.println("Esta no mecanico");
							System.out.println();
							valor2 = posicao2;
							posicao2 = -1;
						}

						default -> {

							if (posicao2 == -1) {
								posicao2 = valor2;
							}
							if (jg2 != 2) {
								dado2 = dado();
								posicao2 += dado2;
								if (posicao2 <= 20) {
									System.out.println("DADO:" + dado2);
									System.out.println(frases(posicao2, num));
									dinheiro2 += resultados(posicao2, num);
									System.out.println();
								} else {
									if (jg1 != 2) {
										System.out.println("DADO:" + dado2);
										System.out.println(
												"LINHA DE CHEGADA:\nparabéns você ganhou o prêmio de R$ 3000 reais.");
										dinheiro2 += 3000;
										System.out.println();
										jg2 += 2;
									} else {
										System.out.println("DADO:" + dado2);
										System.out.println("LINHA DE CHEGADA:\nvoçe terminou a corrida");
									}
								}
							} else {
								System.out.println("Voçe terminou a corrida");
								System.out.println("Aguarde seu adversario terminar");
							}
						}
						}

						tabuleiro1(nomes, nomej2, posicao1, posicao2, dinheiro1, dinheiro2);
						System.out.println();

					} while (posicao1 < 21 || posicao2 < 21);

				}

				// se o segundo jogador começa(com 1 jogador)
				else {
					do {
						int num = aleatorio.nextInt(1, 11);
						String espaco = "";

						// jogador 2(com 1 jogador)

						System.out.println("Jogue o dado " + nomej2 + ":");
						num = aleatorio.nextInt(1, 11);

						switch (posicao2) {
						case 7, 11, 15 -> {
							System.out.println("Esta no mecanico");
							System.out.println();
							valor2 = posicao2;
							posicao2 = -1;

						}
						default -> {

							if (posicao2 == -1) {
								posicao2 = valor2;
							}
							if (jg2 != 2) {
								dado2 = dado();
								posicao2 += dado2;
								if (posicao2 <= 20) {
									System.out.println("DADO:" + dado2);
									System.out.println(frases(posicao2, num));
									dinheiro2 += resultados(posicao2, num);
									System.out.println();
								} else {
									if (jg1 != 2) {
										System.out.println("DADO:" + dado2);
										System.out.println(
												"LINHA DE CHEGADA:\nparabéns você ganhou o prêmio de R$ 3000 reais.");
										dinheiro2 += 3000;
										System.out.println();
										jg2 += 2;
									} else {
										System.out.println("DADO:" + dado2);
										System.out.println("LINHA DE CHEGADA:\nvoçe terminou a corrida");
									}
								}
							} else {
								System.out.println("Voçe terminou a corrida");
								System.out.println("Aguarde seu adversario terminar");
							}

						}
						}

						System.out.println();

						// jogador 1(com 1 jogador)
						do {
							System.out.print("Jogue o dado " + nomes[0] + ":");
							espaco = ler.nextLine();
							num = aleatorio.nextInt(1, 11);

						} while (!espaco.equals(" "));

						switch (posicao1) {
						case 7, 11, 15 -> {
							System.out.println("Esta no mecanico");
							System.out.println();
							valor1 = posicao1;
							posicao1 = -1;
						}
						default -> {
							if (posicao1 == -1) {
								posicao1 = valor1;
							}
							if (jg1 != 2) {
								dado1 = dado();
								posicao1 += dado1;
								if (posicao1 <= 20) {
									System.out.println("DADO:" + dado1);
									System.out.println(frases(posicao1, num));
									dinheiro1 += resultados(posicao1, num);
									System.out.println();
								} else {
									if (jg2 != 2) {
										System.out.println("DADO:" + dado1);
										System.out.println(
												"LINHA DE CHEGADA:\nparabéns você ganhou o prêmio de R$ 3000 reais.");
										dinheiro1 += 3000;
										System.out.println();
										jg1 += 2;
									} else {
										System.out.println("DADO:" + dado1);
										System.out.println("LINHA DE CHEGADA:\nvoçe terminou a corrida");
									}
								}
							} else {
								System.out.println("Voçe terminou a corrida");
								System.out.println("Aguarde seu adversario terminar");

							}

						}
						}

						tabuleiro1(nomes, nomej2, posicao1, posicao2, dinheiro1, dinheiro2);
						System.out.println();

					} while (posicao1 < 21 || posicao2 < 21);

				}

				ganhador1(dinheiro1, dinheiro2, nomes, nomej2);
				System.out.println();

				System.out.println("Deseja exibir o RANKING:(Sim ou Não)");
				exibir = ler.nextLine();
				System.out.println();

				if (exibir.equalsIgnoreCase("sim")) {

					if (dinheiro1 > dinheiro2) {
						ranking(dinheiro1, nomes[0]);
					} else if (dinheiro2 > dinheiro1) {
						ranking(dinheiro2, nomej2);
					} else {
						ranking(dinheiro1, nomes[0]);
					}
				}

			}

			// ===================================================================================================================================================================================
			// ===================================================================================================================================================================================
			// ===================================================================================================================================================================================
			// ===================================================================================================================================================================================
			// ===================================================================================================================================================================================

			// com 2 jogadores
			else if (qtdJogadores == 2) {

				int carro = 0;

				// Quem começa o jogo?
				do {
					String espaco = "";
					dado1 = dado();
					dado2 = dado();
					do {
						System.out.print("Jogue o dado " + nomes[0] + ":");
						espaco = ler.nextLine();
					} while (!espaco.equals(" "));
					System.out.println("Dado:" + dado1);
					System.out.println("-----------------------------------------------------");
					do {
						System.out.print("Jogue o dado " + nomes[1] + ":");
						espaco = ler.nextLine();
					} while (!espaco.equals(" "));
					System.out.println("Dado:" + dado2);
					System.out.println("=====================================================");
					if (dado1 == dado2) {
						System.err.println("===================");
						System.err.println("||dados iguais   ||\n||jogue novamente||");
						System.err.println("===================");
						System.out.println("=====================================================");
					}
				} while (dado1 == dado2);

				if (dado1 > dado2) {
					System.out.printf("O jogador %s começa a corrida %n", nomes[0]);
					System.out.println("=====================================================");
					carro = 1;
				} else {
					System.out.printf("O jogador %s começa a corrida %n", nomes[1]);
					System.out.println("=====================================================");
					carro = 2;
				}

				System.out.println();
				System.err.println("============FOI DADA A LARGADA A CORRIDA=============");
				System.out.println();

				double dinheiro1 = 5000;
				double dinheiro2 = 5000;

				dado1 = 0;
				dado2 = 0;
				int valor1 = 0, valor2 = 0;
				int jg1 = 0, jg2 = 0;

				if (carro == 1) {

					// se o 1° jogador começa
					do {
						int num = 0;
						String espaco = "";

						// jogador 1
						do {
							System.out.print("Jogue o dado " + nomes[0] + ":");
							espaco = ler.nextLine();
							num = aleatorio.nextInt(1, 11);

						} while (!espaco.equals(" "));

						switch (posicao1) {

						case 7, 11, 15 -> {
							System.out.println("Esta no mecanico");
							System.out.println();
							valor1 = posicao1;
							posicao1 = -1;
						}

						default -> {

							if (posicao1 == -1) {
								posicao1 = valor1;
							}

							if (jg1 != 2) {
								dado1 = dado();
								posicao1 += dado1;
								if (posicao1 <= 20) {
									System.out.println("DADO:" + dado1);
									System.out.println(frases(posicao1, num));
									dinheiro1 += resultados(posicao1, num);
									System.out.println();
								} else {
									if (jg2 != 2) {
										System.out.println("DADO:" + dado1);
										System.out.println(
												"LINHA DE CHEGADA:\nparabéns você ganhou o prêmio de R$ 3000 reais.");
										System.out.println();
										dinheiro1 += 3000;
										jg1 += 2;

									} else {
										System.out.println("DADO:" + dado1);
										System.out.println("LINHA DE CHEGADA:\nvoçe terminou a corrida");
									}
								}

							} else {
								System.out.println("Voçe terminou a corrida");
								System.out.println("Aguarde seu adversario terminar");
							}

						}
						}

						System.out.println();

						// jogador2
						do {
							System.out.print("Jogue o dado " + nomes[1] + ":");
							espaco = ler.nextLine();
							num = aleatorio.nextInt(1, 11);

						} while (!espaco.equals(" "));

						switch (posicao2) {
						case 7, 11, 15 -> {
							System.out.println("Esta no mecanico");
							System.out.println();
							valor2 = posicao2;
							posicao2 = -1;
						}

						default -> {

							if (posicao2 == -1) {
								posicao2 = valor2;
							}
							if (jg2 != 2) {
								dado2 = dado();
								posicao2 += dado2;
								if (posicao2 <= 20) {
									System.out.println("DADO:" + dado2);
									System.out.println(frases(posicao2, num));
									dinheiro2 += resultados(posicao2, num);
									System.out.println();
								} else {
									if (jg1 != 2) {
										System.out.println("DADO:" + dado2);
										System.out.println(
												"LINHA DE CHEGADA:\nparabéns você ganhou o prêmio de R$ 3000 reais.");
										dinheiro2 += 3000;
										System.out.println();
										jg2 += 2;
									} else {
										System.out.println("DADO:" + dado2);
										System.out.println("LINHA DE CHEGADA:\nvoçe terminou a corrida");
									}
								}
							} else {
								System.out.println("Voçe terminou a corrida");
								System.out.println("Aguarde seu adversario terminar");
							}
						}
						}

						tabuleiro2(nomes, posicao1, posicao2, dinheiro1, dinheiro2);
						System.out.println();

					} while (posicao1 < 21 || posicao2 < 21);

				}

				// se o segundo jogador começa
				else {
					do {
						int num = aleatorio.nextInt(11);
						String espaco = "";

						// jogador 2
						do {
							System.out.print("Jogue o dado " + nomes[1] + ":");
							espaco = ler.nextLine();
							num = aleatorio.nextInt(1, 11);

						} while (!espaco.equals(" "));

						switch (posicao2) {
						case 7, 11, 15 -> {
							System.out.println("Esta no mecanico");
							System.out.println();
							valor2 = posicao2;
							posicao2 = -1;

						}
						default -> {

							if (posicao2 == -1) {
								posicao2 = valor2;
							}
							if (jg2 != 2) {
								dado2 = dado();
								posicao2 += dado2;
								if (posicao2 <= 20) {
									System.out.println("DADO:" + dado2);
									System.out.println(frases(posicao2, num));
									dinheiro2 += resultados(posicao2, num);
									System.out.println();
								} else {
									if (jg1 != 2) {
										System.out.println("DADO:" + dado2);
										System.out.println(
												"LINHA DE CHEGADA:\nparabéns você ganhou o prêmio de R$ 3000 reais.");
										dinheiro2 += 3000;
										System.out.println();
										jg2 += 2;
									} else {
										System.out.println("DADO:" + dado2);
										System.out.println("LINHA DE CHEGADA:\nvoçe terminou a corrida");
									}
								}
							} else {
								System.out.println("Voçe terminou a corrida");
								System.out.println("Aguarde seu adversario terminar");
							}

						}
						}

						System.out.println();

						// jogador 1
						do {
							System.out.print("Jogue o dado " + nomes[0] + ":");
							espaco = ler.nextLine();
							num = aleatorio.nextInt(1, 11);

						} while (!espaco.equals(" "));

						switch (posicao1) {
						case 7, 11, 15 -> {
							System.out.println("Esta no mecanico");
							System.out.println();
							valor1 = posicao1;
							posicao1 = -1;
						}
						default -> {
							if (posicao1 == -1) {
								posicao1 = valor1;
							}
							if (jg1 != 2) {
								dado1 = dado();
								posicao1 += dado1;
								if (posicao1 <= 20) {
									System.out.println("DADO:" + dado1);
									System.out.println(frases(posicao1, num));
									dinheiro1 += resultados(posicao1, num);
									System.out.println();
								} else {
									if (jg2 != 2) {
										System.out.println("DADO:" + dado1);
										System.out.println(
												"LINHA DE CHEGADA:\nparabéns você ganhou o prêmio de R$ 3000 reais.");
										dinheiro1 += 3000;
										System.out.println();
										jg1 += 2;
									} else {
										System.out.println("DADO:" + dado1);
										System.out.println("LINHA DE CHEGADA:\nvoçe terminou a corrida");
									}
								}
							} else {
								System.out.println("Voçe terminou a corrida");
								System.out.println("Aguarde seu adversario terminar");

							}

						}
						}

						tabuleiro2(nomes, posicao1, posicao2, dinheiro1, dinheiro2);
						System.out.println();

					} while (posicao1 < 21 || posicao2 < 21);

				}

				// mostrar ganhador
				ganhador2(dinheiro1, dinheiro2, nomes);
				System.out.println();

				// exibir ranking

				System.out.println("Deseja exibir o RANKING:(Sim ou Não)");
				exibir = ler.nextLine();
				System.out.println();

				if (exibir.equalsIgnoreCase("sim")) {

					if (dinheiro1 > dinheiro2) {
						ranking(dinheiro1, nomes[0]);
					} else if (dinheiro2 > dinheiro1) {
						ranking(dinheiro2, nomes[1]);
					} else {
						ranking(dinheiro1, nomes[0]);
					}
				}
			}

			System.out.println("Deseja jogar novamente:(Sim ou Não)");
			novamente = ler.nextLine();

			if (novamente.equalsIgnoreCase("não")) {
				System.out.println("Obrigado por joga");
				System.out.println("Ate a proxima!!");
				break;
			}

		} while (novamente.equalsIgnoreCase("sim"));

		// final do codigo......
		ler.close();

	}

	public static void tabuleiro2(String[] nome, int poscarro1, int poscarro2, double valor1, double valor2) {

		String[][] tabuleiro = new String[1][22];

		tabuleiro[0][0] = "| LARGADA          |";
		tabuleiro[0][1] = "| Parada livre     |";
		tabuleiro[0][2] = "| Sorte ou Revés   |";
		tabuleiro[0][3] = "| Imposto          |";
		tabuleiro[0][4] = "| Sorte ou Revés   |";
		tabuleiro[0][5] = "| Pit Stop         |";
		tabuleiro[0][6] = "| Sorte ou Revés   |";
		tabuleiro[0][7] = "| Mecânica         |";
		tabuleiro[0][8] = "| Imposto          |";
		tabuleiro[0][9] = "| Sorte ou Revés   |";
		tabuleiro[0][10] = "| Parada livre     |";
		tabuleiro[0][11] = "| Mecânica         |";
		tabuleiro[0][12] = "| Pit Stop         |";
		tabuleiro[0][13] = "| Imposto          |";
		tabuleiro[0][14] = "| Sorte ou Revés   |";
		tabuleiro[0][15] = "| Mecânica         |";
		tabuleiro[0][16] = "| Sorte ou Revés   |";
		tabuleiro[0][17] = "| Imposto          |";
		tabuleiro[0][18] = "| Sorte ou Revés   |";
		tabuleiro[0][19] = "| Pit Stop         |";
		tabuleiro[0][20] = "| Sorte ou Revés   |";
		tabuleiro[0][21] = "| LINHA DE CHEGADA |";

		for (int i = 0; i < 22; i++) {
			if (i == poscarro1 && i == poscarro2) {
				System.out.println("|------------------|");
				System.out.printf("%s @%s($%5.2f)|#%s($%5.2f)%n", tabuleiro[0][i], nome[0], valor1, nome[1], valor2);
			} else if (i == 21 && poscarro1 >= 21 && poscarro2 >= 21) {
				System.out.println("|------------------|");
				System.out.printf("%s @%s($%5.2f)|#%s($%5.2f)%n", tabuleiro[0][21], nome[0], valor1, nome[1], valor2);
			} else if (i == 21 && poscarro1 >= 21) {
				System.out.println("|------------------|");
				System.out.printf("%s @%s($%5.2f)%n", tabuleiro[0][21], nome[0], valor1);
			} else if (i == 21 && poscarro2 >= 21) {
				System.out.println("|------------------|");
				System.out.printf("%s #%s($%5.2f)%n", tabuleiro[0][21], nome[1], valor2);
			} else if (i == poscarro2) {
				System.out.println("|------------------|");
				System.out.printf("%s #%s($%5.2f)%n", tabuleiro[0][i], nome[1], valor2);
			} else if (i == poscarro1) {
				System.out.println("|------------------|");
				System.out.printf("%s @%s($%5.2f)%n", tabuleiro[0][i], nome[0], valor1);
			} else if (-1 == poscarro1) {
				System.out.println("|------------------|");
				System.out.printf("%s %n", tabuleiro[0][i]);
			} else if (-1 == poscarro2) {
				System.out.println("|------------------|");
				System.out.printf("%s %n", tabuleiro[0][i]);
			} else if (-1 == poscarro1 && -1 == poscarro2) {
				System.out.println("|------------------|");
				System.out.printf("%s %n", tabuleiro[0][i]);
			} else {
				System.out.println("|------------------|");
				System.out.printf("%s %n", tabuleiro[0][i]);
			}
		}

	}

	public static String frases(int dado, int num) {
		String situacao = "";

		switch (dado) {
		case 2, 4, 6, 9, 14, 16, 18, 20 -> {
			situacao = "Sorte ou Réves:\n" + frasesorteOUreves(num);
		}
		case 1, 10 -> {
			situacao = "Parada livre:\nFolga para respirar!Você não tem que fazer nada neste espaço.";
		}
		case 3, 8, 13, 17 -> {
			situacao = "Imposto:\nEssa não, o leão está com fome! Pague ao dono da pista o imposto no valor de R$ 300 reais.";
		}
		case 5, 12, 19 -> {
			situacao = "Pit Stop:\nSeu carro acaba de ser reabastecido com um valor de 500 reais .";
		}
		case 7, 11, 15 -> {
			situacao = "Mecânica:\nVocê entrou numa fria, pois enquanto estiver no mecânico não pode andar . Você ficará uma rodada sem jogar. ";
		}

		}

		return situacao;

	}

	public static int bemvindo() {
		Scanner ler = new Scanner(System.in);
		int qtd = 0;
		do {
			System.out.println("=====================================================");
			System.out.println("                  BEM-VINDO     ");
			System.out.println("             Corrida Do Milhão ");
			System.out.println("=====================================================");
			System.out.print("Informe a quantidade de jogadores: ");
			qtd = ler.nextInt();
			System.out.println("=====================================================");
		} while (qtd < 1 || qtd > 2);

		return qtd;

	}

	public static String[] pedirnomes(int qtd) {
		Scanner ler = new Scanner(System.in);

		String[] nomes = new String[qtd];

		for (int i = 0, cont = 1; i < nomes.length; cont++, i++) {

			switch (qtd) {
			case 1:
				System.out.printf("Informe o nome do jogador: ");
				nomes[i] = ler.nextLine();
				System.out.println("=====================================================");
				break;

			default:
				System.out.printf("Informe o nome do jogador %d: ", cont);
				nomes[i] = ler.nextLine();
				System.out.println("=====================================================");
				break;
			}

		}
		return nomes;

	}

	public static int dado() {
		Random aleatorio = new Random();
		int dado = aleatorio.nextInt(1, 4);
		return dado;
	}

	public static String frasesorteOUreves(int num) {

		String situacao = "";

		switch (num) {
		case 1:
			situacao = "Revés: voçe acaba de ser multado em R$ 1000 reais , placa do seu veiculo esta inelegível.";
			break;
		case 2:
			situacao = "Sorte: parabéns você acaba de ganhar R$ 2000 para trocar seus pneus.";
			break;
		case 3:
			situacao = "Revés: HM, que pena voçe acaba de ser multado no valor de R$ 400 por alta velocidade. ";
			break;
		case 4:
			situacao = "Sorte: Parabéns,você acabou de ganha R$ 1000 reais para pintar o seu carro.";
			break;
		case 5:
			situacao = "Revés: Deu Ruim!! voçe acaba de ser multado em R$ 300 andar sem sinto de segurança.";
			break;
		case 6:
			situacao = "Sorte: Parabéns,voçe acaba de ganhar R$ 2500 para turbinar o seu carro.";
			break;
		case 7:
			situacao = "Revés: HM...Pneu do seu carro esta careca ,voçe acaba de ser multado em R$500. ";
			break;
		case 8:
			situacao = "Sorte: Parabéns, Voçe acaba de ganhar R$1000 para trocar o escapamento.";
			break;
		case 9:
			situacao = "Revés:Hm...Se distraiu no celular tomou multa de R$600.";
			break;
		case 10:
			situacao = "Sorte:Parabéns voçe ganhou R$500 para trocar óleo.";
			break;
		}
		return situacao;
	}

	public static double sorteoureves(int num) {
		double valor = 0;

		switch (num) {
		case 1:
			valor = -1000;
			break;
		case 2:
			valor = 2000;
			break;
		case 3:
			valor = -400;
			break;
		case 4:
			valor = 1000;
			break;
		case 5:
			valor = -300;
			break;
		case 6:
			valor = 2500;
			break;
		case 7:
			valor = -500;
			break;
		case 8:
			valor = 1000;
			break;
		case 9:
			valor = -600;
			break;
		case 10:
			valor = 500;
			break;
		}
		return valor;
	}

	public static double resultados(int dado, int num) {
		double valor = 0;

		switch (dado) {
		case 2, 4, 6, 9, 14, 16, 18, 20 -> {
			valor = sorteoureves(num);
		}
		case 1, 10 -> {
			valor = 0;
			// parada livre
		}
		case 3, 8, 13, 17 -> {
			valor = -300;
		}
		case 5, 12, 19 -> {
			valor = 500;
		}
		case 7, 11, 15 -> {
			valor = 0;
		}
		}

		return valor;

	}

	public static void regras() {
		System.out.println("                 Vamos começar o jogo                ");
		System.out.println("=====================================================");
		System.out.println();
		System.err.println("||=================================================||");
		System.err.println("||               INSTRUÇÃO DO JOGO                 ||");
		System.err.println("||1°Cada jogador começa a corrida com R$5000,00    ||");
		System.err.println("||2°Aperte a tecla espaço e enter para jogar o dado||");
		System.err.println("||3°Num só espaço pode para mais de um carro       ||");
		System.err.println("||=================================================||");
		System.out.println();
		System.err.println("||=================================================||");
		System.err.println("||                 OBJETIVO DO JOGO                ||");
		System.err.println("||         Conquistar o maior valor possível       ||");
		System.out.println("=====================================================");
		System.err.println("||          UM CAMINHO CHEIO DE SURPRESAS!         ||");
		System.err.println("||Preste atenção no que vai acontecer no caminho,  ||");
		System.err.println("||conforme o espaço em que você parar com seu carro||");
		System.err.println("||poderá tira: SORTE-REVÉS, PIT-STOP, IMPOSTO,     ||");
		System.err.println("||MECÂNICO OU PARADA LIVRE.                        ||");
		System.err.println("||=================================================||");
		System.out.println();
		System.out.println("=====================================================");
		System.out.println("     O maior numero no dado começa a corrida:        ");
		System.out.println("=====================================================");

	}

	public static void ranking(double valor1, String nome1) {

		String[] nomes = new String[3];
		double[] valor = new double[3];
		nomes[0] = "pedro";
		nomes[1] = "bruno";
		nomes[2] = "kauan";
		valor[0] = 11000;
		valor[1] = 10000;
		valor[2] = 8000;

		if (valor1 > valor[0]) {
			valor[0] = valor1;
			nomes[0] = nome1;
		} else if (valor1 > valor[1]) {
			valor[1] = valor1;
			nomes[1] = nome1;
		} else if (valor1 > valor[2]) {
			valor[2] = valor1;
			nomes[2] = nome1;
		}

		System.out.println("===============================");
		System.out.println("            RANKING         ");
		int num = 1;

		for (int i = 0; i < nomes.length; i++) {
			System.out.println("-------------------------------");
			System.out.printf("%d° %10s : R$%7.2f %n", num, nomes[i], valor[i]);
			num++;
		}
		System.out.println("===============================");
	}

	public static void ganhador2(double dinheiro1, double dinheiro2, String[] nomes) {

		if (dinheiro1 == dinheiro2) {
			System.out.println("O ganhador foi os dois jogadores");
		} else if (dinheiro1 > dinheiro2) {
			System.out.println("========================================");
			System.out.println("||Parabens " + nomes[0] + " voçe foi o ganhador");
			System.out.printf("||Com um valor de R$ %7.2f%n", dinheiro1);
			System.out.println("========================================");
		} else if (dinheiro2 > dinheiro1) {
			System.out.println("========================================");
			System.out.println("||Parabens " + nomes[1] + " voçe foi o ganhador");
			System.out.printf("||Com um valor de R$ %7.2f%n", dinheiro2);
			System.out.println("========================================");
		}

	}

	public static void tabuleiro1(String[] nome, String nm2, int poscarro1, int poscarro2, double valor1,
			double valor2) {

		String[][] tabuleiro = new String[1][22];

		tabuleiro[0][0] = "| LARGADA          |";
		tabuleiro[0][1] = "| Parada livre     |";
		tabuleiro[0][2] = "| Sorte ou Revés   |";
		tabuleiro[0][3] = "| Imposto          |";
		tabuleiro[0][4] = "| Sorte ou Revés   |";
		tabuleiro[0][5] = "| Pit Stop         |";
		tabuleiro[0][6] = "| Sorte ou Revés   |";
		tabuleiro[0][7] = "| Mecânica         |";
		tabuleiro[0][8] = "| Imposto          |";
		tabuleiro[0][9] = "| Sorte ou Revés   |";
		tabuleiro[0][10] = "| Parada livre     |";
		tabuleiro[0][11] = "| Mecânica         |";
		tabuleiro[0][12] = "| Pit Stop         |";
		tabuleiro[0][13] = "| Imposto          |";
		tabuleiro[0][14] = "| Sorte ou Revés   |";
		tabuleiro[0][15] = "| Mecânica         |";
		tabuleiro[0][16] = "| Sorte ou Revés   |";
		tabuleiro[0][17] = "| Imposto          |";
		tabuleiro[0][18] = "| Sorte ou Revés   |";
		tabuleiro[0][19] = "| Pit Stop         |";
		tabuleiro[0][20] = "| Sorte ou Revés   |";
		tabuleiro[0][21] = "| LINHA DE CHEGADA |";

		for (int i = 0; i < 22; i++) {
			if (i == poscarro1 && i == poscarro2) {
				System.out.println("|------------------|");
				System.out.printf("%s @%s($%5.2f)|#%s($%5.2f)%n", tabuleiro[0][i], nome[0], valor1, nm2, valor2);
			} else if (i == 21 && poscarro1 >= 21 && poscarro2 >= 21) {
				System.out.println("|------------------|");
				System.out.printf("%s @%s($%5.2f)|#%s($%5.2f)%n", tabuleiro[0][21], nome[0], valor1, nm2, valor2);
			} else if (i == 21 && poscarro1 >= 21) {
				System.out.println("|------------------|");
				System.out.printf("%s @%s($%5.2f)%n", tabuleiro[0][21], nome[0], valor1);
			} else if (i == 21 && poscarro2 >= 21) {
				System.out.println("|------------------|");
				System.out.printf("%s #%s($%5.2f)%n", tabuleiro[0][21], nm2, valor2);
			} else if (i == poscarro2) {
				System.out.println("|------------------|");
				System.out.printf("%s #%s($%5.2f)%n", tabuleiro[0][i], nm2, valor2);
			} else if (i == poscarro1) {
				System.out.println("|------------------|");
				System.out.printf("%s @%s($%5.2f)%n", tabuleiro[0][i], nome[0], valor1);
			} else if (-1 == poscarro1) {
				System.out.println("|------------------|");
				System.out.printf("%s %n", tabuleiro[0][i]);
			} else if (-1 == poscarro2) {
				System.out.println("|------------------|");
				System.out.printf("%s %n", tabuleiro[0][i]);
			} else if (-1 == poscarro1 && -1 == poscarro2) {
				System.out.println("|------------------|");
				System.out.printf("%s %n", tabuleiro[0][i]);
			} else {
				System.out.println("|------------------|");
				System.out.printf("%s %n", tabuleiro[0][i]);
			}
		}

	}

	public static void ganhador1(double dinheiro1, double dinheiro2, String[] nomes, String nome2) {

		if (dinheiro1 == dinheiro2) {
			System.out.println("O ganhador foi os dois jogadores");
		} else if (dinheiro1 > dinheiro2) {
			System.out.println("========================================");
			System.out.println("||Parabens " + nomes[0] + " voçe foi o ganhador");
			System.out.printf("||Com um valor de R$ %7.2f %n", dinheiro1);
			System.out.println("========================================");
		} else if (dinheiro2 > dinheiro1) {
			System.out.println("========================================");
			System.out.println("||Parabens " + nome2 + " voçe foi o ganhador");
			System.out.printf("||Com um valor de R$ %7.2f%n", dinheiro2);
			System.out.println("========================================");
		}

	}

}
