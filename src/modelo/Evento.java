
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Wolkor
 */
public class Evento implements Serializable {
    
    private Integer codigo;
    private ArrayList<Personagem> Grupo;
    private String nomeEvento;
    private String dias;
    private String hora;
    private int tamanho;
    private int quantTankers;
    private int quantHealers;
    private int quantMdps;
    private int quantRdps;

    public Evento() {
    }   
    
    public ArrayList<Personagem> getGrupo() {
        return Grupo;
    }

    public void setGrupo(ArrayList<Personagem> Grupo) {
        this.Grupo = Grupo;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }


    public void setQuantTankers(int quantTankers) {
        this.quantTankers = quantTankers;
    }

    public void setQuantHealers(int quantHealers) {
        this.quantHealers = quantHealers;
    }

    public void setQuantMdps(int quantMdps) {
        this.quantMdps = quantMdps;
    }

    public void setQuantRdps(int quantRdps) {
        this.quantRdps = quantRdps;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
   
    @Override
    public String toString(){
        return nomeEvento;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }


}
