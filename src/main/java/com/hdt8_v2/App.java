package com.hdt8_v2;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        PriorityQueue<Paciente> emergencyQueue = new PriorityQueue<>();

        // Leer datos de pacientes del archivo
        try {
            File file = new File("src/main/java/com/hdt8_v2/pacientes.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String nombre = parts[0].trim();
                    String sintoma = parts[1].trim();
                    char codigoEmergencia = parts[2].trim().charAt(0);
                    Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                    emergencyQueue.add(paciente);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
            return;
        }

        // Atender pacientes en orden de prioridad
        while (!emergencyQueue.isEmpty()) {
            Paciente pacienteAtendido = emergencyQueue.poll();
            if (pacienteAtendido != null) {
                System.out.println("Paciente atendido:");
                System.out.println("Nombre: " + pacienteAtendido.getNombre());
                System.out.println("Síntoma: " + pacienteAtendido.getSintoma());
                System.out.println("Prioridad: " + pacienteAtendido.getCodigoEmergencia());
                System.out.println("-------------------------------------------");
            }
        }
    }
}
