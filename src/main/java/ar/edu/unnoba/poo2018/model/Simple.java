package ar.edu.unnoba.poo2018.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Actividades_Simples")
@NamedQueries({
    @NamedQuery(name = "simple.getAllActividadSimple",
            query = "Select a From Simple a")
})
public class Simple extends Actividad implements Serializable {
    
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="actividad_id")
        private List<Impacto> impactos;
        
        public Simple(){};
        
        public Simple(String nombre,Date fI,Date fF, String res,String exp,Convocatoria conv,
                LineaEstrategica lin,Ambito amb,List<Usuario> resp,List<Impacto> imp){
            super(nombre, fI, fF, res, exp, amb, conv, lin, resp);
            this.impactos=imp;
        }

        public List<Impacto> getImpactos() {
            return impactos;
        }

        public void setImpactos(List<Impacto> impactos) {
            this.impactos = impactos;
        }

}
