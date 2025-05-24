class Main {
    public static void main(String[] args) {
        double[] calificaciones = {85.5, 92.0, 88.5, 79.0, 95.5};
        CalificacionEstudiante estudiante = new CalificacionEstudiante("Juan Pérez", calificaciones);
        estudiante.imprimirResultados();
    }
}

class CalificacionEstudiante {
    private final String nombre;
    private final double[] calificaciones;

    public CalificacionEstudiante(String nombre, double[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    public char obtenerCalificacionFinal(double promedio) {
        if (promedio <= 50) return 'F';
        else if (promedio <= 60) return 'E';
        else if (promedio <= 70) return 'D';
        else if (promedio <= 80) return 'C';
        else if (promedio <= 90) return 'B';
        else return 'A';
    }

    public void imprimirResultados() {
        double promedio = calcularPromedio();
        char calificacion = obtenerCalificacionFinal(promedio);

        System.out.println("Nombre del estudiante: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        System.out.printf("Promedio: %.2f\n", promedio);
        System.out.println("Calificación: " + calificacion);
    }
}