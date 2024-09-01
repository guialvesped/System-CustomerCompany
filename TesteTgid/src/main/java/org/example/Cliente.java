package org.example;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public boolean isCpfValid(){
        cpf = cpf.replaceAll("[^0-9]", "");
        if(cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")){
                return false;
        }else {
            return true;
        }
    }

    public void realizarDeposito(Empresa empresa, double valor) {
        Transacao deposito = new Transacao("Deposito", valor);
        empresa.fazTransacao(deposito);
    }

    public void realizarSaque(Empresa empresa, double valor) {
        Transacao saque = new Transacao("Saque", valor);
        empresa.fazTransacao(saque);
    }

    public String getNome() {
        return nome;
    }


}
