package api.bip.persistence.service;

import api.bip.persistence.model.Delivery;
import api.bip.persistence.model.Deliveryman;
import api.bip.persistence.repository.DeliverymanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliverymanService {

    @Autowired
    private DeliverymanRepository deliverymanRepository;

    // Inserir ou atualizar um entregador
    public Deliveryman insertDeliveryman(Deliveryman deliveryman) {
        if (deliveryman.getId() == null || deliveryman.getId() == 0) {
            return deliverymanRepository.insertDeliveryman(deliveryman); // Inserir novo entregador
        } else {
            return deliverymanRepository.updateDeliveryman(deliveryman); // Atualizar entregador existente
        }
    }
    // Atualizar um entregador existente
    public Deliveryman updateDeliverymanById(Long id, Deliveryman deliveryman) {
        Optional<Deliveryman> existingDeliveryman = deliverymanRepository.getDeliverymanById(id);
        if (existingDeliveryman.isPresent()) {
            deliveryman.setId(id);
            return deliverymanRepository.updateDeliveryman(deliveryman);
        }
        throw new RuntimeException("Entregador não encontrado");
    }
    // Excluir um entregador por ID
    public void deleteDeliverymanById(Long id) {
        Optional<Deliveryman> deliveryman = deliverymanRepository.getDeliverymanById(id);
        if (deliveryman.isPresent()) {
            deliverymanRepository.deleteDeliverymanById(id);  //Método para deletar entregador pelo ID
        } else {
            throw new RuntimeException("Entregador não encontrada para exclusão");
        }
    }
    // Buscar um entregador por ID
    public Optional<Deliveryman> getDeliverymanById(Long id) {
        return deliverymanRepository.getDeliverymanById(id);
    }
    // Retornar todos os entregadores
    public List<Deliveryman> getAllDeliverymen() {
        return deliverymanRepository.getAllDeliverymen();
    }
    // Retornar apenas entregadores ativos
    public List<Deliveryman> getActiveDeliverymen() {
        return deliverymanRepository.getActiveDeliverymen();
    }
    // Retornar entregadores ativos por status
    public List<Deliveryman> getDeliverymenByStatusId(int statusId) {
        return deliverymanRepository.getActiveDeliverymenByStatusId(statusId);
    }
}
