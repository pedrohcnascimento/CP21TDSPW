package br.com.fiap.tdspw.model;

public class Locacao {
    private int idLocacao;
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

    public Locacao() {
    }

    public boolean iniciarLocacao() {
        if (veiculo.isDisponivel() && cliente.podeAlugar()) {
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

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public String getInicioLocacao() {
        return dataInicio;
    }

    public void setInicioLocacao(String inicioLocacao) {
        this.dataInicio = inicioLocacao;
    }

    public String getFimLocacao() {
        return dataFim;
    }

    public void setFimLocacao(String fimLocacao) {
        this.dataFim = fimLocacao;
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