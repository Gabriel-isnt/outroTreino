import java.util.Scanner;


public class principal{
        public static void main(String[] args){

                Scanner sc = new Scanner(System.in);

                System.out.print("Me fale seu nome: ");
                String nome = sc.next();

                Personagem jogador = new Personagem(nome, 100, 0);
                Personagem inimigo = new Personagem("boboca", 30, 0);

                for(int a = 0; a < 20; a++){
                        jogador.getInventario()[a] = "vazio";
                } 


                // testando funcionalidades, não leve em consideração essa parte
                jogador.coletarItem("espada");
                inimigo.coletarItem("arco e flecha");                

                jogador.recuperaVida(10);
                System.out.printf("escudo jogador: %d %n", jogador.getEscudo());
                jogador.tomaDano(7);
                System.out.printf("vida jogador: %d %n", jogador.getVida());   
                System.out.printf("escudo jogador: %d", jogador.getEscudo());             

                sc.close();
        }
}


class Personagem{

        private String nome;
        private int vida;
        private int escudo;
        private boolean estaVivo;
        private String[] inventario;

        public Personagem(String nome, int vida, int escudo){
                this.nome = nome;
                this.vida = vida;
                this.escudo = escudo;
                this.estaVivo = true;
                this.inventario = new String[20];
        }


        public String getNome(){
                return nome;
        }


        public int getVida(){
                return vida;
        }


        public int getEscudo(){
                return escudo;
        }


        public String[] getInventario(){
                return inventario;
        }


        public void recuperaVida(int pocao){

                if(pocao + this.vida > 100){
                        this.escudo += (this.vida + pocao) * 0.03f;
                        this.vida = 100;

                } else {
                        this.vida += pocao;
                }               

        }


        public void recuperaEscudo(int pocao){

                if(pocao + this.escudo > 50){
                        this.escudo = 50;
                
                } else {
                        this.escudo += pocao;
                }
        }


        public void tomaDano(int dano){

                if(!(this.escudo >= 1)){  
                        this.vida -= dano;
                
                } else { 
                        if(dano > this.escudo){
                                this.vida -= (dano - this.escudo);
                                this.escudo = 0;

                        } else {
                                this.escudo -= dano;
                        }
                }


                if(this.vida <= 0){
                        this.estaVivo = false;
                }
        }


        public void bater(int dano, Personagem alvo){
                alvo.tomaDano(dano); 
        }


        public void coletarItem(String item){

                for(int i = 0; i < 20; i++){
                        
                        if(this.inventario[i] != "vazio"){
                                this.inventario[i] = item;
                                return;
                        }
                }       

                System.out.println("inventário cheio");
        }



}



