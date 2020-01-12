
package MODEL;

import javafx.beans.property.SimpleStringProperty;


public class Estudiante {
    
    private SimpleStringProperty nombre;
    private SimpleStringProperty dni;
    private SimpleStringProperty year;
    private SimpleStringProperty especialidad;
    private SimpleStringProperty email;
    private SimpleStringProperty ciudad;
    private SimpleStringProperty nota;
    private SimpleStringProperty calle;

    public Estudiante(String nombre, String dni, String year, String especialidad, String email, String ciudad, String nota, String calle) {
        this.nombre = new SimpleStringProperty(nombre);
        this.dni = new SimpleStringProperty(dni);
        this.year = new SimpleStringProperty(year);
        this.especialidad = new SimpleStringProperty(especialidad);
        this.email = new SimpleStringProperty(email);
        this.ciudad = new SimpleStringProperty(ciudad);
        this.nota = new SimpleStringProperty(nota);
        this.calle = new SimpleStringProperty(calle);
    }

    public String getNombre() {
        return nombre.get();
    }

 
    public String getDni() {
        return dni.get();
    }


    public String getYear() {
        return year.get();
    }


    public String getEspecialidad() {
        return especialidad.get();
    }

    

    public String getEmail() {
        return email.get();
    }


    public String getCiudad() {
        return ciudad.get();
    }

  

    public String getNota() {
        return nota.get();
    }

   

    public String getCalle() {
        return calle.get();
    }

    public void setNombre(SimpleStringProperty nombre) {
        this.nombre = nombre;
    }

    public void setDni(SimpleStringProperty dni) {
        this.dni = dni;
    }

    public void setYear(SimpleStringProperty year) {
        this.year = year;
    }

    public void setEspecialidad(SimpleStringProperty especialidad) {
        this.especialidad = especialidad;
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }

    public void setCiudad(SimpleStringProperty ciudad) {
        this.ciudad = ciudad;
    }

    public void setNota(SimpleStringProperty nota) {
        this.nota = nota;
    }

    public void setCalle(SimpleStringProperty calle) {
        this.calle = calle;
    }

   
    
    
    
    
    
    
    
    
}
