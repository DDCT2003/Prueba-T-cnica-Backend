package com.dylan.picoyplaca_backend.model;

public class ConsultaResponse {
    private String placa;
    private boolean puedeCircular;
    private String mensaje;

    public ConsultaResponse() {
    }

    public ConsultaResponse(String placa, boolean puedeCircular, String mensaje) {
        this.placa = placa;
        this.puedeCircular = puedeCircular;
        this.mensaje = mensaje;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isPuedeCircular() {
        return puedeCircular;
    }

    public void setPuedeCircular(boolean puedeCircular) {
        this.puedeCircular = puedeCircular;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
