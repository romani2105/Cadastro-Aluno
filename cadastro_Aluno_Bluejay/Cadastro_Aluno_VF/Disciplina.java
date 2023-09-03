import java.lang.String;
/**
 * Escreva uma descrição da classe Disciplina aqui.
 * 
 * Gabriel Carlos Silva RA 00325868
 *  Gustavo Bertolini Carvalho de Castro RA 00325934
 *  Rafael Santos Sakatauskas RA 00325920
 *  Murilo Bonventi Romani Pinto RA 00321715 
 * @version (um número da versão ou uma data)
 */
public class Disciplina {
    private double notaDisc;
    private Texto nomeDisc;
    
    /*
     * Construtor para objetos da classe Disciplina
     *
    */    
    
    public Disciplina(double nota,String nomeDisc) {
        setnota(nota);
        setnomeDisc(nomeDisc);  
    }

    void apresentaDisciplina(){
        System.out.println(" Disciplina: "+ this.nomeDisc + " Nota: "+ this.notaDisc);
        }
    
    public double getnota(){
        return notaDisc;
    }
    
    private void setnota(double notaDisc){
        this.notaDisc = notaDisc;
    }

    public String getnomeDisc(){
        return this.nomeDisc.getTxt();
    }
    
    private void setnomeDisc(String nomeDisc){
        this.nomeDisc = new Texto(nomeDisc);
    }



}
