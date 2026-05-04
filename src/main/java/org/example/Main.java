package org.example;
import java.util.Scanner;

public class Main {
    static void main() {
        static String[] nomes = {
                "ByteBurger Clássico", "ByteBurger Duplo",
                "Batata Frita P", "Batata Frita G",
                "Refrigerante Lata", "Suco Natural", "Água"
        };
        static double[] precos = {22.90, 29.90, 12.00, 18.00, 7.00, 10.00, 4.00};

        static double totalGeral = 0;   // caixa geral
        static double descontoAtual = 0; // desconto do sorteio

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\n=== MENU PRINCIPAL ===");
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
                        System.out.println("Opção inválida!");
                }

            } while (opcao != 0);

            scanner.close();
        }


    }
}
