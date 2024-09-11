package api.bip.persistence.service;

import api.bip.persistence.model.Delivery;
import api.bip.persistence.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery saveEntrega(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }
}
