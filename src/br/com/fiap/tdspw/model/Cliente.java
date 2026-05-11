package br.com.fiap.tdspw.model;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;

    private boolean locacaoAtiva;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.locacaoAtiva = false;
    }

     public boolean podeAlugar() {
        return !locacaoAtiva;
    }

    public void iniciarLocacao() {
        this.locacaoAtiva = true;
    }

    public void finalizarLocacao() {
        this.locacaoAtiva = false;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isPossuiLocacaoAtiva() {
        return possuiLocacaoAtiva;
    }

    public void setPossuiLocacaoAtiva(boolean possuiLocacaoAtiva) {
        this.possuiLocacaoAtiva = possuiLocacaoAtiva;
    }

    public void registrarCliente() {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}