package br.com.fiap.tdspw.model;

public class Locacao {
    private int idLocacao;
    private Cliente cliente;
    private Veiculo veiculo;
    private String inicioLocacao;
    private String fimLocacao;

    public void iniciarLocacao () {
        cliente.setPossuiLocacaoAtiva(true);
        veiculo.setDisponivelVeiculo(false);
    }

    public void finalizarLocacao () {
        cliente.setPossuiLocacaoAtiva(false);
        veiculo.setDisponivelVeiculo(true);
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public String getInicioLocacao() {
        return inicioLocacao;
    }

    public void setInicioLocacao(String inicioLocacao) {
        this.inicioLocacao = inicioLocacao;
    }

    public String getFimLocacao() {
        return fimLocacao;
    }

    public void setFimLocacao(String fimLocacao) {
        this.fimLocacao = fimLocacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}

