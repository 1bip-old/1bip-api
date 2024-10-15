package api.bip.controller;

import api.bip.persistence.model.Delivery;
import api.bip.persistence.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/insert")
    public Delivery insertDelivery(@RequestBody Delivery delivery) {
        return deliveryService.insertDelivery(delivery);
    }
    @PutMapping("/update/{id}")
    public Delivery updateDeliveryById(@PathVariable Long id, @RequestBody Delivery delivery) {
        return deliveryService.updateDeliveryById(id, delivery);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDeliveryById(@PathVariable Long id) {
        deliveryService.deleteDeliveryById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content ao concluir a exclusão
    }
    @GetMapping("/get/{id}")
    public Delivery getDeliveryById(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id).orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
    }
    // Endpoint para retornar todas as entregas
    @GetMapping("/all")
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }
    // Endpoint para retornar apenas entregas ativas
    @GetMapping("/deliveries/active")
    public List<Delivery> getActiveDeliveries() {
        return deliveryService.getActiveDeliveries();
    }
    // Endpoint para retornar apenas entregas por status
    @GetMapping("/status/{id}")
    public List<Delivery> getDeliveriesByStatusId(@PathVariable("id") int statusId) {
        return deliveryService.getDeliveriesByStatusId(statusId);
    }
}



