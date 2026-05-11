package br.com.fiap.tdspw.view;

import br.com.fiap.tdspw.model.Cliente;
import br.com.fiap.tdspw.model.Locacao;
import br.com.fiap.tdspw.model.Veiculo;

import javax.swing.*;

public class Terminal {
    public static void main(String[] args) {
        // Definição de variáveis
        int opcao = 0;
        String veiculoSelecionado = "";
        String locador01;


        // Criação de objetos
        Cliente gabriel = new Cliente();
        Cliente murillo = new Cliente();
        Veiculo veiculo01 = new Veiculo();
        Veiculo veiculo02 = new Veiculo();
        Locacao locacao01 = new Locacao();

        // Cadastro do primeiro veiculo
        veiculo01.setModeloVeiculo(JOptionPane.showInputDialog("""
                Cadastro do primeiro veículo.
                
                Insira o modelo do Veículo:"""));
        veiculo01.setPlacaVeiculo(JOptionPane.showInputDialog("""
                Cadastro do primeiro veículo.
                
                Insira a placa do veículo:"""));
        veiculo01.setMarcaVeiculo(JOptionPane.showInputDialog("""
                Cadastro do primeiro veículo.
                
                Insira a marca do veículo:"""));
        veiculo01.setAnoVeiculo(Integer.parseInt(JOptionPane.showInputDialog("""
                Cadastro do primeiro veículo.
                
                Insira o ano do veículo""")));

        // Cadastro do segundo veiculo
        veiculo02.setModeloVeiculo(JOptionPane.showInputDialog("""
                Cadastro do segundo veículo.
                
                Insira o modelo do Veículo:"""));
        veiculo02.setPlacaVeiculo(JOptionPane.showInputDialog("""
                Cadastro do segundo veículo.
                
                Insira a placa do veículo:"""));
        veiculo02.setMarcaVeiculo(JOptionPane.showInputDialog("""
                Cadastro do segundo veículo.
                
                Insira a marca do veículo:"""));
        veiculo02.setAnoVeiculo(Integer.parseInt(JOptionPane.showInputDialog("""
                Cadastro do segundo veículo.
                
                Insira o ano do veículo""")));

        // Cadastro do primeiro cliente
        gabriel.setNome(JOptionPane.showInputDialog("""
                Cadastro do primeiro cliente.
                
                Digite abaixo seu nome:"""));
        gabriel.setCpf(JOptionPane.showInputDialog("""
                Cadastro do primeiro cliente.
                
                Digite abaixo seu CPF:"""));
        gabriel.setTelefone(JOptionPane.showInputDialog("""
                Cadastro do primeiro cliente.
                
                Digite abaixo seu telefone:"""));
        gabriel.registrarCliente();

        // Cadastro do segundo cliente
        murillo.setNome(JOptionPane.showInputDialog("""
                Cadastro do segundo cliente.
                
                Digite abaixo seu nome:"""));
        murillo.setCpf(JOptionPane.showInputDialog("""
                Cadastro do segundo cliente.
                
                Digite abaixo seu CPF:"""));
        murillo.setTelefone(JOptionPane.showInputDialog("""
                Cadastro do segundo cliente.
                
                Digite abaixo seu telefone:"""));
        murillo.registrarCliente();


        do {
            // Login
            locador01 = JOptionPane.showInputDialog(
                    "Seja bem-vindo à locadora de veículos! " +
                            "\nQual é o seu CPF?");

            if (locador01.equalsIgnoreCase(gabriel.getCpf())) {
                JOptionPane.showMessageDialog(null,
                        "Seja bem-vindo!" +
                                "Segue abaixo seus dados: " +
                                "\n -> Nome completo: " + gabriel.getNome() +
                                "\n -> CPF: " + gabriel.getCpf() +
                                "\n -> Telefone: " + gabriel.getTelefone());
            } else if (locador01.equalsIgnoreCase(murillo.getCpf())) {
                JOptionPane.showMessageDialog(null,
                        "Seja bem-vindo!" +
                                "Segue abaixo seus dados: " +
                                "\n -> Nome completo: " + murillo.getNome() +
                                "\n -> CPF: " + murillo.getCpf() +
                                "\n -> Telefone: " + murillo.getTelefone());
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro não encontrado.");
            }

            // Escolha da opção do cliente
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Seja bem-vindo à locadora de veículos!" +
                    "\n Digite o número da opção desejada:\n" +
                    "\n 1) Alugar Veículo" +
                    "\n 2) Devolver veículo" +
                    "\n 3) Mostrar informações de todos os clientes" +
                    "\n 4) Sair"));

            if (locador01.equals(gabriel.getCpf()) && gabriel.isPossuiLocacaoAtiva() && opcao == 1) {
                JOptionPane.showMessageDialog(null, "Você já possui um veículo alugado!");
                continue;
            } else if (locador01.equals(murillo.getCpf()) && murillo.isPossuiLocacaoAtiva() && opcao == 1) {
                JOptionPane.showMessageDialog(null, "Você já possui um veículo alugado!");
                continue;
            }

            // Verificação de disponibilidade e escolha do veículo
            switch (opcao) {
                case 1:
                    if (veiculo01.verificarDisponibilidade() == true && veiculo02.verificarDisponibilidade() == true) {
                        veiculoSelecionado = JOptionPane.showInputDialog("Pois bem, digite a placa do veículo que você deseja alugar:" +
                                "\n --> Placa: " + veiculo01.getPlacaVeiculo() +
                                "\n -> Modelo: " + veiculo01.getModeloVeiculo() +
                                "\n -> Marca: " + veiculo01.getMarcaVeiculo() +
                                "\n -> Ano: " + veiculo01.getAnoVeiculo() + "\n" +
                                "\n --> Placa: " + veiculo02.getPlacaVeiculo() +
                                "\n -> Modelo: " + veiculo02.getModeloVeiculo() +
                                "\n -> Marca: " + veiculo02.getMarcaVeiculo() +
                                "\n -> Ano: " + veiculo02.getAnoVeiculo());
                    } else if (veiculo01.verificarDisponibilidade() == true && veiculo02.verificarDisponibilidade() == false) {
                        veiculoSelecionado = JOptionPane.showInputDialog("Pois bem, digite a placa do veículo que você deseja alugar:" +
                                "\n --> Placa: " + veiculo01.getPlacaVeiculo() +
                                "\n -> Modelo: " + veiculo01.getModeloVeiculo() +
                                "\n -> Marca: " + veiculo01.getMarcaVeiculo() +
                                "\n -> Ano: " + veiculo01.getAnoVeiculo());
                    } else if (veiculo01.verificarDisponibilidade() == false && veiculo02.verificarDisponibilidade() == true) {
                        veiculoSelecionado = JOptionPane.showInputDialog("Pois bem, digite a placa do veículo que você deseja alugar:" +
                                "\n --> Placa: " + veiculo02.getPlacaVeiculo() +
                                "\n -> Modelo: " + veiculo02.getModeloVeiculo() +
                                "\n -> Marca: " + veiculo02.getMarcaVeiculo() +
                                "\n -> Ano: " + veiculo02.getAnoVeiculo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não temos veículos disponíveis no momento.");
                    }

                    // Locação
                    if (veiculoSelecionado.equalsIgnoreCase(veiculo01.getPlacaVeiculo()) && locador01.equals(gabriel.getCpf())) {
                        locacao01.setIdLocacao(1);
                        locacao01.setInicioLocacao(JOptionPane.showInputDialog("Digite a data de inpicio da locação:"));
                        locacao01.setFimLocacao(JOptionPane.showInputDialog("Digite a data do fim da locação:"));
                        locacao01.setCliente(gabriel);
                        locacao01.setVeiculo(veiculo01);
                        locacao01.iniciarLocacao();

                        JOptionPane.showMessageDialog(null,
                                "Parabéns, " + gabriel.getNome() + "!" +
                                        "\n Você alugou o seguinte veículo:\n" +
                                        "\n -> Modelo: " + veiculo01.getModeloVeiculo() +
                                        "\n -> Marca: " + veiculo01.getMarcaVeiculo() +
                                        "\n -> Placa: " + veiculo01.getPlacaVeiculo() +
                                        "\n -> Ano: " + veiculo01.getAnoVeiculo());
                    } else if (veiculoSelecionado.equalsIgnoreCase(veiculo01.getPlacaVeiculo()) && locador01.equals(murillo.getCpf())) {
                        locacao01.setIdLocacao(1);
                        locacao01.setInicioLocacao(JOptionPane.showInputDialog("Digite a data de início da locação:"));
                        locacao01.setFimLocacao(JOptionPane.showInputDialog("Digite a data do fim da locação:"));
                        locacao01.setCliente(murillo);
                        locacao01.setVeiculo(veiculo01);
                        locacao01.iniciarLocacao();

                        JOptionPane.showMessageDialog(null,
                                "Parabéns, " + murillo.getNome() + "!" +
                                        "\n Você alugou o seguinte veículo:\n" +
                                        "\n -> Modelo: " + veiculo01.getModeloVeiculo() +
                                        "\n -> Marca: " + veiculo01.getMarcaVeiculo() +
                                        "\n -> Placa: " + veiculo01.getPlacaVeiculo() +
                                        "\n -> Ano: " + veiculo01.getAnoVeiculo());
                    } else if (veiculoSelecionado.equalsIgnoreCase(veiculo02.getPlacaVeiculo()) && locador01.equals(gabriel.getCpf())) {
                        locacao01.setIdLocacao(1);
                        locacao01.setInicioLocacao(JOptionPane.showInputDialog("Digite a data de início da locação:"));
                        locacao01.setFimLocacao(JOptionPane.showInputDialog("Digite a data do fim da locação:"));
                        locacao01.setCliente(gabriel);
                        locacao01.setVeiculo(veiculo02);
                        locacao01.iniciarLocacao();

                        JOptionPane.showMessageDialog(null,
                                "Parabéns, " + gabriel.getNome() + "!" +
                                        "\n Você alugou o seguinte veículo:\n" +
                                        "\n -> Modelo: " + veiculo02.getModeloVeiculo() +
                                        "\n -> Marca: " + veiculo02.getMarcaVeiculo() +
                                        "\n -> Placa: " + veiculo02.getPlacaVeiculo() +
                                        "\n -> Ano: " + veiculo02.getAnoVeiculo());
                    } else if (veiculoSelecionado.equalsIgnoreCase(veiculo02.getPlacaVeiculo()) && locador01.equals(murillo.getCpf())) {
                        locacao01.setIdLocacao(1);
                        locacao01.setInicioLocacao(JOptionPane.showInputDialog("Digite a data de início da locação:"));
                        locacao01.setFimLocacao(JOptionPane.showInputDialog("Digite a data do fim da locação:"));
                        locacao01.setCliente(murillo);
                        locacao01.setVeiculo(veiculo02);
                        locacao01.iniciarLocacao();

                        JOptionPane.showMessageDialog(null,
                                "Parabéns, " + murillo.getNome() + "!" +
                                        "\n Você alugou o seguinte veículo:\n" +
                                        "\n -> Modelo: " + veiculo02.getModeloVeiculo() +
                                        "\n -> Marca: " + veiculo02.getMarcaVeiculo() +
                                        "\n -> Placa: " + veiculo02.getPlacaVeiculo() +
                                        "\n -> Ano: " + veiculo02.getAnoVeiculo());

                    }
                    break;
                case 2:
                    if (locador01.equals(gabriel.getCpf()) && gabriel.isPossuiLocacaoAtiva() && locacao01.getCliente() == gabriel) {
                        locacao01.finalizarLocacao();
                        JOptionPane.showMessageDialog(null, "Seu veículo foi devolvido com sucesso!");
                    } else if (locador01.equals(murillo.getCpf()) && murillo.isPossuiLocacaoAtiva() && locacao01.getCliente() == murillo) {
                        locacao01.finalizarLocacao();
                        JOptionPane.showMessageDialog(null, "Seu veículo foi devolvido com sucesso!");
                    } else if (locador01.equals(gabriel.getCpf()) && gabriel.isPossuiLocacaoAtiva() == false) {
                        JOptionPane.showMessageDialog(null, "Você não alugou nenhum veículo ainda!");
                    } else if (locador01.equals(murillo.getCpf()) && murillo.isPossuiLocacaoAtiva() == false) {
                        JOptionPane.showMessageDialog(null, "Você não alugou nenhum veículo ainda!");
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Informações de todos os clientes:\n\n" +
                            "Cliente 1:\n" +
                            "Nome: " + gabriel.getNome() + "\n" +
                            "CPF: " + gabriel.getCpf() + "\n" +
                            "Telefone: " + gabriel.getTelefone() + "\n\n" +
                            "Cliente 2:\n" +
                            "Nome: " + murillo.getNome() + "\n" +
                            "CPF: " + murillo.getCpf() + "\n" +
                            "Telefone: " + murillo.getTelefone());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
                    break;
            }
        } while (opcao != 4);
    }
}