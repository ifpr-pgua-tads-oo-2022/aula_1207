package ifpr.pgua.eic.tads.modelos;

public class PessoaFisica extends Pessoa {
    
    private String cpf;
    private int idade;
    private double salario;
    
    
    
    
    public PessoaFisica(String nome, String cpf, int idade, double salario) {
        super(nome);
        this.cpf = cpf;
        this.idade = idade;
        this.salario = salario;
    }


    public void setSalario(double salario) {
        this.salario = salario;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }


    public String getCpf() {
        return cpf;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public double getSalario() {
        return salario;
    }

    @Override
    public String getDocumento(){
        return this.cpf;
    }
    
    


}
