package ifpr.pgua.eic.tads.modelos;

public class PessoaJuridica extends Pessoa{
    
    private String cnpj;
    private double patrimonio;


    public PessoaJuridica(String nome, String cnpj, double patrimonio) {
        super(nome);
        this.cnpj = cnpj;
        this.patrimonio = patrimonio;
    }


    public double getPatrimonio() {
        return patrimonio;
    }


    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }


    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String getDocumento(){
        return this.cnpj;
    }
    

}
