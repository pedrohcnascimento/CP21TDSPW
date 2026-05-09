package br.com.fiap.tdspw.view;

import br.com.fiap.tdspw.model.Cliente;
import br.com.fiap.tdspw.model.Locacao;
import br.com.fiap.tdspw.model.Veiculo;

import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // =========================
        // CADASTRO DO VEICULO 1
        // =========================

        System.out.println("=== Cadastro do Veiculo 1 ===");

        System.out.print("Placa: ");
        String placa1 = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo1 = scanner.nextLine();

        System.out.print("Marca: ");
        String marca1 = scanner.nextLine();

        System.out.print("Ano: ");
        int ano1 = scanner.nextInt();
        scanner.nextLine();

        Veiculo veiculo1 = new Veiculo(
                placa1,
                modelo1,
                marca1,
                ano1
        );

        // =========================
        // CADASTRO DO VEICULO 2
        // =========================

        System.out.println("\n=== Cadastro do Veiculo 2 ===");

        System.out.print("Placa: ");
        String placa2 = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo2 = scanner.nextLine();

        System.out.print("Marca: ");
        String marca2 = scanner.nextLine();

        System.out.print("Ano: ");
        int ano2 = scanner.nextInt();
        scanner.nextLine();

        Veiculo veiculo2 = new Veiculo(
                placa2,
                modelo2,
                marca2,
                ano2
        );

        // =========================
        // CADASTRO CLIENTE 1
        // =========================

        System.out.println("\n=== Cadastro do Cliente 1 ===");

        System.out.print("Nome: ");
        String nome1 = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf1 = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone1 = scanner.nextLine();

        Cliente cliente1 = new Cliente(
                nome1,
                cpf1,
                telefone1
        );

        // =========================
        // CADASTRO CLIENTE 2
        // =========================

        System.out.println("\n=== Cadastro do Cliente 2 ===");

        System.out.print("Nome: ");
        String nome2 = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf2 = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone2 = scanner.nextLine();

        Cliente cliente2 = new Cliente(
                nome2,
                cpf2,
                telefone2
        );

        int opcao;

        do {

            System.out.println("\n========== LOCADORA ==========");
            System.out.println("1 - Realizar locacao");
            System.out.println("2 - Devolver veiculo");
            System.out.println("3 - Verificar disponibilidade");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    // =========================
                    // ESCOLHER CLIENTE
                    // =========================

                    System.out.println("\nEscolha o cliente:");
                    System.out.println("1 - " + cliente1.getNome());
                    System.out.println("2 - " + cliente2.getNome());

                    int escolhaCliente = scanner.nextInt();
                    scanner.nextLine();

                    Cliente clienteSelecionado;

                    if (escolhaCliente == 1) {
                        clienteSelecionado = cliente1;
                    } else {
                        clienteSelecionado = cliente2;
                    }

                    // =========================
                    // ESCOLHER VEICULO
                    // =========================

                    System.out.println("\nEscolha o veiculo:");
                    System.out.println("1 - " + veiculo1.getModelo());
                    System.out.println("2 - " + veiculo2.getModelo());

                    int escolhaVeiculo = scanner.nextInt();
                    scanner.nextLine();

                    Veiculo veiculoSelecionado;

                    if (escolhaVeiculo == 1) {
                        veiculoSelecionado = veiculo1;
                    } else {
                        veiculoSelecionado = veiculo2;
                    }

                    // =========================
                    // DATA DA LOCACAO
                    // =========================

                    System.out.print("\nData de inicio da locacao: ");
                    String dataInicio = scanner.nextLine();

                    Locacao locacao = new Locacao(
                            clienteSelecionado,
                            veiculoSelecionado,
                            dataInicio
                    );

                    // =========================
                    // TESTE DA LOCACAO
                    // =========================

                    if (locacao.iniciarLocacao()) {

                        System.out.println("\nLOCACAO REALIZADA COM SUCESSO!");

                        System.out.println("Cliente: "
                                + clienteSelecionado.getNome());

                        System.out.println("Veiculo: "
                                + veiculoSelecionado.getMarca()
                                + " "
                                + veiculoSelecionado.getModelo());

                        System.out.println("Placa: "
                                + veiculoSelecionado.getPlaca());

                    } else {

                        System.out.println("\nNAO FOI POSSIVEL REALIZAR A LOCACAO!");

                        if (!veiculoSelecionado.estaDisponivel()) {
                            System.out.println("Veiculo indisponivel.");
                        }

                        if (!clienteSelecionado.podeAlugar()) {
                            System.out.println("Cliente ja possui uma locacao ativa.");
                        }
                    }

                    break;

                case 2:

                    // =========================
                    // DEVOLVER VEICULO
                    // =========================

                    System.out.println("\nQual veiculo deseja devolver?");
                    System.out.println("1 - " + veiculo1.getModelo());
                    System.out.println("2 - " + veiculo2.getModelo());

                    int devolver = scanner.nextInt();
                    scanner.nextLine();

                    if (devolver == 1) {

                        veiculo1.devolver();

                        cliente1.finalizarLocacao();
                        cliente2.finalizarLocacao();

                        System.out.println("\nVeiculo devolvido com sucesso!");

                    } else {

                        veiculo2.devolver();

                        cliente1.finalizarLocacao();
                        cliente2.finalizarLocacao();

                        System.out.println("\nVeiculo devolvido com sucesso!");
                    }

                    break;

                case 3:

                    // =========================
                    // DISPONIBILIDADE
                    // =========================

                    System.out.println("\n===== DISPONIBILIDADE =====");

                    System.out.println(
                            veiculo1.getModelo()
                                    + ": "
                                    + (veiculo1.estaDisponivel()
                                    ? "Disponivel"
                                    : "Indisponivel")
                    );

                    System.out.println(
                            veiculo2.getModelo()
                                    + ": "
                                    + (veiculo2.estaDisponivel()
                                    ? "Disponivel"
                                    : "Indisponivel")
                    );

                    break;

                case 0:

                    System.out.println("\nSistema encerrado.");
                    break;

                default:

                    System.out.println("\nOpcao invalida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}