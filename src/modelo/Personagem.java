package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Personagem implements Serializable{
    
    private Integer codigo;
    private int levelPersonagem;
    private int levelProfissao;
    private String dias;
    private String horario;
    private String nomePersonagem;
    private String nomeJogador;
    private String classe;
    private String raca;
    private String especialidade;
    private String profissao;

    public Personagem() {
    }

    public int getLevelPersonagem() {
        return levelPersonagem;
    }

    public void setLevelPersonagem(int levelPersonagem) {
        this.levelPersonagem = levelPersonagem;
    }

    public int getLevelProfissao() {
        return levelProfissao;
    }

    public void setLevelProfissao(int levelProfissao) {
        this.levelProfissao = levelProfissao;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigo);
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
        final Personagem other = (Personagem) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return nomePersonagem;
    }        

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    
}
