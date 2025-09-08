import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CLINICA VETERINARIA ===\n");

        // PARTE B: Generación masiva de datos
        System.out.println("--- PARTE B: GENERACION DE DATOS ---");

        // Crear 500 dueños
        Dueno[] duenos = new Dueno[500];
        for (int i = 0; i < 500; i++) {
            long id = i + 1;
            String nombre = "Dueno" + id;
            // Generar teléfono con formato 502-XXXXXXXX
            String telefono = "502-" + generarNumeroTelefono(i);
            String email = "dueno" + id + "@email.com";
            String direccion = "Calle " + (i % 50 + 1) + " Zona " + (i % 15 + 1);

            duenos[i] = new Dueno(id, nombre, telefono, email, direccion);
        }

        // Crear 1000 mascotas (2 por dueño)
        Paciente[] pacientes = new Paciente[1000];
        int indicePaciente = 0;

        for (int i = 0; i < 500; i++) {
            // Primera mascota del dueño
            long id1 = indicePaciente + 1;
            String nombre1 = "Mascota" + id1;
            String especie1 = (indicePaciente % 2 == 0) ? "perro" : "gato";
            String raza1 = "mestizo";
            int edad1 = (indicePaciente % 120) + 1;
            double peso1 = 1.0 + (indicePaciente % 30);

            pacientes[indicePaciente] = new Paciente(id1, nombre1, especie1, raza1, edad1, peso1);
            pacientes[indicePaciente].setDueno(duenos[i]);
            indicePaciente++;

            // Segunda mascota del dueño
            long id2 = indicePaciente + 1;
            String nombre2 = "Mascota" + id2;
            String especie2 = (indicePaciente % 2 == 0) ? "perro" : "gato";
            String raza2 = "mestizo";
            int edad2 = (indicePaciente % 120) + 1;
            double peso2 = 1.0 + (indicePaciente % 30);

            pacientes[indicePaciente] = new Paciente(id2, nombre2, especie2, raza2, edad2, peso2);
            pacientes[indicePaciente].setDueno(duenos[i]);
            indicePaciente++;
        }

        // Verificación: Primeros 3 dueños
        System.out.println("\nPrimeros 3 duenos:");
        for (int i = 0; i < 3; i++) {
            System.out.println(duenos[i].resumen());
        }

        // Verificación: Primeras 6 mascotas
        System.out.println("\nPrimeras 6 mascotas:");
        for (int i = 0; i < 6; i++) {
            System.out.println(pacientes[i].resumen());
        }

        // PARTE C: Reportes
        System.out.println("\n--- PARTE C: REPORTES ---");

        // 1. Conteo de cachorros
        int contadorCachorros = 0;
        for (int i = 0; i < 1000; i++) {
            if (pacientes[i].esCachorro()) {
                contadorCachorros++;
            }
        }
        System.out.println("\n1. Total de cachorros: " + contadorCachorros);

        // 2. Distribución por especie
        int perros = 0;
        int gatos = 0;
        for (int i = 0; i < 1000; i++) {
            if (pacientes[i].getEspecie().equals("perro")) {
                perros++;
            } else if (pacientes[i].getEspecie().equals("gato")) {
                gatos++;
            }
        }
        System.out.println("\n2. Distribucion por especie:");
        System.out.println("   Perros: " + perros);
        System.out.println("   Gatos: " + gatos);

        // 3. Peso promedio por especie
        double sumaPesoPerros = 0;
        double sumaPesoGatos = 0;
        int contadorPerros = 0;
        int contadorGatos = 0;

        for (int i = 0; i < 1000; i++) {
            if (pacientes[i].getEspecie().equals("perro")) {
                sumaPesoPerros += pacientes[i].getPesoKg();
                contadorPerros++;
            } else if (pacientes[i].getEspecie().equals("gato")) {
                sumaPesoGatos += pacientes[i].getPesoKg();
                contadorGatos++;
            }
        }

        System.out.println("\n3. Peso promedio por especie:");
        if (contadorPerros > 0) {
            double promedioPerros = sumaPesoPerros / contadorPerros;
            System.out.println("   Perros: " + String.format("%.2f", promedioPerros) + " kg");
        }
        if (contadorGatos > 0) {
            double promedioGatos = sumaPesoGatos / contadorGatos;
            System.out.println("   Gatos: " + String.format("%.2f", promedioGatos) + " kg");
        }

        // 4. Top 5 mascotas más longevas (sin ordenar con librerías)
        System.out.println("\n4. Top 5 mascotas mas longevas:");
        Paciente[] top5 = new Paciente[5];

        // Inicializar top5 con las primeras 5 mascotas
        for (int i = 0; i < 5; i++) {
            top5[i] = pacientes[i];
        }

        // Ordenar el top5 inicial
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (top5[j].getEdadMeses() > top5[i].getEdadMeses()) {
                    Paciente temp = top5[i];
                    top5[i] = top5[j];
                    top5[j] = temp;
                }
            }
        }

        // Buscar en el resto de mascotas
        for (int i = 5; i < 1000; i++) {
            int edadActual = pacientes[i].getEdadMeses();

            // Ver si entra en el top 5
            for (int j = 0; j < 5; j++) {
                if (edadActual > top5[j].getEdadMeses()) {
                    // Desplazar hacia abajo
                    for (int k = 4; k > j; k--) {
                        top5[k] = top5[k - 1];
                    }
                    top5[j] = pacientes[i];
                    break;
                }
            }
        }

        // Mostrar top 5
        for (int i = 0; i < 5; i++) {
            System.out.println("   " + (i + 1) + ". " + top5[i].resumen());
        }

        // PARTE D: Citas y enum
        System.out.println("\n--- PARTE D: CITAS ---");

        // Crear 40 citas para los primeros 20 dueños (2 por dueño)
        Cita[] citas = new Cita[40];
        int indiceCita = 0;
        LocalDateTime fechaBase = LocalDateTime.now().plusDays(1);

        for (int i = 0; i < 20; i++) {
            // Primera cita del dueño
            LocalDateTime fecha1 = fechaBase.withHour(10).withMinute(0);
            Paciente mascota1 = pacientes[i * 2]; // Primera mascota del dueño
            citas[indiceCita] = new Cita(indiceCita + 1, mascota1, duenos[i], fecha1, "Consulta general");
            indiceCita++;

            // Segunda cita del dueño
            LocalDateTime fecha2 = fechaBase.withHour(11).withMinute(0);
            Paciente mascota2 = pacientes[i * 2 + 1]; // Segunda mascota del dueño
            citas[indiceCita] = new Cita(indiceCita + 1, mascota2, duenos[i], fecha2, "Vacunacion");
            indiceCita++;
        }

        // Aplicar acciones según condiciones
        for (int i = 0; i < 40; i++) {
            long idCita = citas[i].getId();

            if (idCita % 3 == 0) {
                // Si es múltiplo de 3, cancelar
                citas[i].cancelar("no puede asistir");
            } else if (idCita % 2 == 0) {
                // Si es par (y no múltiplo de 3), reagendar
                LocalDateTime nuevaFecha = citas[i].getFecha().plusDays(1);
                citas[i].reagendar(nuevaFecha);
            } else {
                // Las restantes, marcar como atendida
                citas[i].marcarAtendida();
            }
        }

        // Mostrar resumen de citas
        System.out.println("\nResumen de todas las citas:");
        for (int i = 0; i < 40; i++) {
            System.out.println(citas[i].resumen() + " - " + citas[i].getEstadoCita());
        }

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }

    // Método auxiliar para generar número de teléfono
    private static String generarNumeroTelefono(int semilla) {
        // Generar 8 dígitos de forma determinística
        int numero = 10000000 + (semilla * 12345) % 90000000;
        return String.valueOf(numero);
    }
}