package ifpr.pgua.eic.tads.modelos;

public class Pessoa {

    private String nome;
    //private Conta conta;


    public Pessoa(String nome) {
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento(){
        return "";
    }
    
    
    public String toString(){
        String str="";

        str = "Pessoa[nome:"+nome+"]";
        
        return str;
    }
    
}
