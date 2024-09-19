package api.bip.persistence.service;

import api.bip.persistence.model.Delivery;
import api.bip.persistence.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery saveEntrega(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    // Encontrar uma entrega por ID
    public Optional<Delivery> findEntregaById(Long id) {
        return deliveryRepository.findById(id);
    }

    // Atualizar uma entrega
    public Delivery updateEntrega(Long id, Delivery delivery) {
        if (deliveryRepository.existsById(id)) {
            delivery.setId(id); //Certifique-se de definir o ID para que o método save saiba que é uma atualização
            return deliveryRepository.save(delivery);
        }
        throw new RuntimeException("Entrega não encontrada");
    }

    // Retornar todas as entregas
    public List<Delivery> findAllDeliveries() {
        return deliveryRepository.findAll();
    }
    // Trazer apenas as entregas ativas
    public List<Delivery> findActiveDeliveries() {
        return deliveryRepository.findActiveDeliveries(); // ou findActiveDeliveries(), dependendo da abordagem
    }
}
