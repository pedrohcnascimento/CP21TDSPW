package br.com.fiap.tdspw.model;

public class Veiculo {
    private String modeloVeiculo;
    private String placaVeiculo;
    private String marcaVeiculo;
    private int anoVeiculo;
    private boolean disponivel = true;

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public int getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(int anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void alugar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }
}
