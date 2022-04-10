package es.upm.dit.isst.tfgapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Resumen {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    
    private String autor;
    private String acceso; //enum
    private boolean publicado; //boolean
    private int likes; //@Formula

    
    @Lob
    private char[] descripcion;
    
    @Lob
    private byte[] imagen;

    @Lob
    private byte[] documento; //STRING PARA PRUEBAS
    @Lob
    private byte[] audio;

    public Resumen(){

    }
    
    public Resumen(Long id, String titulo, char[] descripcion, byte[] imagen, String autor, String acceso,
        boolean publicado, int likes, byte[] documento, byte[] audio) {
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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public char[] getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(char[] descripcion) {
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
    public boolean getPublicado() {
        return publicado;
    }
    public void setPublicado(boolean publicado) {
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
