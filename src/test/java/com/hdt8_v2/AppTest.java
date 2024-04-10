package com.hdt8_v2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AppTest {

    @Test
    public void testPriorityQueueInsertAndPoll() {
        PriorityQueue<Paciente> emergencyQueue = new PriorityQueue<>();

        try {
            File file = new File("src/main/java/com/estructura/pacientes.txt");
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

        assertEquals("Maria Ramirez", emergencyQueue.poll().getNombre());
        assertEquals("Lorenzo Toledo", emergencyQueue.poll().getNombre());
        assertEquals("Carmen Sarmientos", emergencyQueue.poll().getNombre());
        assertEquals("Juan Perez", emergencyQueue.poll().getNombre());
    }
}
