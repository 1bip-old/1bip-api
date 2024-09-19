package api.bip.persistence.repository;

import api.bip.persistence.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    // Usando JPQL para customizar a consulta
    @Query("SELECT d FROM Delivery d WHERE d.entregaAtiva = true")
    List<Delivery> findActiveDeliveries();
}