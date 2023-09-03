import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.*;

/** Gabriel Carlos Silva RA 00325868
 *  Gustavo Bertolini Carvalho de Castro RA 00325934 
 *  Rafael Santos Sakatauskas RA 00325920
 *  Murilo Bonventi Romani Pinto RA 00321715
 * 
 * 
 * @version (um número da versão ou uma data)
 */
public class CadastroAluno{


	    // variaveis de instância
	    private Aluno[] cad;
	    int contador;
        int escolha;
       public CadastroAluno listaAlunos;
	    /**
	     * Construtor para objetos da classe CadastroAlunos
	     */
	    public CadastroAluno(int qtde) {
	        cad = new Aluno[qtde];
	    	contador = 0;
	    	listaAlunos = this;

	    	String[] opcoes = {"Inserir aluno", "Remover aluno", "Listar alunos", "Sair"};
	    	int escolha;

	    	do {
	    	    escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções", 
	    	                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
	    	    
	    	    switch(escolha) {
	    	        case 0:
	    	        	
	    	            inserirAluno();
	    	            break;
	    	        case 1:
	    	        	if (contador == 0) {
	    	        		JOptionPane.showMessageDialog(null, "não há nenhum aluno na lista para ser removido");
	    	        		break;
	                    }
	    	        	removerAluno();
	    	        	
	    	        case 2:
	    	        	if (contador == 0) {
	                        System.out.println("Nenhum aluno na lista \n\n");
	                        continue;
	                    }
	                    
	                    listaAlunos.listarAlunos();
	                    System.out.println(" ");
	                    break;
	    	        case -1:
	    	        	JOptionPane.showMessageDialog(null, "para sair do programa clique em sair");
	    	        
	    	           
	    	    }
	    	} while (escolha != 3);
}

	    
	    private int lerqtdAluno() {
	        int qtdaluno = 0;
	        try {
	            String input = JOptionPane.showInputDialog("Forneca quantos alunos deseja inserir (limite de 60): ");
	            if (input == null) {
	                if (exit(0)) { // verifica se o usuário realmente quer sair do programa
	                    System.exit(0);
	                } else {
	                    return lerqtdAluno(); // chama o método novamente para solicitar a idade
	                }
	            }
	            
	            qtdaluno = Integer.parseInt(input);
	            if(qtdaluno <1 || qtdaluno >60) {
	            	JOptionPane.showMessageDialog(null, "Digite um número entre 1 a 60 .");
	                qtdaluno = lerqtdAluno();
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Digite o número desejado  em números.");
	            qtdaluno = lerqtdAluno();
	        }
	        return qtdaluno;
	    }
	    
	    public String lerNome(){ 
	    	String nome = null;
	        try {
	            nome = JOptionPane.showInputDialog("Forneca nome");
	            if (nome == null) { // Verifica se o usuário clicou em "Cancelar" ou no "X"
	            	if (exit(0)) { // verifica se o usuário realmente quer sair do programa
	                    System.exit(0);
	                } else {
	                    return lerNome(); // chama o método novamente para solicitar a idade
	                }
	            }
	            if (!nome.matches("[a-zA-ZáéíóúÁÉÍÓÚçÇãõÃÕâêîôûÂÊÎÔÛàèìòùÀÈÌÒÙüÜ ]+")) {//// verifica se tem apenas letras com acento
	                throw new Exception("O nome deve conter apenas letras.");
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e.getMessage());
	            nome = lerNome(); // Chama novamente o método para solicitar um novo nome
	        }
	        return nome;
	    }

	    private int lerIdade() {
	        int idade = 0;
	        try {
	            String input = JOptionPane.showInputDialog("Forneca idade: ");
	            if (input == null) {
	                if (exit(0)) { // verifica se o usuário realmente quer sair do programa
	                    System.exit(0);
	                } else {
	                    return lerIdade(); // chama o método novamente para solicitar a idade
	                }
	            }
	            idade = Integer.parseInt(input);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Digite a idade em números.");
	            idade = lerIdade();
	        }
	        return idade;
	    }
	        

	        public String lerRa() {
	            String ra = null;
	            try {
	                ra = JOptionPane.showInputDialog("Forneca RA");
	                if (ra == null) { // Verifica se o usuário clicou em "Cancelar" ou no "X"
	                    if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair do programa?") == JOptionPane.YES_OPTION) { // verifica se o usuário realmente quer sair do programa
	                        System.exit(0);
	                    } else {
	                        return lerRa(); // chama o método novamente para solicitar o RA
	                    }
	                }
	                if (!ra.matches("[0-9]+")) { // verifica se tem apenas números
	                    throw new Exception("O RA deve conter apenas números e 8 digitos.");
	                }
	            } catch (Exception e) {
	            	while (ra.length() != 8) {
	                JOptionPane.showMessageDialog(null, e.getMessage());
	            	
	                ra = lerRa(); // Chama novamente o método para solicitar um novo RA
	            	}
	            }
	            return ra;
	        }

	        public String lerCurso(){ 
	        	String curso = null;
		        try {
		            curso = JOptionPane.showInputDialog("Forneca curso");
		            if (curso == null) { // Verifica se o usuário clicou em "Cancelar" ou no "X"
		            	if (exit(0)) { // verifica se o usuário realmente quer sair do programa
		                    System.exit(0);
		                } else {
		                    return lerNome(); 
		                }
		            }
		            if (!curso.matches("[a-zA-ZáéíóúÁÉÍÓÚçÇãõÃÕâêîôûÂÊÎÔÛàèìòùÀÈÌÒÙüÜ ]+")) {// verifica se tem apenas letras com acento
		                throw new Exception("O curso deve conter apenas letras.");
		            }
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, e.getMessage());
		            curso = lerCurso(); 
		        }
		        return curso;
	        }
	        
	        
	        public Disciplina lerDisciplina(){ 
	        	float nota = 0;
	        	String disciplina = null;
		        try {
		            disciplina = JOptionPane.showInputDialog("Forneca disciplina");
		            if (disciplina == null) { // Verifica se o usuário clicou em "Cancelar" ou no "X"
		            	if (exit(0)) { // verifica se o usuário realmente quer sair do programa
		                    System.exit(0);
		                } else {
		                    return lerDisciplina(); 
		                }
		            }
		            if (!disciplina.matches("[a-zA-ZáéíóúÁÉÍÓÚçÇãõÃÕâêîôûÂÊÎÔÛàèìòùÀÈÌÒÙüÜ ]+")) {// verifica se tem apenas letras
		                throw new Exception("A disciplina deve conter apenas letras.");
		            }
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, e.getMessage());
		            return lerDisciplina(); 
		        }
		        nota = lerNotaDisciplina();
		        Disciplina disc = new Disciplina(nota,disciplina);
		        return disc;
	        }
	        
	            
	        public float lerNotaDisciplina() {
	            float nota = 0;
	            try {
	                String input = JOptionPane.showInputDialog("Forneca nota da disciplina: ");
	                if (input == null) {
	                    if (exit(0)) {
	                        System.exit(0);
	                    } else {
	                        return lerNotaDisciplina();
	                    }
	                }
	                nota = Float.parseFloat(input);
	                if(nota < 0 || nota > 10) {
	                    JOptionPane.showMessageDialog(null, "Digite uma nota entre 0 e 10.");
	                    nota = lerNotaDisciplina();
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "Digite a nota da disciplina em números.");
	                nota = lerNotaDisciplina();
	            }
	            return nota;
	        } 
	        
            public void inserirAluno() {
                int qtdaluno = lerqtdAluno();              
                do {
                    String nome = lerNome();
                    if (nome == null) {
                        return; // usuário cancelou a operação
                    }
                    int idade = lerIdade();
                    String ra = lerRa();
                    String curso = lerCurso();
                    Disciplina disc = lerDisciplina();
                    float nota = lerNotaDisciplina();
                    if (contador< qtdaluno) { // verifica se ainda pode inserir alunos
                        Aluno novoAluno = new Aluno(nome, idade, nota, ra, curso, disc);
                        cad[contador] = novoAluno;
                        contador++;
                        JOptionPane.showMessageDialog(null, "Aluno inserido com sucesso.");
                    } else {
                    	Aluno novoAluno = new Aluno(nome, idade, nota, ra, curso, disc);
                        cad[contador] = novoAluno;
                        contador++;
                        JOptionPane.showMessageDialog(null, "Aluno inserido com sucesso.");
                    }
                } while (contador < qtdaluno); // executa enquanto não atingir o número desejado de alunos
            }



	        private boolean exit(int i) {
	            int result = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do programa?", "Sair", JOptionPane.YES_NO_OPTION);
	            return result == JOptionPane.YES_OPTION;
	        }

	        void listarAlunos(){
	        	try {
		            System.out.println("\n Lista de Alunos \n");
		            for (Aluno i:cad){
		                i.apresentaçãoAluno();
		                System.out.println(" ");
		               }
		        	}
		        	catch(NullPointerException e) {
		        		JOptionPane.showMessageDialog(null, "lista atuzalizada");
		            }
		        	System.out.println(" ");
		        }
	        
	        

	        private void removerAluno() {
	            String ra = JOptionPane.showInputDialog("Forneca o RA do aluno a ser removido:");

	            for (int i = 0; i < contador; i++) {
	                if (cad[i].getRa().equals(ra)) {
	                    // Encontrou o aluno com o RA fornecido, remova-o da lista
	                    System.out.println("Removendo aluno: " + cad[i].getNome());
	                    for (int j = i; j < contador - 1; j++) {
	                        cad[j] = cad[j+1];
	                    }
	                    contador--;
	                    return;
	                }
	            }

	            // Não encontrou nenhum aluno com o RA fornecido
	            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum aluno com o RA fornecido.");
	        }




	    }





