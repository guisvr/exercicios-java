package desafio;

public class Produto {

    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque){
        this.nome=nome;
        this.preco=preco;
        this.quantidadeEstoque=quantidadeEstoque;
    }

    public void adicionarEstoque(int quantidade){
        if(quantidade > 0){
        this.quantidadeEstoque += quantidade;
        System.out.println(quantidade + " itens adicionados ao estoque.");
        }else{
            this.quantidadeEstoque = 0;
            System.out.println("Quantidade inválida. Estoque definido como zero.");
        }
    }

    public void vender(int quantidade){
        if(quantidade <= this.quantidadeEstoque){
            this.quantidadeEstoque -= quantidade;
            System.out.println("Venda concluida.");
        }else{
            System.out.println("Estoque indisponível.");
        }
    }

        public void exibirInformações(){
            System.out.println("Produto: " + this.nome);
            System.out.println("Preço: R$ " + this.preco);
            System.out.println("Quantidade em estoque: " + this.quantidadeEstoque);
        }

        public void reajustarPreco(double percentual){
            double novoPreco = this.preco + (this.preco * (percentual/100));
            if(novoPreco >= 0){
                this.preco = novoPreco;
                System.out.println("Novo preço reajustado para R$" + this.preco);
            }else{
                System.out.println("Preço inserido é inválido.");
            }
        }

        public double getPreco(){
            return this.preco;
        }

        public int getQuantidadeEstoque(){
            return this.quantidadeEstoque;
        }
    }


