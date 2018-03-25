
package jogocartas;

public class Carta {
   
   String naipe,numero;
   int valor;
   
   
    public Carta(String naipe,String numero,int valor){

        this.naipe=naipe;
        this.numero=numero;
        this.valor=valor;
        
    }

    Carta() {
    }

    void setNaipe(String naipe) {
        this.naipe=naipe;
    }

    void setNumero(String numero) {
      this.numero=numero;
    }

    void setValor(Integer valor) {
        this.valor=valor;
    }
    
    String getNumero(){
        return this.numero;
    }
    
    
    @Override
    public String toString(){
       
        System.out.print(String.format("%-10s","|naipe"));
        System.out.print(String.format("%-20s","|numero"));
        System.out.println(String.format("%-10s","|valor"));          
        System.out.print(String.format("%-10s",this.naipe));
        System.out.print(String.format("%-20s",this.numero));
        System.out.println(String.format("%-10s",this.valor));

		return " " ;
    }
}
