package api.bip.persistence.repository;
import api.bip.persistence.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    // Métodos de consulta adicionais, se necessário
}