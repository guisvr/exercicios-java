package exercicio5_contaBancaria;

public class ContaBancaria {

    private String titular;
    private double saldo;
    private double limiteSaque;

    public ContaBancaria(String titular, double saldo, double limiteSaque){
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public boolean sacar(double valor){
        if((valor <= this.saldo) && (valor <= limiteSaque)){
            this.saldo -= valor;
            System.out.println("Saque realizado no valor de R$" + valor);
            return true;
        }
        else{
            if (valor > this.saldo){
                System.out.println("Saldo Insuficiente.");
            }else if(valor > this.limiteSaque){
                System.out.println("Valor excede o limite de saque.");
            }
            return false;
        }
    }
    

    public void depositar(double valor){
        if (valor > 0){
            this.saldo += valor;
        }else{
            System.out.println("Valor inválido.");
        }
    }

    public void transferir(double valor, ContaBancaria destino){
        if (this.sacar(valor)){
            destino.depositar(valor);
            System.out.println("Transferência realizada com sucesso.");
        }else{
            System.out.println("Transferência não autorizada.");
        }
    }
    public double getSaldo(){
        return this.saldo;
    }
    public String getTitular(){
        return this.titular;
    }
    
}
