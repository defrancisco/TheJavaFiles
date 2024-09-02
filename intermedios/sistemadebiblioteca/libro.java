package intermedios.sistemadebiblioteca;

public class libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private int año;

    public libro(  String titulo, String autor, String ISBN,int año){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.año = año;
    }
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + ISBN + ", Año: " + año;
    }


}
