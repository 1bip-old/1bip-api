package api.bip.controller;

import api.bip.persistence.model.Deliveryman;
import api.bip.persistence.service.DeliverymanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliveryman")
public class DeliverymanController {

    @Autowired
    private DeliverymanService deliverymanService;

    // Inserir um novo entregador
    @PostMapping("/insert")
    public Deliveryman insertDeliveryman(@RequestBody Deliveryman deliveryman) {
        return deliverymanService.insertDeliveryman(deliveryman);
    }
    // Atualizar um entregador existente
    @PutMapping("/update/{id}")
    public Deliveryman updateDeliverymanById(@PathVariable Long id, @RequestBody Deliveryman deliveryman) {
        return deliverymanService.updateDeliverymanById(id, deliveryman);
    }
    // Excluir um entregador por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDeliveryById(@PathVariable Long id) {
        deliverymanService.deleteDeliverymanById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content ao concluir a exclusão
    }
    // Retornar um entregador específico pelo ID
    @GetMapping("/get/{id}")
    public Deliveryman getDeliveryman(@PathVariable Long id) {
        return deliverymanService.getDeliverymanById(id)
                .orElseThrow(() -> new RuntimeException("Entregador não encontrado"));
    }
    // Retornar todos os entregadores
    @GetMapping("/all")
    public List<Deliveryman> getAllDeliverymen() {
        return deliverymanService.getAllDeliverymen();
    }
    // Retornar apenas entregadores ativos
    @GetMapping("/deliveryman/active")
    public List<Deliveryman> getActiveDeliverymen() {
        return deliverymanService.getActiveDeliverymen();
    }
    // Retornar entregadores por status
    @GetMapping("/status/{statusId}")
    public List<Deliveryman> getDeliverymenByStatusId(@PathVariable("statusId") int statusId) {
        return deliverymanService.getDeliverymenByStatusId(statusId);
    }
}
