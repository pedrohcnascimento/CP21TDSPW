package br.com.fiap.tdspw.model;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private String dataInicio;
    private String dataFim;
    private boolean ativa;

    public Locacao(Cliente cliente, Veiculo veiculo, String dataInicio) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.ativa = false;
    }

    public boolean iniciarLocacao() {
        if (veiculo.estaDisponivel() && cliente.podeAlugar()) {
            veiculo.alugar();
            cliente.iniciarLocacao();
            ativa = true;
            return true;
        }

        return false;
    }

    public void finalizarLocacao(String dataFim) {
        if (ativa) {
            this.dataFim = dataFim;
            this.ativa = false;
            veiculo.devolver();
            cliente.finalizarLocacao();
        }
    }

    public boolean isAtiva() {
        return ativa;
    }
}