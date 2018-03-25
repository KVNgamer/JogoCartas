
package jogocartas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JogoCartas {

      
    
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
       

        criaBaralho(pilha);
       
       
        
        System.out.println("numero de cartas"+pilha.baralho.size());
        System.out.println(pilha.mostraTopo());
        pilha.mostraTudo();
        
        

        if (pilha.fimCartas()) {
            System.out.println("A pilha está vazia");
    }
        
        
        
        
    }

    private static void criaBaralho(Pilha pilha) {
        boolean completo =true;
        int totalCartas=0;
        String naipe="Copas♥";
        String numero="A";
        int valor=1;
        
        
        while(completo==true){
            Carta CartaAdd = new Carta(naipe,numero,valor);
            pilha.add(CartaAdd);
            valor++;
            totalCartas++;
            naipe=trocaNaipe(naipe,totalCartas);
            valor=trocaValor(CartaAdd,naipe,valor);
            numero=trocaCarta(numero,valor);
            if(totalCartas==52){
                completo=false;
            }                
        }
    }

    private static String trocaNaipe(String naipe,int totalCartas) {
            
            if(totalCartas==13){
                return naipe="ouros♦";
               
            }
            if(totalCartas==26){
                return naipe="paus♣";
                
            }
            if(totalCartas==39){
                return naipe="espadas♠";
              
            }
           return naipe;
    }

    private static String trocaCarta(String numero,int valor) {
        
        if(valor==1){
          return numero="A";
        }
         if(valor==11){
          return numero="J";
         }
          if(valor==12){
          return numero="Q";
          }
          if(valor==13){
          return numero="K";
          }
        
        return   numero= valor+" ";
    }

    private static int trocaValor(Carta CartaAdd, String naipe, int valor) {
        if(CartaAdd.getNaipe()!=naipe){
                return valor=1;
                    }
        return valor;
    }
    
    
    
    
    
    
    
    
     /*public static Pilha<Carta> loadFromFile(FileReader arquivo){
		 
	  BufferedReader ler = new BufferedReader(arquivo);
		
		Pilha<Carta> infoCarta = new Pilha<Carta>();
		
		try {
			
			String linha = ler.readLine();
			
			while(linha != null) {
				//separa os campos entre as virgulas de cada linha
				String[] atributos = linha.split(",");
				
                                
                                Carta Carta = new Carta(atributos[0],atributos[1],Integer.valueOf(atributos[2]));
                                
				/*Carta Carta = new Carta();
                                
				Carta.setNaipe(atributos[0]);
				Carta.setNumero(atributos[1]);
                                //coloca a String em int.
				Carta.setValor(Integer.valueOf(atributos[2]));				
			
				infoCarta.append((Carta) Carta);
				linha = ler.readLine();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return infoCarta;
}*/

    private static class Pilha {

        public List<Carta> baralho = new LinkedList<Carta>();
        
        
        
        public Pilha() {           
        }                         
        
        public void add(Carta carta) {
             this.baralho.add(carta);       
           
        }
        
        public Carta remove(){
             return this.baralho.remove(this.baralho.size() - 1);
        }
        
        public boolean fimCartas(){
            return this.baralho.size() == 0;
        }
        
        public Carta mostraTopo(){
            
            
            return this.baralho.get(this.baralho.size()-1);
        }
        public void mostraTudo(){
            for (Carta x : baralho) {
                System.out.println(x);
            }
        }
    
    }

    
}
