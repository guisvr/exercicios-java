package SistemaEstoque;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();

        Produto p1 = new ProdutoComum("Cadeira", 450, 30);
        Produto p2 = new ProdutoComum("Tapete", 200, 10);
        Produto p3 = new ProdutoComum("Mesa", 1000, 15);
        Produto p4 = new ProdutoComum("Sofá", 2000, 5);
        Produto p5 = new ProdutoComum("Cortina", 150, 13);
        ProdutoPerecivel p6 = new ProdutoPerecivel("Leite", 6, 200, "13/01/2026");

        listaDeProdutos.add(p1);
        listaDeProdutos.add(p2);
        listaDeProdutos.add(p3);
        listaDeProdutos.add(p4);
        listaDeProdutos.add(p5);
        listaDeProdutos.add(p6);

        // aplicarDescontoPerecivel(listaDeProdutos);

        int opcao = 0;
        while (opcao != 7) {
            exibirOpcoes();

            try {
                opcao = leitura.nextInt();
                leitura.nextLine();

                switch (opcao) {
                    case 1:
                        exibirRelatorio(listaDeProdutos);
                        break;

                    case 2:
                        realizarBusca(listaDeProdutos, leitura);
                        break;

                    case 3:
                        removerProduto(listaDeProdutos, leitura);
                        break;

                    case 4:
                        cadastrarProduto(listaDeProdutos, leitura);
                        break;

                    case 5:
                        calcularPatrimonio(listaDeProdutos);
                        break;

                    case 6:
                        exibirEstatisticas(listaDeProdutos);
                        break;

                    case 7:
                        verificarEstoqueCritico(listaDeProdutos);
                        break;

                    case 8:
                        aplicarPromocaoRelampago(listaDeProdutos);
                        break;

                    case 9:
                        System.out.println("Encerrando programa.");
                        break;

                    default:
                        System.out.println("Opção Inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas os números indicados no menu.");
                leitura.next();
                opcao = 0;
            }
        }

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

    public static void exibirOpcoes() {
        System.out.println("\n--- SISTEMA DE ESTOQUE ---");
        System.out.println("1. Ver relatório");
        System.out.println("2. Buscar produto");
        System.out.println("3. Remover produto");
        System.out.println("4. Adicionar produto");
        System.out.println("5. Patrimônio total");
        System.out.println("6. Exibir estatisticas.");
        System.out.println("7. verificar estoque crítico.");
        System.out.println("8. Aplicar cupom de desconto.");
        System.out.println("9. Sair");
        System.out.print("Escolha uma opção: ");
        System.out.println();
    }

    public static void exibirRelatorio(ArrayList<Produto> lista) {
        System.out.println("RELATÓRIO");
        for (Produto p : lista) {
            p.exibirInformações();

            System.out.println("Total de impostos a pagar. R$" + p.calcularImposto());
            System.out.println();
        }
    }

    public static void realizarBusca(ArrayList<Produto> lista, Scanner sc) {
        System.out.print("Nome para busca: ");
        String nome = sc.nextLine();

        for (Produto p : lista) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                p.exibirInformações();
                return;
            }
        }
        System.out.println("Não encontrado.");
    }

    public static void removerProduto(ArrayList<Produto> lista, Scanner sc) {
        System.out.println("Qual item deseja remover?");
        String remover = sc.nextLine();
        lista.removeIf(p -> p.getNome().equalsIgnoreCase(remover));
        System.out.println("Item removido.");
    }

    public static void cadastrarProduto(ArrayList<Produto> lista, Scanner sc) {
        System.out.println("Nome do produto: ");
        String nomeNovo = sc.nextLine();

        boolean precoValido = false;
        double precoNovo = 0;

        while (!precoValido) {
            try {
                System.out.println("Preço: R$");
                precoNovo = sc.nextDouble();
                if (precoNovo > 0) {
                    precoValido = true;
                } else {
                    System.out.println("Preço inválido. Preço deve ser maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro! Digite um valor válido.");
                sc.next();
            }
        }
        int qtdNovo = 0;
        boolean qtdValida = false;

        while (!qtdValida) {
            try {
                System.out.println("Quantidade em estoque: ");
                qtdNovo = sc.nextInt();
                if (qtdNovo > 0) {
                    qtdValida = true;
                } else {
                    System.out.println("Quantidade inválida. Valor deve ser maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro! Digite um valor válido.");
                sc.next();
            }
        }
        sc.nextLine();
        Produto pNovo = new ProdutoComum(nomeNovo, precoNovo, qtdNovo);
        lista.add(pNovo);

        System.out.println("Produto cadastrado.");
    }

    public static void calcularPatrimonio(ArrayList<Produto> lista) {
        double total = 0;
        for (Produto p : lista) {
            total += (p.getPreco() * p.getQuantidadeEstoque());
        }
        System.out.println("O valor total do estoque é: R$" + total);
    }

    public static void exibirMaisCaro(ArrayList<Produto> lista) {
        if (lista.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }

        Produto maisCaro = lista.get(0);
        for (Produto p : lista) {
            if (p.getPreco() > maisCaro.getPreco()) {
                maisCaro = p;
            }
        }
        System.out
                .println("Produto de maior valor no estoque: " + maisCaro.getNome() + "(" + maisCaro.getPreco() + ").");
    }

    public static void exibirMenorQtd(ArrayList<Produto> lista) {
        if (lista.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }

        Produto menorQtd = lista.get(0);
        for (Produto p : lista) {
            if ((p.getQuantidadeEstoque() >= 0) && (p.getQuantidadeEstoque() < menorQtd.getQuantidadeEstoque())) {
                menorQtd = p;
            }
        }
        System.out.println("Produto com menor quantidade em estoque: " + menorQtd.getNome() + "("
                + menorQtd.getQuantidadeEstoque() + ").");
    }

    public static void exibirMediaPrecos(ArrayList<Produto> lista) {
        if (lista.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }

        double somaTotal = 0;
        for (Produto p : lista) {
            somaTotal += p.getPreco();
        }
        double media = somaTotal / lista.size();
        System.out.println("A média de preço dos produtos é: R$" + media);
    }

    public static void exibirEstatisticas(ArrayList<Produto> lista) {
        if (lista.isEmpty()) {
            System.out.println("Não há dados para exibir estatisticas.");
            return;
        }

        double totalImpostos = 0;
        for (Produto p : lista) {
            totalImpostos += p.calcularImposto();
        }
        System.out.println("ESTATÍSTICAS");
        exibirMaisCaro(lista);
        exibirMenorQtd(lista);
        exibirMediaPrecos(lista);

        System.out.println("Total de impostos a pagar: R$" + totalImpostos);
    }

    public static void aplicarDescontoPerecivel(ArrayList<Produto> lista) {
        System.out.println("DESCONTO DE 10% EM PERECÍVEIS");

        for (Produto p : lista) {
            if (p instanceof ProdutoPerecivel) {
                p.reajustarPreco(-10);
                System.out.println("Desconto aplicado no produto: " + p.getNome());
            }
        }
    }

    public static void verificarEstoqueCritico(ArrayList<Produto> lista) {
        System.out.println("ALERTA DE ESTOQUE CRÍTICO");
        boolean encontrouCritico = false;

        for (Produto p : lista) {
            int limiteCritico;

            if (p instanceof ProdutoPerecivel) {
                limiteCritico = 20;
            } else {
                limiteCritico = 10;
            }

            if (p.getQuantidadeEstoque() < limiteCritico) {
                System.out.println(
                        "Produtos como estoque crítico:\n" + p.getNome() + " | Qtd: " + p.getQuantidadeEstoque());
                encontrouCritico = true;
            }
        }
        if (!encontrouCritico) {
            System.out.println("Nenhum item em nível críticio.");
        }
    }

    public static void aplicarPromocaoRelampago(ArrayList<Produto> lista) {
        System.out.println("APLICANDO DESCONTO DE 20%");
        for (Produto p : lista) {
            if (p instanceof Promocional) {
                System.out.println("O produto " + p.getNome() + " teve o preço reduzido.");
                Promocional itemComPromo = (Promocional) p;
                itemComPromo.aplicarCupom(20);    
            } else {
                System.out.println("O produto " + p.getNome() + " não é promocional.");
            }
        }
    }
}
