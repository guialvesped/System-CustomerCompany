package org.example;

public class Taxa {
    private String nome;
    private double percentual; // Percentual da taxa

    public Taxa(String nome, double percentual) {
        this.nome = nome;
        this.percentual = percentual;
    }

    public double calcularTaxa(double valor) {
        return valor * (percentual / 100);
    }

    public String getNome() {
        return nome;
    }

    public double getPercentual() {
        return percentual;
    }

}
