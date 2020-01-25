package MODEL;

public class Estudiante {

    private String nombre;
    private String dni;
    private String year;
    private String especialidad;
    private String email;
    private String ciudad;
    private String nota;
    private String calle;

    public Estudiante(String nombre, String dni, String year, String especialidad, String email, String ciudad, String nota, String calle) {
        this.nombre = nombre;
        this.dni = dni;
        this.year = year;
        this.especialidad = especialidad;
        this.email = email;
        this.ciudad = ciudad;
        this.nota = nota;
        this.calle = calle;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getYear() {
        return year;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getEmail() {
        return email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getNota() {
        return nota;
    }

    public String getCalle() {
        return calle;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

}
