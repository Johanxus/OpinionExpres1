package LogicaOpinionExpress;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//Codigo para mapear cada uno de los atributos y que se puedan usar en el resto de codigo
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="nombres")
    private String nombres;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="celular")
    private String Celular;
    @Column(name="correo")
    private String correo;
    @Column(name="contraseña")
    private String clave;
//Se aplica un getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
//Se crea constructores 
    public Usuario(String nombres, String apellidos, String Celular, String Correo, String clave) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Celular = Celular;
        this.correo = Correo;
        this.clave = clave;
    }

    public Usuario(String Correo, String clave) {
        this.correo = Correo;
        this.clave = clave;
    }

    public Usuario() {
    }

    
    
    

   
}
