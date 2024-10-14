package api.bip.persistence.repository;

import api.bip.persistence.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class DeliveryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Inserir uma nova entrega com KeyHolder para capturar o ID gerado
    public Delivery insertDelivery(Delivery delivery) {
        String sql = "INSERT INTO delivery (status_entrega_id, com_retorno, codigo_pedido, codigo_confirmacao, estabelecimento_id, destino_id, entregador_id, cliente_nome, cliente_telefone, taxa_entrega_sugerida, taxa_entrega_aceita, valor_cotacao, cotacao_aceita_id, distancia_destino_km, confirmacao_entregador_id, confirmacao_estabelecimento_id, forma_pagamento, valor_pedido, valor_pago_cliente, valor_troco, qr_code_image, copy_and_paste, entrega_ativa, esta_expandido) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, delivery.getStatusEntregaId());
            ps.setBoolean(2, delivery.isComRetorno());
            ps.setString(3, delivery.getCodigoPedido());
            ps.setString(4, delivery.getCodigoConfirmacao());
            ps.setLong(5, delivery.getEstabelecimentoId());
            ps.setLong(6, delivery.getDestinoId());
            ps.setLong(7, delivery.getEntregadorId());
            ps.setString(8, delivery.getClienteNome());
            ps.setString(9, delivery.getClienteTelefone());
            ps.setDouble(10, delivery.getTaxaEntregaSugerida());
            ps.setDouble(11, delivery.getTaxaEntregaAceita());
            ps.setDouble(12, delivery.getValorCotacao());
            ps.setLong(13, delivery.getCotacaoAceitaId());
            ps.setDouble(14, delivery.getDistanciaDestinoKm());
            ps.setLong(15, delivery.getConfirmacaoEntregadorId());
            ps.setLong(16, delivery.getConfirmacaoEstabelecimentoId());
            ps.setString(17, delivery.getFormaPagamento());
            ps.setDouble(18, delivery.getValorPedido());
            ps.setDouble(19, delivery.getValorPagoCliente());
            ps.setDouble(20, delivery.getValorTroco());
            ps.setString(21, delivery.getQrCodeImage());
            ps.setString(22, delivery.getCopyAndPaste());
            ps.setBoolean(23, delivery.isEntregaAtiva());
            ps.setBoolean(24, delivery.isEstaExpandido());
            return ps;
        }, keyHolder);

        delivery.setId(keyHolder.getKey().longValue());
        return delivery;
    }

    // Atualizar uma entrega existente
    public Delivery updateDelivery(Delivery delivery) {
        String sql = "UPDATE delivery SET status_entrega_id = ?, com_retorno = ?, codigo_pedido = ?, codigo_confirmacao = ?, estabelecimento_id = ?, destino_id = ?, entregador_id = ?, cliente_nome = ?, cliente_telefone = ?, taxa_entrega_sugerida = ?, taxa_entrega_aceita = ?, valor_cotacao = ?, cotacao_aceita_id = ?, distancia_destino_km = ?, confirmacao_entregador_id = ?, confirmacao_estabelecimento_id = ?, forma_pagamento = ?, valor_pedido = ?, valor_pago_cliente = ?, valor_troco = ?, qr_code_image = ?, copy_and_paste = ?, entrega_ativa = ?, esta_expandido = ? WHERE id = ?";

        jdbcTemplate.update(sql,
                delivery.getStatusEntregaId(),
                delivery.isComRetorno(),
                delivery.getCodigoPedido(),
                delivery.getCodigoConfirmacao(),
                delivery.getEstabelecimentoId(),
                delivery.getDestinoId(),
                delivery.getEntregadorId(),
                delivery.getClienteNome(),
                delivery.getClienteTelefone(),
                delivery.getTaxaEntregaSugerida(),
                delivery.getTaxaEntregaAceita(),
                delivery.getValorCotacao(),
                delivery.getCotacaoAceitaId(),
                delivery.getDistanciaDestinoKm(),
                delivery.getConfirmacaoEntregadorId(),
                delivery.getConfirmacaoEstabelecimentoId(),
                delivery.getFormaPagamento(),
                delivery.getValorPedido(),
                delivery.getValorPagoCliente(),
                delivery.getValorTroco(),
                delivery.getQrCodeImage(),
                delivery.getCopyAndPaste(),
                delivery.isEntregaAtiva(),
                delivery.isEstaExpandido(),
                delivery.getId()
        );

        return delivery;
    }

    // Encontrar uma entrega por ID
    public Optional<Delivery> findById(Long id) {
        String sql = "SELECT * FROM delivery WHERE id = ?";
        try {
            Delivery delivery = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Delivery.class), id);
            return Optional.ofNullable(delivery);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    // Verificar se uma entrega existe pelo ID
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM delivery WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    // Retornar todas as entregas
    public List<Delivery> findAll() {
        String sql = "SELECT * FROM delivery";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Delivery.class));
    }

    // Retornar apenas entregas ativas
    public List<Delivery> findActiveDeliveries() {
        String sql = "SELECT * FROM delivery WHERE entrega_ativa = true";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Delivery.class));
    }

    // Excluir uma entrega por ID
    public void deleteById(Long id) {
        String sql = "DELETE FROM delivery WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Retornar apenas entregas ativas por status
    public List<Delivery> findDeliveriesByStatusId(int statusId) {
        String sql = "SELECT * FROM delivery WHERE entrega_ativa = true AND status_entrega_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Delivery.class), statusId);
    }
}
