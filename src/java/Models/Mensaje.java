package Models;

public class Mensaje {

  private String nombre;
  private String mensaje;

  public Mensaje() {
  }

  public Mensaje(String nombre, String mensaje) {
    this.nombre = nombre;
    this.mensaje = mensaje;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

}
