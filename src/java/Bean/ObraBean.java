package Bean;

public class ObraBean {

    private String id;
    private String nome;
    private String data;
    private String tecnica;
    private String dimensoes;
    private String autor;
    private String procedencia;
    private String tipo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ObraBean() {
    }

    public ObraBean(String id, String nome, String data, String tecnica, String dimensoes, String autor, String procedencia, String tipo) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.tecnica = tecnica;
        this.dimensoes = dimensoes;
        this.autor = autor;
        this.procedencia = procedencia;
        this.tipo = tipo;
    }
         
}
