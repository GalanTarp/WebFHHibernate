package pojos;
// Generated 20-ene-2020 9:14:10 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private short id;
     private Categoria categoria;
     private String titulo;
     private String body;
     private String imagen;
     private String fondo;
     private String sumario;
     private Set puntos = new HashSet(0);

    public Producto() {
    }

	
    public Producto(short id) {
        this.id = id;
    }
    public Producto(short id, Categoria categoria, String titulo, String body, String imagen, String fondo, String sumario, Set puntos) {
       this.id = id;
       this.categoria = categoria;
       this.titulo = titulo;
       this.body = body;
       this.imagen = imagen;
       this.fondo = fondo;
       this.sumario = sumario;
       this.puntos = puntos;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getBody() {
        return this.body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getFondo() {
        return this.fondo;
    }
    
    public void setFondo(String fondo) {
        this.fondo = fondo;
    }
    public String getSumario() {
        return this.sumario;
    }
    
    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
    public Set getPuntos() {
        return this.puntos;
    }
    
    public void setPuntos(Set puntos) {
        this.puntos = puntos;
    }




}


