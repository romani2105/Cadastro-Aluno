import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Escreva uma descrição da classe Aluno aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Aluno extends Pessoa {
    // Atributos
	String nome;
    String ra;
    String curso;
    int idade;
    float nota;
    Disciplina disc;
    public ArrayList<Disciplina> notaDisc = new ArrayList<Disciplina>(); 
    
    

    Aluno(String nome, int idade, float nota, String ra, String curso, Disciplina disc){
    	this.nome = nome;
        this.idade = idade;
        this.ra = ra;
        this.curso = curso;
        this.disc = disc;
        this.nota = nota;
   //    Aluno aluno = new Aluno("João", 18, "12345", 3, new Disciplina[4]); forma de inicializar
    }
    
         
    public String getNome(){
        return nome;
    }
        
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public String getRa(){
        return ra;
    }
    
    public void setRa(String ra){
        this.ra = ra;
    }
    
    public String getCurso(){
        return curso;
    }
    
    public void setCurso(String curso){
        this.curso = curso;
    }
    public float getNota() {
    	return nota;
    }
    public void setNota(float nota) {
    	this.nota = nota;
    }

    
    void cadastrarDisc(Disciplina disciplina) {
        notaDisc.add(disciplina); //adiciona uma nota na lista de um aluno
    }
    
    void apresentaçãoAluno(){
        System.out.println("Nome: "+this.getNome()+" Idade: "+this.getIdade()+" RA: "+this.getRa()+" Curso: "+this.getCurso()+" Disciplina: "+this.disc.getnomeDisc()
        		+ " Nota da disciplina : "+this.getNota());
      }
    


}
