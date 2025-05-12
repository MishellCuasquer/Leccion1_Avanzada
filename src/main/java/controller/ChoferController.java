package com.example.transporte.controller;

import com.example.transporte.model.Chofer;
import com.example.transporte.service.ChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChoferController {

    @Autowired
    private ChoferService choferService;

    @GetMapping("/reporte_chofer")
    public String generarReporte(Model model) {

        // Lista de Choferes
        List<Chofer> choferes = new ArrayList<>();
        choferes.add(new Chofer("Martin", 10, new int[]{8, 7, 6, 8, 7, 5}));
        choferes.add(new Chofer("Pedro", 12, new int[]{9, 8, 7, 8, 8, 6}));
        choferes.add(new Chofer("Martha", 11, new int[]{7, 7, 7, 7, 7, 7}));
        choferes.add(new Chofer("kevin", 13, new int[]{10, 9, 8, 9, 9, 7}));
        choferes.add(new Chofer("Teo", 10, new int[]{6, 6, 6, 6, 6, 6}));

        // Preparar datos para la vista
        List<Map<String, Object>> datosChoferes = new ArrayList<>();
        for (Chofer c : choferes) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("nombre", c.getNombre());
            datos.put("totalHoras", c.getTotalHoras());
            datos.put("sueldoSemanal", c.getSueldoSemanal());
            datosChoferes.add(datos);
        }

        // Agregar al modelo para Thymeleaf
        model.addAttribute("choferes", datosChoferes);
        model.addAttribute("totalEmpresa", choferService.totalPagoEmpresa(choferes));

        Chofer maxLunes = choferService.masHorasLunes(choferes);
        model.addAttribute("choferMaxLunes", maxLunes != null ? maxLunes.getNombre() : "N/A");

        // Retorna el nombre de la plantilla HTML (reporte.html)
        return "reporte";
    }
}
