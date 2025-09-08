public class Dueno {
    private long id;
    private String nombreCompleto;
    private String telefono;
    private String email;
    private String direccion;

    // Constructor completo
    public Dueno(long id, String nombreCompleto, String telefono, String email, String direccion) {
        setId(id);
        setNombreCompleto(nombreCompleto);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
    }

    // Constructor sobrecargado (simplificado)
    public Dueno(long id, String nombreCompleto, String telefono) {
        this(id, nombreCompleto, telefono, null, "sin direccion");
    }

    // Getters y Setters con validaciones básicas
    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public long getId() {
        return id;
    }

    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto != null && !nombreCompleto.isEmpty()) {
            this.nombreCompleto = nombreCompleto;
        }
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.isEmpty()) {
            this.telefono = telefono;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setEmail(String email) {
        this.email = email; // Puede ser null
    }

    public String getEmail() {
        return email;
    }

    public void setDireccion(String direccion) {
        if (direccion != null && !direccion.isEmpty()) {
            this.direccion = direccion;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    // Método resumen para mostrar información
    public String resumen() {
        return "Dueno[id=" + id + ", nombre=" + nombreCompleto +
                ", tel=" + telefono + ", email=" + email +
                ", dir=" + direccion + "]";
    }
}
