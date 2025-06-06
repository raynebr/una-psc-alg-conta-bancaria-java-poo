import java.util.Scanner;

public class banco {
    private String nome;
    private String numeroConta;
    private double saldo;

    public banco(String nome, String numeroConta, double saldoInicial) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else if (valor > 0) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Valor de saque inválido.");
        }
    }

    public void exibirSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f%n", saldo);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Informe o nome da pessoa: ");
        String nome = scn.nextLine();

        System.out.print("Informe o número da conta: ");
        String numeroConta = scn.nextLine();

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scn.nextDouble();

        banco conta = new banco(nome, numeroConta, saldoInicial);

        System.out.println("Conta bancária criada com sucesso.");

        String opcao;
        do {
            System.out.println("\nEscolha a operação:");
            System.out.println("[1] Depositar valor");
            System.out.println("[2] Sacar valor");
            System.out.println("[3] Obter saldo disponível");
            System.out.println("[Q] Sair");
            System.out.print("Opção: ");
            opcao = scn.next().toUpperCase();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scn.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case "2":
                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = scn.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case "3":
                    conta.exibirSaldo();
                    break;
                case "Q":
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("Q"));

        scn.close();
    }
}
