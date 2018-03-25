
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
        
        

        if (pilha.fimCartas()) {
            System.out.println("A pilha está vazia");
    }
        
        
        
        
    }

    private static void criaBaralho(Pilha pilha) {
        boolean completo =true;
        int totalCartas=0;
        String naipe="Copas";
        String numero="A";
        int valor=1;
        
        
        while(completo==true){
            if(valor>10){
            valor=11;
            }
            
            
            
            Carta CartaAdd = new Carta(naipe,numero,valor);
            pilha.add(CartaAdd);
            
            valor++;
            totalCartas++;
                if(totalCartas==54){
                    completo=false;
                }
                
                
                
                
        }
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
    
    }

    
}
