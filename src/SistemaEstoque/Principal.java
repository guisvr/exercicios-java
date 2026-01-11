package SistemaEstoque;

import java.util.Scanner;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        ArrayList<Produto> listaDeProdutos = new ArrayList<>();

        Produto p1 = new Produto("Cadeira", 450, 30);
        Produto p2 = new Produto("Tapete", 200, 10);
        Produto p3 = new Produto("Mesa", 1000, 15);
        Produto p4 = new Produto("Sofá", 2000, 5);
        Produto p5 = new Produto("Cortina", 150, 13);

        listaDeProdutos.add(p1);
        listaDeProdutos.add(p2);
        listaDeProdutos.add(p3);
        listaDeProdutos.add(p4);
        listaDeProdutos.add(p5);

        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n---SISTEMA DE ESTOQUE---");
            System.out.println("1. Ver relatório.");
            System.out.println("2. Buscar produto.");
            System.out.println("3. Remover produto.");
            System.out.println("4. Cadastrar produto.");
            System.out.println("5. Exibir valor total do estoque.");
            System.out.println("6. Sair.");
            System.out.println("Escolha uma opção.");

            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("RELATÓRIO");
                    for (Produto p : listaDeProdutos) {
                        p.exibirInformações();
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("Qual item deseja buscar?");
                    String busca = leitura.nextLine();

                    boolean encontrado = false;

                    for (Produto p : listaDeProdutos) {
                        if (p.getNome().equalsIgnoreCase(busca)) {
                            System.out.println("Produto encontrado.");
                            p.exibirInformações();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Qual item deseja remover?");
                    String remover = leitura.nextLine();
                    listaDeProdutos.removeIf(p -> p.getNome().equalsIgnoreCase(remover));
                    System.out.println("Item removido.");
                    break;

                case 4: 
                
                    System.out.println("Nome do produto: ");
                    String nomeNovo = leitura.nextLine();

                    System.out.println("Preço: R$");
                    double precoNovo = leitura.nextDouble();

                    System.out.println("Quantidade em estoque: ");
                    int qtdNovo = leitura.nextInt();

                    Produto pNovo = new Produto(nomeNovo, precoNovo, qtdNovo);
                    listaDeProdutos.add(pNovo);

                    System.out.println("Produto cadastrado.");
                    break;

                case 5:

                double total = 0;
                for ( Produto p : listaDeProdutos){
                    total += (p.getPreco() * p.getQuantidadeEstoque());
                }
                System.out.println("O valor total do estoque é: R$" + total);
                break;

                case 6:
                    System.out.println("Encerrando programa.");
                    break;

                default:
                    System.out.println("Opção Inválida.");
            }
        }

        // System.out.println("RELÁTÓRIO DE ESTOQUE");

        // double somaTotal = 0;

        // for (Produto p : listaDeProdutos) {
        //     p.exibirInformações();

        //     somaTotal += (p.getPreco() * p.getQuantidadeEstoque());
        // }

        // System.out.println("A soma total de todos os itens é estoque é de R$" + somaTotal);

        // System.out.println("--------------\\----------------------\\----------------");

        // double novaSoma = 0;

        // for (Produto p : listaDeProdutos) {
        //     p.reajustarPreco(20);
        //     p.exibirInformações();
        //     novaSoma += (p.getPreco() * p.getQuantidadeEstoque());
        // }

        // System.out.println("Novo valor total do estoque após o desconto: R$" + novaSoma);

        // System.out.println("---BUSCA POR NOME---");
        // for (Produto p : listaDeProdutos) {
        // if (p.getNome().equalsIgnoreCase("Sofá")) {
        // System.out.println("Produto encontrado! Preço:R$" + p.getPreco());
        // }
        // }

        // System.out.println("---DESCONTO DE 50%---");

        // double somaTotalPosDesconto = 0;

        // for (Produto p : listaDeProdutos) {
        // if (p.getPreco() > 500) {
        // p.reajustarPreco(-50);
        // System.out.println("Desconto aplicado em: " + p.getNome());
        // p.exibirInformações();
        // }
        // somaTotalPosDesconto += (p.getPreco() * p.getQuantidadeEstoque());
        // }
        // System.out.println("Valor total do estoque após desconto de 50%: R$" +
        // somaTotalPosDesconto);
    }
}
