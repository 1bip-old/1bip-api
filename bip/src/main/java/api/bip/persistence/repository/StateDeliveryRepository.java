package api.bip.persistence.repository;

import api.bip.persistence.model.StateDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateDeliveryRepository extends JpaRepository<StateDelivery, Long> {
    // Usando JPQL para customizar a consulta
    @Query("SELECT s FROM StateDelivery s WHERE s.ativo = true")
    List<StateDelivery> findActiveStateDeliveryRepository();
}