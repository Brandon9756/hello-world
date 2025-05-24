public class Alumno {
    // Atributos
    private final String nombre;
    private final double[] calificaciones; // Array de 5 calificaciones

    // Constructor
    public Alumno(String nombre, double[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    // Método para calcular el promedio
    public double calcularPromedio() {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    // Método para obtener la calificación final en letra según la tabla proporcionada
    public char obtenerCalificacionFinal(double promedio) {
        if (promedio <= 50) {
            return 'F';
        } else if (promedio <= 60) {
            return 'E';
        } else if (promedio <= 70) {
            return 'D';
        } else if (promedio <= 80) {
            return 'C';
        } else if (promedio <= 90) {
            return 'B';
        } else { // promedio entre 91 y 100
            return 'A';
        }
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    // Método principal de prueba
    public static void main(String[] args) {
        double[] notas = {65.0, 72.0, 58.0, 80.0, 90.0};
        Alumno alumno = new Alumno("Luis Méndez", notas);

        double promedio = alumno.calcularPromedio();
        char calificacionFinal = alumno.obtenerCalificacionFinal(promedio);

        System.out.println("Nombre del alumno: " + alumno.getNombre());
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación final: " + calificacionFinal);
    }
}
