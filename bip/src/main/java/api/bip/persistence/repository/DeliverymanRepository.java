package api.bip.persistence.repository;

import api.bip.persistence.model.Deliveryman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class DeliverymanRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Inserir um novo entregador
    // Inserir um novo entregador
    public Deliveryman insertDeliveryman(Deliveryman deliveryman) {
        String sql = "INSERT INTO entregador (nome, chave_pix, taxa_retorno_default, taxa_deslocamento_default, taxa_entregador_por_km_default, taxa_entregador_fixa_default, telefone_id, endereco_id, localizacao_atual_id, ativo, url_foto, token, qtd_entregas_realizadas) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, deliveryman.getNome());
            ps.setString(2, deliveryman.getChavePix());
            ps.setDouble(3, deliveryman.getTaxaRetornoDefault());
            ps.setDouble(4, deliveryman.getTaxaDeslocamentoDefault());
            ps.setDouble(5, deliveryman.getTaxaEntregadorPorKMDefault());
            ps.setDouble(6, deliveryman.getTaxaEntregadorFixaDefault());
            ps.setLong(7, deliveryman.getTelefoneId());
            ps.setLong(8, deliveryman.getEnderecoId());
            ps.setLong(9, deliveryman.getLocalizacaoAtualId());
            ps.setBoolean(10, deliveryman.isAtivo());
            ps.setString(11, deliveryman.getUrlFoto());
            ps.setString(12, deliveryman.getToken());
            ps.setInt(13, deliveryman.getQtdEntregasRealizadas());
            return ps;
        }, keyHolder);

        // Define o ID gerado no objeto Deliveryman
        deliveryman.setId(keyHolder.getKey().longValue());

        return deliveryman;
    }

    // Atualizar um entregador existente
    public Deliveryman updateDeliveryman(Deliveryman deliveryman) {
        String sql = "UPDATE entregador SET nome = ?, chave_pix = ?, taxa_retorno_default = ?, taxa_deslocamento_default = ?, taxa_entregador_por_km_default = ?, taxa_entregador_fixa_default = ?, telefone_id = ?, endereco_id = ?, localizacao_atual_id = ?, ativo = ?, url_foto = ?, token = ?, qtd_entregas_realizadas = ? WHERE id = ?";

        jdbcTemplate.update(sql,
                deliveryman.getNome(),
                deliveryman.getChavePix(),
                deliveryman.getTaxaRetornoDefault(),
                deliveryman.getTaxaDeslocamentoDefault(),
                deliveryman.getTaxaEntregadorPorKMDefault(),
                deliveryman.getTaxaEntregadorFixaDefault(),
                deliveryman.getTelefoneId(),
                deliveryman.getEnderecoId(),
                deliveryman.getLocalizacaoAtualId(),
                deliveryman.isAtivo(),
                deliveryman.getUrlFoto(),
                deliveryman.getToken(),
                deliveryman.getQtdEntregasRealizadas(),
                deliveryman.getId()
        );

        return deliveryman;
    }
    // Encontrar um entregador por ID
    public Optional<Deliveryman> findById(Long id) {
        String sql = "SELECT * FROM entregador WHERE id = ?";
        List<Deliveryman> entregadores = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Deliveryman.class), id);
        return entregadores.isEmpty() ? Optional.empty() : Optional.of(entregadores.get(0));
    }

    // Retornar todos os entregadores
    public List<Deliveryman> findAll() {
        String sql = "SELECT * FROM entregador";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Deliveryman.class));
    }

    // Retornar apenas entregadores ativos
    public List<Deliveryman> findActiveDeliverymen() {
        String sql = "SELECT * FROM entregador WHERE ativo = true";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Deliveryman.class));
    }

    // Excluir um entregador por ID
    public void deleteById(Long id) {
        String sql = "DELETE FROM entregador WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Retornar entregadores ativos por status
    public List<Deliveryman> findActiveDeliverymenByStatusId(int statusId) {
        String sql = "SELECT * FROM entregador WHERE status_id = ? AND ativo = true";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Deliveryman.class), statusId);
    }
}
