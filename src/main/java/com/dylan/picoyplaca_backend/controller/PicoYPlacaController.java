package com.dylan.picoyplaca_backend.controller;

import com.dylan.picoyplaca_backend.model.ConsultaRequest;
import com.dylan.picoyplaca_backend.model.ConsultaResponse;
import com.dylan.picoyplaca_backend.service.PicoYPlacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/picoyplaca")
@CrossOrigin(origins = "*") // Permite que Angular pueda consumir la API
public class PicoYPlacaController {

    @Autowired
    private PicoYPlacaService service;

    @PostMapping("/consulta")
    public ConsultaResponse consulta(@RequestBody ConsultaRequest request) {
        return service.consultar(request);
    }
}
