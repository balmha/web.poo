package ar.edu.unnoba.poo2018.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Actividad")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Long id;

    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    private String resolucion;
    private String expediente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Convocatoria convocatoria;
    @ManyToOne(fetch = FetchType.LAZY)
    private LineaEstrategica linea;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ambito ambito;

    @JoinTable(name = "Responsables",
            joinColumns = @JoinColumn(name = "actividad_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    @ManyToMany
    private List<Usuario> responsables;
    
    @ManyToMany(mappedBy="actividades")
    private List<Compuesto> compuestas;

    public Actividad() {
    }

    public Actividad(String nombre, Date fechaInicio, Date fechaFin, String resolucion, String expediente, Ambito ambito, Convocatoria convocatoria, LineaEstrategica lineaEstrategica, List<Usuario> responsables) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.resolucion = resolucion;
        this.expediente = expediente;
        this.ambito = ambito;
        this.convocatoria = convocatoria;
        this.linea = lineaEstrategica;
        this.responsables = responsables;
    }
    
    @Version
    protected int version;

    public long getNro() {
        return id;
    }

    public void setNro(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public LineaEstrategica getLinea() {
        return linea;
    }

    public void setLinea(LineaEstrategica linea) {
        this.linea = linea;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
    }

    public void addUsuario(Usuario u) {
        responsables.add(u);
    }

    public void removeUsuario(Usuario u) {
        responsables.remove(u);
    }

    @Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getNro());
	}
	
    @Override
    public int hashCode() {
        return (getNombre() != null) 
            ? (getClass().getSimpleName().hashCode() + getNombre().hashCode())
            : super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return (other != null && getNombre() != null
                && other.getClass().isAssignableFrom(getClass()) 
                && getClass().isAssignableFrom(other.getClass())) 
            ? getNombre().equals(((Actividad) other).getNombre())
            : (other == this);
    }

}
