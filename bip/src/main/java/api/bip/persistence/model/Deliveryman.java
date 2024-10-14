package api.bip.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Entity
@Table(name = "entregador")
public class Deliveryman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer localizacaoAtualId;
    private Integer telefoneId;
    private Integer enderecoId;
    private Integer statusId;
    private String nome;
    private String chavePix;
    private double taxaRetornoDefault;
    private double taxaDeslocamentoDefault;
    private double taxaEntregadorPorKMDefault;
    private double taxaEntregadorFixaDefault; // Você pode precisar de uma abordagem diferente para persistir isso
    private Integer qtdEntregasRealizadas;
    private Double distanciaDeslocamentoKm;
    private boolean ativo;
    private String urlFoto;
    private String token;
    private Double media;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLocalizacaoAtualId() {
        return localizacaoAtualId;
    }

    public void setLocalizacaoAtualId(Integer localizacaoAtualId) {
        this.localizacaoAtualId = localizacaoAtualId;
    }

    public Integer getTelefoneId() {
        return telefoneId;
    }

    public void setTelefoneId(Integer telefoneId) {
        this.telefoneId = telefoneId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public double getTaxaRetornoDefault() {
        return taxaRetornoDefault;
    }

    public void setTaxaRetornoDefault(double taxaRetornoDefault) {
        this.taxaRetornoDefault = taxaRetornoDefault;
    }

    public double getTaxaDeslocamentoDefault() {
        return taxaDeslocamentoDefault;
    }

    public void setTaxaDeslocamentoDefault(double taxaDeslocamentoDefault) {
        this.taxaDeslocamentoDefault = taxaDeslocamentoDefault;
    }

    public double getTaxaEntregadorPorKMDefault() {
        return taxaEntregadorPorKMDefault;
    }

    public void setTaxaEntregadorPorKMDefault(double taxaEntregadorPorKMDefault) {
        this.taxaEntregadorPorKMDefault = taxaEntregadorPorKMDefault;
    }

    public double getTaxaEntregadorFixaDefault() {
        return taxaEntregadorFixaDefault;
    }

    public void setTaxaEntregadorFixaDefault(double taxaEntregadorFixaDefault) {
        this.taxaEntregadorFixaDefault = taxaEntregadorFixaDefault;
    }

    public Integer getQtdEntregasRealizadas() {
        return qtdEntregasRealizadas;
    }

    public void setQtdEntregasRealizadas(Integer qtdEntregasRealizadas) {
        this.qtdEntregasRealizadas = qtdEntregasRealizadas;
    }

    public Double getDistanciaDeslocamentoKm() {
        return distanciaDeslocamentoKm;
    }

    public void setDistanciaDeslocamentoKm(Double distanciaDeslocamentoKm) {
        this.distanciaDeslocamentoKm = distanciaDeslocamentoKm;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}


