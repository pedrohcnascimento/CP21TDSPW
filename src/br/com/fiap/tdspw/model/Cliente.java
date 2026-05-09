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
