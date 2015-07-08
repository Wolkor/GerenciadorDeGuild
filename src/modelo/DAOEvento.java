
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Wolkor
 */
public class DAOEvento implements Serializable{
    
    private ArrayList<Personagem> grupoGerado;
    private boolean gerado;

    public DAOEvento() {
    }
     
    
    public List<Evento> getLista(){
        return Dados.listaEventos;
    }
    
    public boolean salvar(Evento evento){
        if(evento.getCodigo() == null){
            Integer codigo = Dados.listaPersonagens.size() + 1;
            evento.setCodigo(codigo);
            Dados.listaEventos.add(evento);
        }
        return true;
    }
    
    public boolean remover(Evento evento){
        Dados.listaEventos.remove(evento);
        return true;
    }
    
        
    public ArrayList<Personagem> geraGrupo(int total, int qntTanker, int qntHealer, int qntMdps,int qntRdps, String dia, String hora){  
        int soma = qntTanker + qntHealer + qntMdps + qntRdps;
        ArrayList<Integer> indTanker;
        ArrayList<Integer> indHealer;
        ArrayList<Integer> indRdps;
        ArrayList<Integer> indMdps;
        
        if(total == soma){
            indTanker = new ArrayList<>();
            indHealer = new ArrayList<>();
            indRdps = new ArrayList<>();
            indMdps = new ArrayList<>();
            
            for(int i = 0; i < Dados.listaPersonagens.size(); i++){
                Personagem p = (Personagem) Dados.listaPersonagens.get(i);
                if(p.getEspecialidade().equals("tanker") && p.getHorario().equals(hora) && p.getDias().equals(dia)){
                    indTanker.add(i);
                }else if(p.getEspecialidade().equals("healer")&& p.getHorario().equals(hora) && p.getDias().equals(dia)){
                    indHealer.add(i);
                }else if(p.getEspecialidade().equals("rdps")&& p.getHorario().equals(hora) && p.getDias().equals(dia)){
                    indRdps.add(i);
                }else if(p.getEspecialidade().equals("mdps")&& p.getHorario().equals(hora) && p.getDias().equals(dia)){
                    indMdps.add(i);
                }      
            }
            
            if(indTanker.size() >= qntTanker && indHealer.size() >= qntHealer && indRdps.size() >= qntRdps && indMdps.size() >= qntMdps){
                this.grupoGerado = new ArrayList<>();
                
                for(int i = 0; i < qntTanker; i++){
                    int id = (int) indTanker.get(i);
                    Personagem p = (Personagem) Dados.listaPersonagens.get(id);
                    grupoGerado.add(p);
                }
                for(int i = 0; i < qntHealer; i++){
                    int id = (int) indHealer.get(i);
                    Personagem p = (Personagem) Dados.listaPersonagens.get(id);
                    grupoGerado.add(p);
                }
                for(int i = 0; i < qntRdps; i++){
                    int id = (int) indRdps.get(i);
                    Personagem p = (Personagem) Dados.listaPersonagens.get(id);
                    grupoGerado.add(p);
                }
                for(int i = 0; i < qntMdps; i++){
                    int id = (int) indMdps.get(i);
                    Personagem p = (Personagem) Dados.listaPersonagens.get(id);
                    grupoGerado.add(p);
                }
                
                JOptionPane.showMessageDialog(null, "Grupo gerado! \nCrie um nome e salve o evento.");
                this.gerado = true;
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível gerar um grupo nessas configurações!");
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Cofiguração no gerador inválida!");
        }
        return grupoGerado;
    }   
}
