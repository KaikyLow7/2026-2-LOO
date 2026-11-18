package Visao;

import java.util.Scanner;

import Dominio.Estagiario;
import Servico.EstagiarioServ;
import Tools.Util;

public class EstagiarioMenu extends AbsMenu {

    private EstagiarioServ servico;

    private Estagiario estagiarioSelecionado;

    @Override
    public void executar(){
        int opcao = 0;
        while(opcao != 9){
            System.out.println("\n\n");
            opcao = this.exibirMenuPrincipal("ESTAGIÁRIO");
            switch (opcao) {
                case 1:
                    this.listar();
                    this.pausar();
                    break;
                case 2:
                    this.pesquisarPorCodigo();
                    this.pausar();
                    break;
                case 3:
                    this.incluir();
                    this.pausar();
                    break;
                case 4:
                    this.alterar();
                    this.pausar();
                    break;
                case 5:
                    this.excluir();
                    this.pausar();
                    break;
                case 9:
                    System.out.println("VOLTANDO...");
                    break;
                default:
                    System.out.println("OPA, OPÇÃO ERRADA!!!");
                    this.pausar();
                    break;
            }
            Util.limparTerminal();
        }
    }

    private void listar(){
        System.out.println("\n\n");
        System.out.println("***** LISTAR *****");
        for(Estagiario item : this.servico.listar()){
            item.exibir();
        }
    }

    private void pesquisarPorCodigo(){
        System.out.println("\n\n");
        System.out.println("***** PESQUISAR POR CÓDIGO *****");
        System.out.print("Digite o código: ");
        int codigo = this.scan.nextInt();
        this.scan.nextLine();
        this.estagiarioSelecionado = this.servico.buscar(codigo);
        if(this.estagiarioSelecionado != null){
            this.estagiarioSelecionado.exibir();
        }
        else{
            System.out.println("ERRO - código inválido");
        }
    }

    private void incluir(){
        System.out.println("\n\n");
        System.out.println("***** INCLUIR *****");
        System.out.print("Nome: ");
        String nome = this.scan.nextLine();
        System.out.print("CPF: ");
        String cpf = this.scan.nextLine();
        System.out.print("E-mail: ");
        String email = this.scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = this.scan.nextLine();
        System.out.print("Endereço: ");
        String endereco = this.scan.nextLine();
        System.out.print("Valor da Bolsa: ");
        Double valorBolsa = Double.parseDouble(this.scan.nextLine().replace(",", "."));
        System.out.print("Carga Horária Semanal: ");
        int cargaHorariaSemanal = this.scan.nextInt();
        this.scan.nextLine();
        System.out.print("Área do Estágio: ");
        String areaEstagio = this.scan.nextLine();
        Estagiario novo = new Estagiario(0, nome, cpf, email, telefone, endereco, valorBolsa, cargaHorariaSemanal, areaEstagio);
        novo = this.servico.adicionar(novo);
        novo.exibir();
    }

    private void alterar(){
        System.out.println("\n\n");
        System.out.println("***** ALTERAR *****");
        this.pesquisarPorCodigo();
        if (this.estagiarioSelecionado == null){
            System.out.println("ERRO - não posso prosseguir com alteração.");
            return;
        }
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("O que vc deseja alterar?");
            System.out.println("1 - Nome");
            System.out.println("2 - CPF");
            System.out.println("3 - E-mail");
            System.out.println("4 - Telefone");
            System.out.println("5 - Endereço");
            System.out.println("6 - Valor da Bolsa");
            System.out.println("7 - Carga Horária Semanal");
            System.out.println("8 - Área do Estágio");
            System.out.println("9 - Salvar");
            System.out.print("Selecione um campo: ");
            opcao = this.scan.nextInt();
            this.scan.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = this.scan.nextLine();
                    this.estagiarioSelecionado.setNome(nome);
                    break;

                case 2:
                    System.out.print("CPF: ");
                    String cpf = this.scan.nextLine();
                    this.estagiarioSelecionado.setCpf(cpf);
                    break;

                case 3:
                    System.out.print("E-mail: ");
                    String email = this.scan.nextLine();
                    this.estagiarioSelecionado.setEmail(email);
                    break;

                case 4:
                    System.out.print("Telefone: ");
                    String telefone = this.scan.nextLine();
                    this.estagiarioSelecionado.setTelefone(telefone);
                    break;

                case 5:
                    System.out.print("Endereço: ");
                    String endereco = this.scan.nextLine();
                    this.estagiarioSelecionado.setEndereco(endereco);
                    break;

                case 6:
                    System.out.print("Valor da Bolsa: ");
                    Double valorBolsa = Double.parseDouble(this.scan.nextLine().replace(",", "."));
                    this.estagiarioSelecionado.setValorBolsa(valorBolsa);
                    break;

                case 7:
                    System.out.print("Carga Horária Semanal: ");
                    int cargaHorariaSemanal = this.scan.nextInt();
                    this.scan.nextLine();
                    this.estagiarioSelecionado.setCargaHorariaSemanal(cargaHorariaSemanal);
                    break;

                case 8:
                    System.out.print("Área do Estágio: ");
                    String areaEstagio = this.scan.nextLine();
                    this.estagiarioSelecionado.setAreaEstagio(areaEstagio);
                    break;

                case 9:
                    this.estagiarioSelecionado = this.servico.editar(this.estagiarioSelecionado);
                    this.estagiarioSelecionado.exibir();
                    break;

                default:
                    System.out.println("OPA, OPÇÃO ERRADA!!!");
                    break;
            }
        }
    }

    private void excluir(){
        System.out.println("\n\n");
        System.out.println("***** EXCLUIR *****");
        this.pesquisarPorCodigo();
        if (this.estagiarioSelecionado == null){
            System.out.println("ERRO - não posso prosseguir com exclusão.");
            return;
        }
        System.out.print("Confirma exclusão (1-Sim / 2-Não)? ");
        int opcao = this.scan.nextInt();
        this.scan.nextLine();
        if (opcao == 1){
            this.estagiarioSelecionado = this.servico.excluir(this.estagiarioSelecionado);
            System.out.println("Estagiário excluído:");
            this.estagiarioSelecionado.exibir();
        }
        else{
            System.out.println("Exclusão cancelada.");
        }
    }

    public EstagiarioMenu(){
        this.servico = new EstagiarioServ();
        this.scan = new Scanner(System.in);
    }
}
