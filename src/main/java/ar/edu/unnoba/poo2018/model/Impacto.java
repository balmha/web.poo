package ar.edu.unnoba.poo2018.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Impacto")
public class Impacto implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Long nro;

    private int peso;

    @Version
    protected int version;
    
    @ManyToOne
    @JoinColumn(name = "actividad_id")
    private Simple actividadSimple;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objetivo_id")
    private Objetivo objetivo;
    
    public Impacto() {
    }

    public Impacto(int peso, Objetivo objetivo) {
        this.peso = peso;
        this.objetivo = objetivo;
    }

    public long getNro() {
        return nro;
    }

    public void setNro(long nro) {
        this.nro = nro;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
    
    @Override
    public String toString() {
        return "Impacto [nro=" + nro + ", peso=" + peso + ", objetivo=" + objetivo + "]";
    }

}
