import java.awt.Desktop;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private HashMap<String, String> contacts = new HashMap<>();
    private final String filename = "agenda.csv"; // Cambio a CSV

    // Cargar los contactos desde el archivo CSV
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            contacts.clear();
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Saltar encabezado
                    continue;
                }
                String[] parts = line.replace("\"", "").split(",", 2);
                if (parts.length == 2) {
                    contacts.put(parts[0], parts[1]);
                }
            }
            System.out.println("Contactos cargados exitosamente desde CSV.");
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo: " + e.getMessage());
        }
    }

    // Guardar los contactos en formato CSV y abrir el archivo
    public void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Número,Nombre"); // Encabezado
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String number = entry.getKey();
                String name = entry.getValue().replace("\"", "\"\"");
                writer.printf("\"%s\",\"%s\"%n", number, name);
            }
            System.out.println("Contactos guardados exitosamente en formato CSV.");

            // Intentar abrir automáticamente con el programa predeterminado (como Excel)
            File file = new File(filename);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }

        } catch (IOException e) {
            System.out.println("No se pudo guardar o abrir el archivo: " + e.getMessage());
        }
    }

    // Mostrar los contactos
    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Crear un nuevo contacto
    public void create(String number, String name) {
        if (contacts.containsKey(number)) {
            System.out.println("Ya existe un contacto con ese número.");
        } else {
            contacts.put(number, name);
            System.out.println("Contacto agregado.");
        }
    }

    // Eliminar un contacto
    public void delete(String number) {
        if (contacts.remove(number) != null) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("No se encontró el número proporcionado.");
        }
    }

    // Menú interactivo
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            System.out.println("\n=== Menú Agenda ===");
            System.out.println("1. Ver contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar contactos y abrir CSV");
            System.out.println("5. Cargar contactos desde CSV");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    list();
                    break;
                case "2":
                    System.out.print("Ingrese el número: ");
                    String number = scanner.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String name = scanner.nextLine();
                    create(number, name);
                    break;
                case "3":
                    System.out.print("Ingrese el número a eliminar: ");
                    String toDelete = scanner.nextLine();
                    delete(toDelete);
                    break;
                case "4":
                    save();
                    break;
                case "5":
                    load();
                    break;
                case "0":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (!option.equals("0"));
    }

    // Método main para ejecutar el programa
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        book.load(); // Carga automática
        book.menu();
        book.save(); // Guardado final
    }
}
