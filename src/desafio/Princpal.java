package desafio;
import java.util.ArrayList;

public class Princpal {
    public static void main(String[] args) {

        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        
        Produto p1 = new Produto("Cadeira", 450, 30);
        Produto p2 = new Produto("Tapete", 200, 10);
        Produto p3 = new Produto("Mesa", 1000, 15);
        Produto p4 = new Produto("Sofá", 5, 2000);
        Produto p5 = new Produto("Cortina", 13, 150);

        listaDeProdutos.add(p1);
        listaDeProdutos.add(p2);
        listaDeProdutos.add(p3);
        listaDeProdutos.add(p4);
        listaDeProdutos.add(p5);

        System.out.println("RELÁTÓRIO DE ESTOQUE");

        double somaTotal = 0;

        for (Produto p : listaDeProdutos){
            p.exibirInformações();

        somaTotal += (p.getPreco() * p.getQuantidadeEstoque());
    }

    System.out.println("A soma total de todos os itens é estoque é de R$" + somaTotal);

    System.out.println("--------------\\----------------------\\----------------");

    double novaSoma = 0;
    
    for (Produto p : listaDeProdutos){
        p.reajustarPreco(-20);
        p.exibirInformações();
        novaSoma += (p.getPreco() * p.getQuantidadeEstoque());
        }
    
        System.out.println("Novo valor total do estoque após o desconto: R$" + novaSoma);
    }   
}
