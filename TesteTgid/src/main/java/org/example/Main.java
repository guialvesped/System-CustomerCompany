package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 1;
        while (opc != 0) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Empresa");
            System.out.println("0. Sair");
            System.out.println("Digite a opção desejada: ");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    Empresa e1 = new Empresa("12.345.678/0001-95");
                    System.out.println("Digite o seu nome: ");
                    String nome = sc.next();
                    System.out.println("Digite o seu cpf: ");
                    String cpf = sc.next();
                    Cliente c1 = new Cliente(nome, cpf);
                    if (c1.isCpfValid()){
                        System.out.println("Cadasto realizado com sucesso!");
                    }else {
                        System.out.println("CPF inválido!");
                    }
                    System.out.println("\n=== Menu do Cliente ===");
                    System.out.println("1. Realizar Saque");
                    System.out.println("2. Realizar Deposito");
                    System.out.println("0. Sair");
                    System.out.println("Digite a opção desejada");
                    opc = sc.nextInt();
                    switch (opc){
                        case 1:
                            System.out.println("Informe o valor da transação: ");
                            double valor  = sc.nextDouble();
                            c1.realizarSaque(e1,valor);
                            System.out.println("Saque realizado com sucesso!");
                            break;
                        case 2:
                            System.out.println("Informe o valor da transação: ");
                            double valor2  = sc.nextDouble();
                            c1.realizarDeposito(e1,valor2);
                            System.out.println("Saque realizado com sucesso!");
                            break;
                        default:
                            System.out.println("Opcão Inválida");
                    }
                case 2:
                    System.out.println("Digite o seu cnpj: ");
                    String cnpj = sc.next();
                    Empresa empresaPessoal = new Empresa(cnpj);
                    if (empresaPessoal.isValidCnpj()){
                        System.out.println("Cadasto realizado com sucesso!");
                    }else {
                        System.out.println("CPF inválido!");
                    }
                    System.out.println("\n=== Menu da Empresa ===");
                    System.out.println("1. Adicionar Taxa");
                    System.out.println("2. Verificar saldo");
                    System.out.println("0. Sair");
                    System.out.println("Digite a opção desejada");
                    opc = sc.nextInt();
                    switch (opc) {
                        case 1:
                            System.out.println("Informe o nome da taxa: ");
                            String nm_taxa = sc.next();
                            System.out.println("Informe o percentual da taxa: ");
                            double perc_taxa = sc.nextDouble();
                            Taxa taxa1 = new Taxa(nm_taxa, perc_taxa);
                            empresaPessoal.addTaxa(taxa1);
                            break;
                        case 2:
                            System.out.println("O valor do saldo de sua empresa é: " + empresaPessoal.getSaldo());
                            break;
                        default:
                            System.out.println("Opcão Inválida");
                            break;
                    }

            }
        }
    }
}
