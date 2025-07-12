package com.dylan.picoyplaca_backend.model;

public class ConsultaRequest {
    private String placa;
    private String fecha; // formato: "yyyy-MM-dd"
    private String hora; // formato: "HH:mm"

    public ConsultaRequest() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
