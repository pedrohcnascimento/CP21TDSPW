package br.com.fiap.tdspw.model;

public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private boolean disponivel;

    public Veiculo(String placa, String modelo, String marca, int ano) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.disponivel = true;
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void alugar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }
}
