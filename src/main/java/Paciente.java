public class Paciente {
    private long id;
    private String nombre;
    private String especie;
    private String raza;
    private int edadMeses;
    private double pesoKg;
    private Dueno dueno;

    // Constructor completo
    public Paciente(long id, String nombre, String especie, String raza, int edadMeses, double pesoKg) {
        setId(id);
        setNombre(nombre);
        setEspecie(especie);
        setRaza(raza);
        setEdadMeses(edadMeses);
        setPesoKg(pesoKg);
    }

    // Constructor sobrecargado (simplificado)
    public Paciente(long id, String nombre, String especie) {
        this(id, nombre, especie, "mestizo", 1, 1.0);
    }

    // Getters y Setters con validaciones
    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setEspecie(String especie) {
        if (especie != null && !especie.isEmpty()) {
            this.especie = especie;
        }
    }

    public String getEspecie() {
        return especie;
    }

    public void setRaza(String raza) {
        if (raza != null && !raza.isEmpty()) {
            this.raza = raza;
        }
    }

    public String getRaza() {
        return raza;
    }

    public void setEdadMeses(int edadMeses) {
        if (edadMeses > 0) {
            this.edadMeses = edadMeses;
        }
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public void setPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        }
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public Dueno getDueno() {
        return dueno;
    }

    // Método para verificar si es cachorro
    public boolean esCachorro() {
        return edadMeses <= 12;
    }

    // Método resumen
    public String resumen() {
        return "Paciente[id=" + id + ", nombre=" + nombre +
                ", especie=" + especie + ", raza=" + raza +
                ", edad=" + edadMeses + " meses, peso=" + pesoKg + " kg]";
    }
}