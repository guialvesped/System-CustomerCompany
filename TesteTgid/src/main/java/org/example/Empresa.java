package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Empresa {

    private String cnpj;
    private double saldo = 0;
    private List<Taxa> taxas = new LinkedList<>();

    public Empresa(String cnpj) {
        this.cnpj = cnpj;
    }

    public void addTaxa(Taxa taxa) {
        taxas.add(taxa);
    }

    public double applicaTaxa(Transacao t){

        double valorComTaxas = t.getValor();
        if(this.taxas != null){
            for (Taxa taxa : taxas) {
                double valorTaxa = taxa.calcularTaxa(t.getValor());
                valorComTaxas -= valorTaxa; // Subtrai a taxa do valor
                System.out.println("Taxa " + taxa.getNome() + " aplicada: -" + valorTaxa);
            }
        }
        return valorComTaxas;
    }

    public void fazTransacao(Transacao t){
        if (t.getTipo() == "Deposito") {
            saldo += applicaTaxa(t);
        } else if (t.getTipo() == "Saque") {
            saldo -= applicaTaxa(t);
        }

        System.out.println("Transação realizada: " + t.getTipo() + " no valor de " + applicaTaxa(t));
        System.out.println("Saldo atual da empresa: " + saldo);
    }
    public boolean isValidCnpj(){
        cnpj = cnpj.replaceAll("[^0-9]", "");
        if(cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")){
            return false;
        }else {
            return true;
        }
    }


    public List<Taxa> getTaxas() {
        return taxas;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCnpj() {
        return cnpj;
    }
}
