package api.bip.persistence.service;

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
    public Deliveryman saveDeliveryman(Deliveryman deliveryman) {
        if (deliveryman.getId() == null || deliveryman.getId() == 0) {
            return deliverymanRepository.insertDeliveryman(deliveryman); // Inserir novo entregador
        } else {
            return deliverymanRepository.updateDeliveryman(deliveryman); // Atualizar entregador existente
        }
    }

    // Buscar um entregador por ID
    public Optional<Deliveryman> findDeliverymanById(Long id) {
        return deliverymanRepository.findById(id);
    }

    // Atualizar um entregador existente
    public Deliveryman updateDeliveryman(Long id, Deliveryman deliveryman) {
        Optional<Deliveryman> existingDeliveryman = deliverymanRepository.findById(id);
        if (existingDeliveryman.isPresent()) {
            deliveryman.setId(id);
            return deliverymanRepository.updateDeliveryman(deliveryman);
        }
        throw new RuntimeException("Entregador não encontrado");
    }

    // Retornar todos os entregadores
    public List<Deliveryman> findAllDeliverymen() {
        return deliverymanRepository.findAll();
    }

    // Retornar apenas entregadores ativos
    public List<Deliveryman> findActiveDeliverymen() {
        return deliverymanRepository.findActiveDeliverymen();
    }

    // Excluir um entregador por ID
    public void deleteDeliverymanById(Long id) {
        Optional<Deliveryman> deliveryman = deliverymanRepository.findById(id);
        if (deliveryman.isPresent()) {
            deliverymanRepository.deleteById(id);
        } else {
            throw new RuntimeException("Entregador não encontrado para exclusão");
        }
    }

    // Retornar entregadores ativos por status
    public List<Deliveryman> getDeliverymenByStatusId(int statusId) {
        return deliverymanRepository.findActiveDeliverymenByStatusId(statusId);
    }
}
