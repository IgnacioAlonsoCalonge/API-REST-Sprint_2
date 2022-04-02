package es.upm.dit.isst.tfgapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Resumen {
    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private String autor;
    private String acceso; //enum
    private String publicado; //boolean
    private int likes; //@Formula

    @Lob
    private byte[] imagen;

    @Lob
    private byte[] documento; //STRING PARA PRUEBAS
    @Lob
    private byte[] audio;

    public Resumen(){

    }
    
    public Resumen(String id, String titulo, String descripcion, byte[] imagen, String autor, String acceso,
            String publicado, int likes, byte[] documento, byte[] audio) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.autor = autor;
        this.acceso = acceso;
        this.publicado = publicado;
        this.likes = likes;
        this.documento = documento;
        this.audio = audio;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public byte[] getImagen() {
        return imagen;
    }
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAcceso() {
        return acceso;
    }
    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }
    public String getPublicado() {
        return publicado;
    }
    public void setPublicado(String publicado) {
        this.publicado = publicado;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public byte[] getDocumento() {
        return documento;
    }
    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }
    public byte[] getAudio() {
        return audio;
    }
    public void setAudio(byte[] audio) {
        this.audio = audio;
    }
    
}
