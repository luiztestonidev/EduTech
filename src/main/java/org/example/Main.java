package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static String[] nomes = {
            "ByteBurger Clássico", "ByteBurger Duplo",
            "Batata Frita P", "Batata Frita G",
            "Refrigerante Lata", "Suco Natural", "Água"
    };

    static double[] precos = {22.90, 29.90, 12.00, 18.00, 7.00, 10.00, 4.00};

    static int[] codigos = {1, 2, 3, 4, 5, 6, 7};

    static double totalGeral = 0;
    static double descontoAtual = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1 - Novo Pedido");
            System.out.println("2 - Consultar Cardápio por Categoria");
            System.out.println("3 - Calcular Troco");
            System.out.println("4 - Sorteio do Dia");
            System.out.println("0 - Encerrar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    novoPedido(scanner);
                    break;
                case 2:
                    consultarCategoria(scanner);
                    break;
                case 3:
                    calcularTroco(scanner);
                    break;
                case 4:
                    sorteio();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }

        } while (opcao != 0);

        scanner.close();
    }
    static void novoPedido(Scanner scanner) {

        scanner.nextLine();

        System.out.print("Nome do cliente: ");
        String cliente = scanner.nextLine();

        String[] itensPedido = new String[100];
        int contadorItens = 0;
        double total = 0;

        char continuar;

        do {
            System.out.println("\n--- CARDÁPIO ---");
            for (int i = 0; i < codigos.length; i++) {
                System.out.printf("%d - %s R$ %.2f%n", codigos[i], nomes[i], precos[i]);
            }

            int codigoDigitado;
            boolean encontrado;

            do {
                System.out.print("Digite o código do item: ");
                codigoDigitado = scanner.nextInt();
                encontrado = false;

                for (int i = 0; i < codigos.length; i++) {
                    if (codigos[i] == codigoDigitado) {

                        double precoFinal = precos[i];

                        // aplica desconto do sorteio
                        if (descontoAtual > 0) {
                            precoFinal -= descontoAtual;
                        }

                        itensPedido[contadorItens++] =
                                nomes[i] + " - R$ " + String.format("%.2f", precoFinal);

                        total += precoFinal;

                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Código inválido! Tente novamente.");
                }

            } while (!encontrado);

            System.out.print("Adicionar mais itens? (S/N): ");
            continuar = scanner.next().toUpperCase().charAt(0);

        } while (continuar == 'S');

        System.out.println("\n--- RESUMO DO PEDIDO ---");
        System.out.println("Cliente: " + cliente);

        System.out.println("Itens:");
        for (int i = 0; i < contadorItens; i++) {
            System.out.println("- " + itensPedido[i]);
        }

        System.out.printf("Total do pedido: R$ %.2f%n", total);

        totalGeral += total;
    }
    
    static void consultarCategoria(Scanner scanner) {

        System.out.println("\n1 - Lanches");
        System.out.println("2 - Acompanhamentos");
        System.out.println("3 - Bebidas");
        System.out.print("Escolha: ");

        int subMenu = scanner.nextInt();

        switch (subMenu) {
            case 1:
                System.out.println("\nLanches:");
                for (int i = 0; i < 2; i++) {
                    System.out.printf("%d - %s R$ %.2f%n", codigos[i], nomes[i], precos[i]);
                }
                break;

            case 2:
                System.out.println("\nAcompanhamentos:");
                for (int i = 2; i < 4; i++) {
                    System.out.printf("%d - %s R$ %.2f%n", codigos[i], nomes[i], precos[i]);
                }
                break;

            case 3:
                System.out.println("\nBebidas:");
                for (int i = 4; i < 7; i++) {
                    System.out.printf("%d - %s R$ %.2f%n", codigos[i], nomes[i], precos[i]);
                }
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    static void calcularTroco(Scanner scanner) {

        if (totalGeral == 0) {
            System.out.println("Nenhum pedido foi realizado ainda!");
            return;
        }

        System.out.printf("Total de todos os pedidos: R$ %.2f%n", totalGeral);

        double pago;

        do {
            System.out.print("Valor pago pelo cliente: R$ ");
            pago = scanner.nextDouble();

            if (pago < totalGeral) {
                System.out.println("Valor insuficiente!");
            }

        } while (pago < totalGeral);

        double troco = pago - totalGeral;

        System.out.printf("Troco: R$ %.2f%n", troco);
    }

    static void sorteio() {

        Random rand = new Random();
        int sorteado = rand.nextInt(7);

        descontoAtual = precos[sorteado] * 0.8;

        System.out.println("\n ITEM SORTEADO DO DIA!");
        System.out.println("Item: " + nomes[sorteado]);

        System.out.printf("Preço original: R$ %.2f%n", precos[sorteado]);
        System.out.printf("Com 20%% de desconto: R$ %.2f%n", descontoAtual);
    }
}