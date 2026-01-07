package exercicio5_contaBancaria;

public class Principal {
    public static void main(String[] args) {
        
        ContaBancaria conta1 = new ContaBancaria("Guilherme", 1000, 500);
        ContaBancaria conta2 = new ContaBancaria("Rafael", 50000, 20000);

        conta1.depositar(200);
        conta2.sacar(10000);
        conta2.transferir(20000, conta1);
    
    System.out.println("Saldo" + conta1.getTitular() + "R$" + conta1.getSaldo());
    System.out.println("Saldo" + conta2.getTitular() + "R$" + conta2.getSaldo());
    }
}
