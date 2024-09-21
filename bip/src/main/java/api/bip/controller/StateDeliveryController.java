package api.bip.controller;

import api.bip.persistence.model.StateDelivery;
import api.bip.persistence.service.StateDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StateDeliveryController {

    @Autowired
    private StateDeliveryService stateDeliveryService;

    // Endpoint para retornar apenas entregas ativas
    @GetMapping("/ativos/entrega")
    public List<StateDelivery> getActiveStateDeliveries() {
          return stateDeliveryService.findActiveStateDelivery();
    }
}
