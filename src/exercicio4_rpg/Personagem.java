package exercicio4_rpg;

public class Personagem {

    private String nome;
    private int vida;
    private int ataque;

    public Personagem(String nome, int vida, int ataque){
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }
    public boolean esta_vivo(){
        return this.vida > 0;
        }

    public void atacar(Personagem oponente){
        oponente.vida = oponente.vida - this.ataque;
    }

    public int getVida(){
        return this.vida;
    }
}
