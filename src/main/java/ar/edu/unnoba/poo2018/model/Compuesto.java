package ar.edu.unnoba.poo2018.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Actividades_Compuestas")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Compuesto extends Actividad implements Serializable{

    @JoinTable(name = "Actividades_Relacionadas",
            joinColumns = @JoinColumn(name = "actividad_compuesta_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id")
    )
    @ManyToMany
    private List<Actividad> actividades;

    public Compuesto(){};
        
    public Compuesto(String nombre,Date fI,Date fF, String res,String exp,Convocatoria conv, 
            LineaEstrategica lin,Ambito amb,ArrayList<Usuario> resp){
        super(nombre, fI, fF, res, exp, amb, conv, lin, resp);
    }
    
    @Override
    public String toString() {
        return "Compuesto: " + getNombre() + " [actividades=" + actividades + "]";
    }

}
