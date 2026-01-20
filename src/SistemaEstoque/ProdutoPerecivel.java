package SistemaEstoque;

public class ProdutoPerecivel extends Produto implements Promocional {

    private String dataValidade;

    public ProdutoPerecivel(String nome, double preco, int quantidadeEstoque, String dataValidade) {
        super(nome, preco, quantidadeEstoque);
        this.dataValidade = dataValidade;
    }

    @Override
    public void exibirInformações() {
        super.exibirInformações();
        System.out.println("Data de validade: " + dataValidade);
    }

    @Override
    public double calcularImposto() {
        return this.getPreco() * 0.05;
    }

    @Override
    public void aplicarCupom(double porcentagem) {
        this.reajustarPreco(-porcentagem);
        System.out.println("Cupom de " + porcentagem + "% aplicado com sucesso.");
    }

    public String getDataValidade() {
        return this.dataValidade;
    }
}