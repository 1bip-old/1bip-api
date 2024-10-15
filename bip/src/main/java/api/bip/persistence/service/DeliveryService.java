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
    public Delivery insertDelivery(Delivery delivery) {
        // Se o ID for nulo, será uma nova entrega
        if (delivery.getId() == 0) {
            return deliveryRepository.insertDelivery(delivery);  // Método para inserir nova entrega
        } else {
            return deliveryRepository.updateDeliveryById(delivery);  // Método para atualizar uma entrega existente
        }
    }
    // Atualizar uma entrega existente
    public Delivery updateDeliveryById(Long id, Delivery delivery) {
        // Verificar se a entrega existe antes de atualizar
        Optional<Delivery> existingDelivery = deliveryRepository.getDeliveryById(id);
        if (existingDelivery.isPresent()) {
            delivery.setId(id);  // Garantir que o ID seja definido para que seja atualizado corretamente
            return deliveryRepository.updateDeliveryById(delivery);  // Atualizar a entrega
        }
        throw new RuntimeException("Entrega não encontrada");
    }
    // Excluir uma entrega por ID
    public void deleteDeliveryById(Long id) {
        Optional<Delivery> delivery = deliveryRepository.getDeliveryById(id);
        if (delivery.isPresent()) {
            deliveryRepository.deleteDeliveryById(id);  //Método para deletar entrega pelo ID
        } else {
            throw new RuntimeException("Entrega não encontrada para exclusão");
        }
    }
    // Buscar uma entrega por ID
    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRepository.getDeliveryById(id);  // Método para buscar entrega por ID
    }
    // Retornar todas as entregas
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.getAllDeliveries();  // Método para buscar todas as entregas
    }
    // Trazer apenas as entregas ativas
    public List<Delivery> getActiveDeliveries() {
        return deliveryRepository.getActiveDeliveries();  // Método para buscar entregas ativas
    }
    // Trazer apenas as entregas ativas por status
    public List<Delivery> getDeliveriesByStatusId(int statusId) {
        return deliveryRepository.getDeliveriesByStatusId(statusId);  // Método para buscar entregas ativas por status
    }
}
