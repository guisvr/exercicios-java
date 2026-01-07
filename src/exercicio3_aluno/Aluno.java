package exercicio3_aluno;

public class Aluno {

    private String nome;
    private double nota1;
    private double nota2;

    public Aluno(String nome, double nota1, double nota2){
        this.nome=nome;

        if(nota1 > 10 || nota1 < 0){
            this.nota1 = 0;
        }else{
            this.nota1=nota1;
        }
        if(nota2 > 10 || nota2 < 0){
            this.nota2 = 0;
        }else{
            this.nota2 = nota2;
        }
    }   
        public double calcularMedia(){
            double media = (nota1 + nota2) / 2;
            return media;}

        public void verificarSituacao(){
            double media = calcularMedia();

            if(media >= 7){
                System.out.println("Aprovado!");
            }else if(media >=5){
                System.out.println("Recuperação!");
            }else
                System.out.println("Reprovado!");
            }
        }