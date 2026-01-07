package exercicio6_controleCombustivel;

public class Principal {
    public static void main(String[] args) {
        
        Carro carro1 = new Carro("Kia Soul", 54, 13);

        carro1.abastecer(55);
        carro1.viajar(100);
        carro1.verAutonomia();
    }
    
}
