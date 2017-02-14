package app.controlcliente.cliente;

/**
 * Created by jorge on 28/01/2017.
 */
public class Clientes {

    private int _id;
    private String _nombre;
    private String _apellido;
    private int _edad;
    private String _telefono;
    private String _email;
    //private String _categoria;

    public Clientes(){
        //Constructor Vacio
    }
    public Clientes(String nombre, String apellido, int edad, String telefono, String email) {
        this._nombre = nombre;
        this._apellido = apellido;
        this._edad = edad;
        this._telefono = telefono;
        this._email = email;
        //this._categoria = categoria;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public int get_edad() {
        return _edad;
    }

    public void set_edad(int _edad) {
        this._edad = _edad;
    }

    public String get_telefono() {
        return _telefono;
    }

    public void set_telefono(String _telefono) {
        this._telefono = _telefono;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    /*public String get_categoria() {  return _categoria;  }

    public void set_categoria(String _categoria) {
        this._categoria = _categoria;
    }*/
}
