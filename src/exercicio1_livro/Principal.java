package exercicio1_livro;
public class Principal {

    public static void main(String[] args) {
         Livro livro1 = new Livro("Entenda Algoritmos","Aditya Y. Bhargava",60.00);
         livro1.mostrarLivro();

         System.out.println();

         Livro livro2 = new Livro("Labubu","Rafael",100.00);
         livro2.mostrarLivro();
    }
}
