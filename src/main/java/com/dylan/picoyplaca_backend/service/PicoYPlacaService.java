package com.dylan.picoyplaca_backend.service;

import com.dylan.picoyplaca_backend.model.ConsultaRequest;
import com.dylan.picoyplaca_backend.model.ConsultaResponse;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

@Service
public class PicoYPlacaService {
    private static final Pattern PLACA_PATTERN = Pattern.compile("^[A-Z]{3}[0-9]{3,4}$");

    public ConsultaResponse consultar(ConsultaRequest req) {
        int ultimoDigito = Character.getNumericValue(req.getPlaca().charAt(req.getPlaca().length() - 1));
        LocalDate fecha = LocalDate.parse(req.getFecha());
        DayOfWeek dia = fecha.getDayOfWeek();
        LocalTime horaConsulta = LocalTime.parse(req.getHora());

        boolean restringido = false;

        if (!PLACA_PATTERN.matcher(req.getPlaca()).matches()) {
            return new ConsultaResponse(req.getPlaca(), false,
                    "Placa inválida: Debe tener 3 letras seguidas de 3 o 4 números (Ej: ABC123 o ABC1234).");
        }

        // Validar fecha no anterior a hoy
        LocalDate fechaConsulta = LocalDate.parse(req.getFecha());
        LocalDate fechaHoy = LocalDate.now();
        if (fechaConsulta.isBefore(fechaHoy)) {
            return new ConsultaResponse(req.getPlaca(), false,
                    "Fecha inválida: No puede seleccionar una fecha anterior a hoy.");
        }

        // Validar hora si la fecha es hoy
        if (fechaConsulta.isEqual(fechaHoy)) {
            LocalTime horaActual = LocalTime.now();
            if (horaConsulta.isBefore(horaActual)) {
                return new ConsultaResponse(req.getPlaca(), false,
                        "Hora inválida: No puede seleccionar una hora anterior a la actual.");
            }
        }

        if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY) {
            return new ConsultaResponse(req.getPlaca(), true, "Libre de circular: fin de semana");
        }

        switch (dia) {
            case MONDAY:
                restringido = (ultimoDigito == 1 || ultimoDigito == 2);
                break;
            case TUESDAY:
                restringido = (ultimoDigito == 3 || ultimoDigito == 4);
                break;
            case WEDNESDAY:
                restringido = (ultimoDigito == 5 || ultimoDigito == 6);
                break;
            case THURSDAY:
                restringido = (ultimoDigito == 7 || ultimoDigito == 8);
                break;
            case FRIDAY:
                restringido = (ultimoDigito == 9 || ultimoDigito == 0);
                break;
        }

        // Horario de restricción: 07:00-09:30 y 16:00-19:30
        boolean enHorario = (horaConsulta.isAfter(LocalTime.of(5, 59)) && horaConsulta.isBefore(LocalTime.of(9, 31)))
                || (horaConsulta.isAfter(LocalTime.of(15, 59)) && horaConsulta.isBefore(LocalTime.of(20, 01)));

        if (restringido && enHorario) {
            return new ConsultaResponse(req.getPlaca(), false,
                    "El vehículo NO puede circular el " + req.getFecha() + " a las " + req.getHora());
        } else {
            return new ConsultaResponse(req.getPlaca(), true,
                    "El vehículo SÍ puede circular el " + req.getFecha() + " a las " + req.getHora());
        }
    }
}
