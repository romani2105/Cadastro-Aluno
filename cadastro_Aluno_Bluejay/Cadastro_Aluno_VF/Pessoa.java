
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Representa um,a pessoa.
 * 
 *  Gabriel Carlos Silva RA 00325868
 *  Gustavo Bertolini Carvalho de Castro RA 00325934
 *  Rafael Santos Sakatauskas RA 00325920
 *  Murilo Bonventi Romani Pinto RA 00321715
 * 
 */
public class Pessoa {
    // variaveis de instancia 
    private int idade;
    private NomePessoa nome;
    
    /**
     * Pessoa chamado para instanciar uma pessoa
     *
     * @param nome String, nome da pessoa
     * @param idade int, idade da pessoa
     */
    public Pessoa() {
    }
    
    public Pessoa(String nome, int idade) {
        setNome(new NomePessoa(nome)); 
        setIdade(idade);
    }

    /**
     * 
     *
     * @param nome NomePessoa, objeto da classe NomePessoa
     */
    private void setNome(NomePessoa nome){
        this.nome = nome;
    }

    /**
     * 
     *
     * @param idade int, idade da pessoa
     */
    private void setIdade(int idade){
        this.idade = idade;
    }

    /**
     * 
     *
     * @return nome da pessoa, Objeto da classe NomePessoa
     */
    private NomePessoa getNome(){
        return this.nome;
    }
    
    /**
     *
     * @return int, idade da pessoas
     */
    private int getIdade(){
        return this.idade;
    }
    
    /**
     *
     * @return String, dados da pessoa
     */
    public String toString(){
        return ("Nome: " + getNome() + "\nIdade: " + getIdade());
    }   
}
