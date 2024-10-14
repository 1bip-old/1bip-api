package api.bip.controller;

import api.bip.persistence.model.Delivery;
import api.bip.persistence.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/inserir")
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.saveEntrega(delivery);
    }

    @GetMapping("/get/{id}")
    public Delivery getDelivery(@PathVariable Long id) {
        return deliveryService.findEntregaById(id).orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
    }

    @PutMapping("/update/{id}")
    public Delivery updateDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        return deliveryService.updateEntrega(id, delivery);
    }

    // Endpoint para retornar todas as entregas
    @GetMapping("/entregas/todas")
    public List<Delivery> getAllDeliveries() {
        return deliveryService.findAllDeliveries();
    }

    // Endpoint para retornar apenas entregas ativas
    @GetMapping("/entregas/ativas")
    public List<Delivery> getActiveDeliveries() {
        return deliveryService.findActiveDeliveries();
    }

    // Endpoint para retornar apenas entregas por status
    @GetMapping("/status/{id}")
    public List<Delivery> getDeliveriesByStatusId(@PathVariable("id") int statusId) {
        return deliveryService.getDeliveriesByStatusId(statusId);
    }
}
