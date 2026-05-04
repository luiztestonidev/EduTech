package org.example;

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