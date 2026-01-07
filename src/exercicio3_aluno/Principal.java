package exercicio3_aluno;

public class Principal {

    public static void main(String[] args) {
        
        Aluno aluno1 = new Aluno("Rafael", 10, 8);
        aluno1.calcularMedia();
        System.out.println(aluno1.calcularMedia());
        aluno1.verificarSituacao();

        System.out.println();

        Aluno aluno2 = new Aluno("Guilherme", 4, 8);
        aluno2.calcularMedia();
        System.out.println(aluno2.calcularMedia());
        aluno2.verificarSituacao();
    }
    
}
