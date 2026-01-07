package exercicio6_controleCombustivel;

public class Carro {
    private String modelo;
    private double capacidadeTanque;
    private double quantidadeCombustivel;
    private double consumoMedio;

    public Carro(String modelo, double capacidadeTanque, double consumoMedio){
        this.modelo = modelo;
        this.capacidadeTanque = capacidadeTanque;
        this.consumoMedio = consumoMedio;
    }
    public boolean abastecer(double litros){
        if((this.quantidadeCombustivel + litros) <= this.capacidadeTanque){
            this.quantidadeCombustivel += litros;
            return true;
        }else{
            this.quantidadeCombustivel = this.capacidadeTanque;
            System.out.println("Tanque cheio. O excesso tansbordou!");
            return false;
        }
    }
    public void viajar(double distancia){
        double litrosNecessarios = distancia/this.consumoMedio;
        if(litrosNecessarios <= this.quantidadeCombustivel){
            this.quantidadeCombustivel -= litrosNecessarios;
            System.out.println("Viagem de " + distancia + "Km realizada.");
        }else{
            System.out.println("Combustivel insuficiente.");
        }
    }
    public void verAutonomia(){
         double autonomia = this.quantidadeCombustivel * this.consumoMedio;
         System.out.println("Você ainda pode percorrer" + autonomia + "Km/h.");
     }
 }

