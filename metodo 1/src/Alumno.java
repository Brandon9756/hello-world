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

    // Getters
    public String getNombre() {
        return nombre;
    }

    // Método principal de prueba
    public static void main(String[] args) {
        // Ejemplo de uso
        double[] notas = {85.5, 90.0, 78.0, 92.5, 88.0};
        Alumno alumno = new Alumno("Carlos Ruiz", notas);

        System.out.println("Nombre del alumno: " + alumno.getNombre());
        System.out.println("Promedio: " + alumno.calcularPromedio());
    }
}
