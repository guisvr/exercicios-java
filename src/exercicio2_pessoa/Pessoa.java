package exercicio2_pessoa;

public class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome,int idade){
        this.nome=nome;
        if(idade < 0){
            this.idade=0;
        }else if(idade > 130){
            System.out.println("Idade Inválida");
            this.idade=0;
        }else{
            this.idade=idade;
     }
    }

    public void mostrarPessoa(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}
