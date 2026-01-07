package exercicio4_rpg;

public class Principal {
    public static void main(String[] args) {
        
        Personagem personagem1 = new Personagem("Guerreiro", 50, 60);
        Personagem personagem2 = new Personagem("Mago", 80, 40);

        while (personagem1.esta_vivo() && personagem2.esta_vivo()){
            personagem1.atacar(personagem2);
            System.out.println("Guerreiro atacou Mago! Vida do Mago: " + personagem2.getVida());
            if (personagem2.esta_vivo()){
                personagem2.atacar(personagem1);
                System.out.println("Mago atacou Guerreiro! Vida do Guerreiro: " + personagem1.getVida());
            }
        }
        if (personagem1.getVida() > personagem2.getVida()){
            System.out.println("Guerreiro é o vencedor!");
        }else{
            System.out.println("Mago é o vencedor!");
            }

            
        
    }
    
}
