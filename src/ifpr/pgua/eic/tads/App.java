package ifpr.pgua.eic.tads;

import java.util.ArrayList;
import java.util.Scanner;

import ifpr.pgua.eic.tads.modelos.Banco;
import ifpr.pgua.eic.tads.modelos.Conta;
import ifpr.pgua.eic.tads.modelos.ContaEspecial;
import ifpr.pgua.eic.tads.modelos.ContaPoupanca;
import ifpr.pgua.eic.tads.modelos.ContaSimples;
import ifpr.pgua.eic.tads.modelos.Pessoa;
import ifpr.pgua.eic.tads.modelos.PessoaFisica;
import ifpr.pgua.eic.tads.modelos.PessoaJuridica;

public class App {

    public static String menuGeral() {
        String str = "";

        str += "1 - Conta\n";
        str += "2 - Pessoa\n";
        str += "3 - Banco\n";
        str += "0 - Voltar\n";

        return str;

    }

    public static String menuBanco() {
        String str = "";

        str += "1 - Listar as pessoas\n";
        str += "2 - Listar as contas\n";
        str += "0 - Voltar\n";

        return str;
    }

    public static String menuConta() {
        String str = "";

        str += "1 - Criar conta Simples\n";
        str += "2 - Criar conta Especial\n";
        str += "3 - Criar conta Poupanca\n";
        str += "4 - Depositar\n";
        str += "5 - Sacar\n";
        str += "6 - Ver dados\n";
        str += "0 - Voltar\n";

        return str;
    }

    public static String menuPessoa() {
        String str = "";
        str += "1 - Cadastrar Fisica\n";
        str += "2 - Cadastrar Juridica\n";
        str += "3 - Mostrar\n";
        str += "0 - Voltar\n";

        return str;
    }

    public static void main(String[] args) throws Exception {
        
        Banco banco = new Banco("Bamerindus", "009-0099", "001001/00-9");

        Scanner scan = new Scanner(System.in);
        int opcao;

        int numeroDaConta;
        int agencia;
        String documento;
        String senha;
        boolean ativa;
        double saldo, valor, limite, txRendimento;

        String nome, cpf, cnpj;
        int idade;
        double salario,patrimonio;

        do {
            System.out.println(menuGeral());
            opcao = scan.nextInt();
            scan.nextLine();
            if (opcao == 2) { // Menu da pessoa
                System.out.println(menuPessoa());
                opcao = scan.nextInt();
                scan.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome:");
                        nome = scan.nextLine();
                        System.out.println("Digite o cpf:");
                        cpf = scan.nextLine();
                        System.out.println("Digite a idade:");
                        idade = scan.nextInt();
                        System.out.println("Digite o salario:");
                        salario = scan.nextDouble();

                        PessoaFisica pessoa = new PessoaFisica(nome, cpf, idade, salario);
                        
                        if(banco.cadastrarPessoaFisica(pessoa)){
                            System.out.println("Cadastrada!");
                        }else{
                            System.out.println("Erro ao cadastrar. Documento repetido!");
                        }
                        break;
                    case 2:
                        System.out.println("Digite o nome:");
                        nome = scan.nextLine();
                        System.out.println("Digite o cnpj:");
                        cnpj = scan.nextLine();
                        System.out.println("Digite o patrimonio:");
                        patrimonio = scan.nextDouble();

                        PessoaJuridica pj = new PessoaJuridica(nome, cnpj, patrimonio);
                        
                        if(banco.cadastrarPessoaJuridica(pj)){
                            System.out.println("Cadastrada!");
                        }else{
                            System.out.println("Erro ao cadastrar. Documento repetido!");
                        }
                        break;
                    case 3:
                        
                        System.out.println("####Pessoas Fisicas####");
                        for(PessoaFisica temppf:banco.getPessoasFisica()){
                            System.out.println(temppf);
                        }
                        
                        System.out.println("####Pessoas Juridica####");
                        for(PessoaJuridica pj1:banco.getPessoasJuridica()){
                            System.out.println(pj1);
                        }

                        break;
                }
            } else if (opcao == 1) {

                System.out.println(menuConta());
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:

                        System.out.println("Digite o documento da pessoa fisica:");
                        documento = scan.nextLine();

                        PessoaFisica pessoaFisica = banco.buscarPessoaFisica(documento);

                        if (pessoaFisica != null) {
                            System.out.println("Digite o número da conta:");
                            numeroDaConta = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Digite a agência:");
                            agencia = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Digite a senha:");
                            senha = scan.nextLine();

                            System.out.println("Está ativa (1-sim;0-não)");
                            opcao = scan.nextInt();
                            ativa = opcao == 1;
                            System.out.println("Digite o saldo:");
                            saldo = scan.nextDouble();
                            ContaSimples contaSimples = new ContaSimples(numeroDaConta, agencia, senha, ativa, saldo,pessoaFisica);

                            if(banco.cadastrarContaSimples(contaSimples)){
                                System.out.println("Conta criada!!");
                            }else{
                                System.out.println("Conta não criada!!");
                            }
                        } else {
                            System.out.println("Pessoa não encontrada!!!");
                        }
                        break;
                    case 2:

                        System.out.println("Digite o documento da pessoa fisica:");
                        documento = scan.nextLine();

                        PessoaFisica pessoaFisica1 = banco.buscarPessoaFisica(documento);

                        if (pessoaFisica1 != null) {
                            System.out.println("Digite o número da conta:");
                            numeroDaConta = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Digite a agência:");
                            agencia = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Digite a senha:");
                            senha = scan.nextLine();

                            System.out.println("Está ativa (1-sim;0-não)");
                            opcao = scan.nextInt();
                            ativa = opcao == 1;
                            System.out.println("Digite o saldo:");
                            saldo = scan.nextDouble();

                            System.out.println("Digite o limite:");
                            limite = scan.nextDouble();


                            ContaEspecial contaEspecial = new ContaEspecial(numeroDaConta, agencia, senha, ativa, saldo,pessoaFisica1,limite);

                            if(banco.cadastrarContaEspecial(contaEspecial)){
                                System.out.println("Conta criada!!");
                            }else{
                                System.out.println("Conta não criada!!");
                            }
                        } else {
                            System.out.println("Pessoa não encontrada!!!");
                        }
                        break;
                    case 3:

                        System.out.println("Digite o documento da pessoa fisica:");
                        documento = scan.nextLine();

                        PessoaFisica pessoaFisica2 = banco.buscarPessoaFisica(documento);

                        if (pessoaFisica2 != null) {
                            System.out.println("Digite o número da conta:");
                            numeroDaConta = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Digite a agência:");
                            agencia = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Digite a senha:");
                            senha = scan.nextLine();

                            System.out.println("Está ativa (1-sim;0-não)");
                            opcao = scan.nextInt();
                            ativa = opcao == 1;
                            System.out.println("Digite o saldo:");
                            saldo = scan.nextDouble();

                            System.out.println("Digite a taxa de rendimento:");
                            txRendimento = scan.nextDouble();


                            ContaPoupanca contaPoupanca = new ContaPoupanca(numeroDaConta, agencia, senha, ativa, saldo,pessoaFisica2,txRendimento);

                            if(banco.cadastrarContaPoupanca(contaPoupanca)){
                                System.out.println("Conta criada!!");
                            }else{
                                System.out.println("Conta não criada!!");
                            }
                        } else {
                            System.out.println("Pessoa não encontrada!!!");
                        }
                        break;
                    case 4:
                        System.out.println("Depositar!");
                        /*if (conta != null) {
                            System.out.println("Digite um valor:");
                            valor = scan.nextDouble();
                            if (conta.depositar(valor)) {
                                System.out.println("Realizado!");
                            } else {
                                System.out.println("Não Realizado! Valor insuficiente!");
                            }

                        } else {
                            System.out.println("Não permitido! Crie uma conta!");
                        }*/
                        break;

                    case 5:
                        System.out.println("Sacar!");
                        /*if (conta != null) {
                            System.out.println("Digite um valor:");
                            valor = scan.nextDouble();
                            if (conta.sacar(valor)) {
                                System.out.println("Realizado!");
                            } else {
                                System.out.println("Não realizado! Valor inválido ou insuficiente!");
                            }

                        } else {
                            System.out.println("Não permitido! Crie uma conta!");
                        }*/
                        break;
                    case 6:
                        System.out.println("Relatório!");
                        System.out.println("##Contas Simples##");
                        for(ContaSimples cs:banco.getContasSimples()){
                            System.out.println(cs);
                        }
                        System.out.println("##Contas Especial##");
                        for(ContaEspecial ce:banco.getContasEspeciais()){
                            System.out.println(ce);
                        }System.out.println("##Contas Poupanca##");
                        for(ContaPoupanca cp:banco.getContasPoupancas()){
                            System.out.println(cp);
                        }
                        break;
                }
            } else if (opcao == 3) {
                System.out.println(menuBanco());
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Listar pessoas Fisicas!");
                        ArrayList<PessoaFisica> lista = banco.getPessoasFisica();
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(lista.get(i));
                        }

                        System.out.println("Listar pessoas Juridicas!");
                        ArrayList<PessoaJuridica> listapj = banco.getPessoasJuridica();
                        for (int i = 0; i < listapj.size(); i++) {
                            System.out.println(listapj.get(i));
                        }

                        break;
                    case 2:
                        System.out.println("Listar contas!");
                        System.out.println("##Contas Simples##");
                        for(ContaSimples cs:banco.getContasSimples()){
                            System.out.println(cs);
                        }
                        System.out.println("##Contas Especial##");
                        for(ContaEspecial ce:banco.getContasEspeciais()){
                            System.out.println(ce);
                        }System.out.println("##Contas Poupanca##");
                        for(ContaPoupanca cp:banco.getContasPoupancas()){
                            System.out.println(cp);
                        }
                        break;
                }
            }

        } while (opcao != 0);

    }
}
