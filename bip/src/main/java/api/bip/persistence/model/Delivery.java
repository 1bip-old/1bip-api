package api.bip.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusEntrega;
    private boolean comRetorno;
    private String codigoPedido;
    private String codigoConfirmacao;
    private Integer estabelecimentoId;
    private Integer destinoId;
    private Integer entregadorId;
    private String clienteNome;
    private String clienteTelefone;
    private double taxaEntregaSugerida;
    private double taxaEntregaAceita;
    private double valorCotacao;
    private Integer cotacaoAceitaId;
    private double distanciaDestinoKm;
    private Integer confirmacaoEntregadorId;
    private Integer confirmacaoEstabelecimentoId;
    private String formaPagamento;
    private double valorPedido;
    private double valorPagoCliente;
    private double valorTroco;
    private String qrCodeImage;
    private String copyAndPaste;
    private boolean entregaAtiva;
    private boolean estaExpandido;

    public boolean isEstaExpandido() {
        return estaExpandido;
    }

    public void setEstaExpandido(boolean estaExpandido) {
        this.estaExpandido = estaExpandido;
    }

    public boolean isEntregaAtiva() {
        return entregaAtiva;
    }

    public void setEntregaAtiva(boolean entregaAtiva) {
        this.entregaAtiva = entregaAtiva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(Integer destinoId) {
        this.destinoId = destinoId;
    }

    public Integer getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(Integer estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    public Integer getCotacaoAceitaId() {
        return cotacaoAceitaId;
    }

    public void setCotacaoAceitaId(Integer cotacaoAceitaId) {
        this.cotacaoAceitaId = cotacaoAceitaId;
    }

    public Integer getEntregadorId() {
        return entregadorId;
    }

    public void setEntregadorId(Integer entregadorId) {
        this.entregadorId = entregadorId;
    }

    public Integer getConfirmacaoEntregadorId() {
        return confirmacaoEntregadorId;
    }

    public void setConfirmacaoEntregadorId(Integer confirmacaoEntregadorId) {
        this.confirmacaoEntregadorId = confirmacaoEntregadorId;
    }

    public Integer getConfirmacaoEstabelecimentoId() {
        return confirmacaoEstabelecimentoId;
    }

    public void setConfirmacaoEstabelecimentoId(Integer confirmacaoEstabelecimentoId) {
        this.confirmacaoEstabelecimentoId = confirmacaoEstabelecimentoId;
    }

    public boolean isComRetorno() {
        return comRetorno;
    }

    public void setComRetorno(boolean comRetorno) {
        this.comRetorno = comRetorno;
    }

    public double getDistanciaDestinoKm() {
        return distanciaDestinoKm;
    }

    public void setDistanciaDestinoKm(double distanciaDestinoKm) {
        this.distanciaDestinoKm = distanciaDestinoKm;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(double valorTroco) {
        this.valorTroco = valorTroco;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public double getValorPagoCliente() {
        return valorPagoCliente;
    }

    public void setValorPagoCliente(double valorPagoCliente) {
        this.valorPagoCliente = valorPagoCliente;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getCodigoConfirmacao() {
        return codigoConfirmacao;
    }

    public void setCodigoConfirmacao(String codigoConfirmacao) {
        this.codigoConfirmacao = codigoConfirmacao;
    }

    public String getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteTelefone() {
        return clienteTelefone;
    }

    public void setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
    }

    public String getQrCodeImage() {
        return qrCodeImage;
    }

    public void setQrCodeImage(String qrCodeImage) {
        this.qrCodeImage = qrCodeImage;
    }

    public String getCopyAndPaste() {
        return copyAndPaste;
    }

    public void setCopyAndPaste(String copyAndPaste) {
        this.copyAndPaste = copyAndPaste;
    }

    public double getTaxaEntregaSugerida() {
        return taxaEntregaSugerida;
    }

    public void setTaxaEntregaSugerida(double taxaEntregaSugerida) {
        this.taxaEntregaSugerida = taxaEntregaSugerida;
    }

    public double getValorCotacao() {
        return valorCotacao;
    }

    public void setValorCotacao(double valorCotacao) {
        this.valorCotacao = valorCotacao;
    }

    public double getTaxaEntregaAceita() {
        return taxaEntregaAceita;
    }

    public void setTaxaEntregaAceita(double taxaEntregaAceita) {
        this.taxaEntregaAceita = taxaEntregaAceita;
    }
}
