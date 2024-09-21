package api.bip.persistence.repository;

import api.bip.persistence.model.StateDelivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateDeliveryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StateDelivery> findActiveStateDeliveryRepository() {
        String sql = "SELECT * FROM state_delivery WHERE ativo = true";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StateDelivery.class));
    }
}