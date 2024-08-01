package com.sistema.gestionEmpleados.librerias;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LibreriaFechasHoras {

	// Formatear fecha en formato "yyyy-MM-dd"
    public static String formatearFecha(LocalDate fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fecha.format(formatter);
    }

    // Obtener la diferencia en días entre dos fechas
    public static long diferenciaEnDias(LocalDate fecha1, LocalDate fecha2) {
        return ChronoUnit.DAYS.between(fecha1, fecha2);
    }

    // Verificar si una fecha es un fin de semana
    public static boolean esFinDeSemana(LocalDate fecha) {
        return fecha.getDayOfWeek().getValue() >= 6; // 6 = Sábado, 7 = Domingo
    }
}
