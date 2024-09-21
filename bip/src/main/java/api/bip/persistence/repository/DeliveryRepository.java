package api.bip.persistence.repository;

import api.bip.persistence.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeliveryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Inserir uma nova entrega
    public Delivery insertDelivery(Delivery delivery) {
        String sql = "INSERT INTO delivery (status_entrega, com_retorno, codigo_pedido, codigo_confirmacao, estabelecimento_id, destino_id, entregador_id, cliente_nome, cliente_telefone, taxa_entrega_sugerida, taxa_entrega_aceita, valor_cotacao, cotacao_aceita_id, distancia_destino_km, confirmacao_entregador_id, confirmacao_estabelecimento_id, forma_pagamento, valor_pedido, valor_pago_cliente, valor_troco, qr_code_image, copy_and_paste, entrega_ativa, esta_expandido) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
                delivery.isEstaExpandido()
        );

        return delivery;
    }

    // Atualizar uma entrega existente
    public Delivery updateDelivery(Delivery delivery) {
        String sql = "UPDATE delivery SET status_entrega = ?, com_retorno = ?, codigo_pedido = ?, codigo_confirmacao = ?, estabelecimento_id = ?, destino_id = ?, entregador_id = ?, cliente_nome = ?, cliente_telefone = ?, taxa_entrega_sugerida = ?, taxa_entrega_aceita = ?, valor_cotacao = ?, cotacao_aceita_id = ?, distancia_destino_km = ?, confirmacao_entregador_id = ?, confirmacao_estabelecimento_id = ?, forma_pagamento = ?, valor_pedido = ?, valor_pago_cliente = ?, valor_troco = ?, qr_code_image = ?, copy_and_paste = ?, entrega_ativa = ?, esta_expandido = ? WHERE id = ?";

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
        List<Delivery> deliveries = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Delivery.class), id);
        if (deliveries.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(deliveries.get(0));
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
    public List<Delivery> findDeliveriesByStatus(int statusId) {
        String sql = "SELECT * FROM delivery WHERE entrega_ativa = true AND status_entrega_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Delivery.class), statusId);
    }
}
