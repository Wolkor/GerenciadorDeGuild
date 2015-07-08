
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wolkor
 */
public class DAOPersonagem implements Serializable {
    
    
    public List<Personagem> getLista(){
        return Dados.listaPersonagens;
    }
    
    public boolean salvar(Personagem personagem){
        if(personagem.getCodigo() == null){
            Integer codigo = Dados.listaPersonagens.size() + 1;
            personagem.setCodigo(codigo);
            Dados.listaPersonagens.add(personagem);
        }
        return true;
    }
    
    public boolean remover(Personagem personagem){
        Dados.listaPersonagens.remove(personagem);
        return true;
    }
    
    public List<Personagem> buscaPersonagens(List<Personagem> personagem){
        List<Personagem> listPersonagens = new ArrayList<>();
        listPersonagens.addAll(Dados.listaPersonagens);
        listPersonagens.retainAll(personagem);
        return listPersonagens;
    }
}
