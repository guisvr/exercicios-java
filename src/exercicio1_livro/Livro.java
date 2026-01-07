package exercicio1_livro;
public class Livro{
    //atributos
    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco){
        this.titulo=titulo;
        this.autor=autor;
        this.preco=preco;
    }
    void mostrarLivro(){

        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Preço: " + preco);
    }
}