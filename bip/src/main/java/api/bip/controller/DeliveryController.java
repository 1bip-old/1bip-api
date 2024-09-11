package api.bip.controller;

import api.bip.persistence.model.Delivery;
import api.bip.persistence.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public Delivery createEntrega(@RequestBody Delivery delivery) {
        return deliveryService.saveEntrega(delivery);
    }
}
