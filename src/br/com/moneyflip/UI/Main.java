package br.com.moneyflip.UI;

import br.com.moneyflip.classes.AppLogic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        try {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║            🌟💸 Bem-vindo ao MoneyFlip! 💸🌟               ║");
        System.out.println("║          💱 Conversor de Moedas Internacional 💱           ║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println("║ Digite o código da moeda (padrão ISO 4217):                ║");
        System.out.println("║ Ex: Real - BRL | Dólar - USD | Euro - EUR | Peso - ARS     ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.print("🔹 Moeda de origem (ex: USD): ");
        System.out.println();
        String moedaDeOrigem = scanner.nextLine().toUpperCase();

        System.out.print("🔹 Moeda de destino (ex: BRL): ");
        System.out.println();
        String moedaDeDestino = scanner.nextLine().toUpperCase();

        System.out.print("🔹 Valor a converter: ");
        System.out.println();
        double valor = scanner.nextDouble();

        System.out.println("\n🔄 Convertendo " + valor + " " + moedaDeOrigem + " para " + moedaDeDestino + "...");
        double valorConvertido = AppLogic.convertido(valor, moedaDeOrigem, moedaDeDestino);
        System.out.printf("✅ Resultado: %.2f %s\n", valorConvertido, moedaDeDestino);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}