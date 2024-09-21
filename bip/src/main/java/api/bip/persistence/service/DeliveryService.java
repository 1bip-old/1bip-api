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

    // Inserir ou atualizar uma entrega
    public Delivery saveEntrega(Delivery delivery) {
        // Se o ID for nulo, será uma nova entrega
        if (delivery.getId() == null) {
            return deliveryRepository.insertDelivery(delivery);  // Método para inserir nova entrega
        } else {
            return deliveryRepository.updateDelivery(delivery);  // Método para atualizar uma entrega existente
        }
    }

    // Buscar uma entrega por ID
    public Optional<Delivery> findEntregaById(Long id) {
        return deliveryRepository.findById(id);  // Método para buscar entrega por ID
    }

    // Atualizar uma entrega existente
    public Delivery updateEntrega(Long id, Delivery delivery) {
        // Verificar se a entrega existe antes de atualizar
        Optional<Delivery> existingDelivery = deliveryRepository.findById(id);
        if (existingDelivery.isPresent()) {
            delivery.setId(id);  // Garantir que o ID seja definido para que seja atualizado corretamente
            return deliveryRepository.updateDelivery(delivery);  // Atualizar a entrega
        }
        throw new RuntimeException("Entrega não encontrada");
    }

    // Retornar todas as entregas
    public List<Delivery> findAllDeliveries() {
        return deliveryRepository.findAll();  // Método para buscar todas as entregas
    }

    // Trazer apenas as entregas ativas
    public List<Delivery> findActiveDeliveries() {
        return deliveryRepository.findActiveDeliveries();  // Método para buscar entregas ativas
    }

    // Excluir uma entrega por ID
    public void deleteEntrega(Long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if (delivery.isPresent()) {
            deliveryRepository.deleteById(id);  // Método para deletar entrega pelo ID
        } else {
            throw new RuntimeException("Entrega não encontrada para exclusão");
        }
    }
    // Trazer apenas as entregas ativas por status
    public List<Delivery> getDeliveriesByStatus(int statusId) {
        return deliveryRepository.findDeliveriesByStatus(statusId);  // Método para buscar entregas ativas por status
    }

}
