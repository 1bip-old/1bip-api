package api.bip.controller;

import api.bip.persistence.model.Deliveryman;
import api.bip.persistence.service.DeliverymanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery/entregador")
public class DeliverymanController {

    @Autowired
    private DeliverymanService deliverymanService;

    // Inserir um novo entregador
    @PostMapping("/inserir")
    public Deliveryman saveDeliveryman(@RequestBody Deliveryman deliveryman) {
        return deliverymanService.saveDeliveryman(deliveryman);
    }

    // Retornar um entregador específico pelo ID
    @GetMapping("/get/{id}")
    public Deliveryman getDeliveryman(@PathVariable Long id) {
        return deliverymanService.findDeliverymanById(id)
                .orElseThrow(() -> new RuntimeException("Entregador não encontrado"));
    }

    // Atualizar um entregador existente
    @PutMapping("/update/{id}")
    public Deliveryman updateDeliveryman(@PathVariable Long id, @RequestBody Deliveryman deliveryman) {
        return deliverymanService.updateDeliveryman(id, deliveryman);
    }

    // Retornar todos os entregadores
    @GetMapping("/todos")
    public List<Deliveryman> getAllDeliverymen() {
        return deliverymanService.findAllDeliverymen();
    }

    // Retornar apenas entregadores ativos
    @GetMapping("/ativos")
    public List<Deliveryman> getActiveDeliverymen() {
        return deliverymanService.findActiveDeliverymen();
    }

    // Retornar entregadores por status
    @GetMapping("/status/{statusId}")
    public List<Deliveryman> getDeliverymenByStatusId(@PathVariable("statusId") int statusId) {
        return deliverymanService.getDeliverymenByStatusId(statusId);
    }
}
