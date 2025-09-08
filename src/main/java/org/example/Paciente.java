package org.example;

import java.time.LocalDateTime;

public class Cita {
    private long id;
    private Paciente paciente;
    private Dueno dueno;
    private LocalDateTime fecha;
    private String motivo;
    private EstadoCita estado;

    // Constructor
    public Cita(long id, Paciente paciente, Dueno dueno, LocalDateTime fecha, String motivo) {
        setId(id);
        setPaciente(paciente);
        setDueno(dueno);
        setFecha(fecha);
        setMotivo(motivo);
        this.estado = EstadoCita.PROGRAMADA; // Estado inicial
    }

    // Getters y Setters
    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public long getId() {
        return id;
    }

    public void setPaciente(Paciente paciente) {
        if (paciente != null) {
            this.paciente = paciente;
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setDueno(Dueno dueno) {
        if (dueno != null) {
            this.dueno = dueno;
        }
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setFecha(LocalDateTime fecha) {
        if (fecha != null && fecha.isAfter(LocalDateTime.now())) {
            this.fecha = fecha;
        }
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setMotivo(String motivo) {
        if (motivo != null && !motivo.isEmpty()) {
            this.motivo = motivo;
        }
    }

    public String getMotivo() {
        return motivo;
    }

    public void setEstadoCita(EstadoCita estado) {
        if (estado != null) {
            this.estado = estado;
        }
    }

    public EstadoCita getEstadoCita() {
        return estado;
    }

    // Método para reagendar
    public void reagendar(LocalDateTime nuevaFecha) {
        if (estado == EstadoCita.PROGRAMADA && nuevaFecha.isAfter(LocalDateTime.now())) {
            setFecha(nuevaFecha);
        }
    }

    // Método para cancelar
    public void cancelar(String razon) {
        if (estado == EstadoCita.PROGRAMADA) {
            setEstadoCita(EstadoCita.CANCELADA);
            // Podríamos guardar la razón si tuviéramos un atributo para ello
        }
    }

    // Método para marcar como atendida
    public void marcarAtendida() {
        if (estado == EstadoCita.PROGRAMADA) {
            setEstadoCita(EstadoCita.ATENDIDA);
        }
    }

    // Método resumen
    public String resumen() {
        return "Cita[id=" + id + ", paciente=" + paciente.getNombre() +
                ", dueno=" + dueno.getNombreCompleto() +
                ", fecha=" + fecha + ", motivo=" + motivo + "]";
    }
}