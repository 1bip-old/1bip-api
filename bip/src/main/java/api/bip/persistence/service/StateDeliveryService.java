package api.bip.persistence.service;
import api.bip.persistence.model.StateDelivery;
import api.bip.persistence.repository.StateDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateDeliveryService {

    @Autowired
    private StateDeliveryRepository stateDeliveryRepository;

    // Trazer apenas os status entregas ativas
    public List<StateDelivery> findActiveStateDelivery() {
        return stateDeliveryRepository.findActiveStateDeliveryRepository();
    }
}
