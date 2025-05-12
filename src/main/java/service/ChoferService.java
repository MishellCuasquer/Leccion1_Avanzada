
package com.example.transporte.service;

import com.example.transporte.model.Chofer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoferService {

    public int calcularTotalEmpresa(List<Chofer> choferes) {
        return choferes.stream()
                .mapToInt(Chofer::getTotalHoras)
                .sum();
    }

    public Chofer masHorasLunes(List<Chofer> choferes) {
        return choferes.stream()
                .max((c1, c2) -> Integer.compare(c1.getHorasTrabajadas()[0], c2.getHorasTrabajadas()[0]))
                .orElse(null);
    }

    public double totalPagoEmpresa(List<Chofer> choferes) {
        return choferes.stream()
                .mapToDouble(Chofer::getSueldoSemanal)
                .sum();
    }
}
