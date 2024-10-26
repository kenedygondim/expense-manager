package com.kenedygondim.expense_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_register")
public class ExpenseRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_emissao_nf", length = 50, nullable = false)
    private String dataEmissaoNf;
    @Column(name = "cnpjEmitenteNf", length = 14)
    private String cnpjEmitenteNf;
    @Column(name = "nome_emitente_nf", length = 255, nullable = false)
    private String nomeEmitenteNf;
    @Column(name = "nome_produto", length = 255 ,nullable = false)
    private String nomeProduto;
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "valor_produto", nullable = false)
    private Double valorProduto;
    @Column(name = "valor_descontos", nullable = false)
    private Double valorDescontos;
    @Column(name = "valor_impostos", nullable = false)
    private Double valorImpostos;
    @Column(name = "nome_transportadora", length = 50, nullable = false)
    private String nomeTransportadora;

    public ExpenseRegister(Integer id, String dataEmissaoNf, String cnpjEmitenteNf, String nomeEmitenteNf, String nomeProduto, Integer quantidade, Double valorProduto, Double valorDescontos, Double valorImpostos, String nomeTransportadora) {
        this.id = id;
        this.dataEmissaoNf = dataEmissaoNf;
        this.cnpjEmitenteNf = cnpjEmitenteNf;
        this.nomeEmitenteNf = nomeEmitenteNf;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorProduto = valorProduto;
        this.valorDescontos = valorDescontos;
        this.valorImpostos = valorImpostos;
        this.nomeTransportadora = nomeTransportadora;
    }

    public ExpenseRegister() {
        this.dataEmissaoNf = "";
        this.cnpjEmitenteNf = "";
        this.nomeEmitenteNf = "";
        this.nomeProduto = "";
        this.quantidade = 1;
        this.valorProduto = 0.0;
        this.valorImpostos = 0.0;
        this.nomeTransportadora = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpjEmitenteNf() {
        return cnpjEmitenteNf;
    }

    public void setCnpjEmitenteNf(String cnpjEmitenteNf) {
        this.cnpjEmitenteNf = cnpjEmitenteNf;
    }

    public String getNomeEmitenteNf() {
        return nomeEmitenteNf;
    }

    public void setNomeEmitenteNf(String nomeEmitenteNf) {
        this.nomeEmitenteNf = nomeEmitenteNf;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Double getValorImpostos() {
        return valorImpostos;
    }

    public void setValorImpostos(Double valorImpostos) {
        this.valorImpostos = valorImpostos;
    }

    public String getNomeTransportadora() {
        return nomeTransportadora;
    }

    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public String getDataEmissaoNf() {
        return dataEmissaoNf;
    }

    public void setDataEmissaoNf(String dataEmissaoNf) {
        this.dataEmissaoNf = dataEmissaoNf;
    }

    public Double getValorDescontos() {
        return valorDescontos;
    }

    public void setValorDescontos(Double valorDescontos) {
        this.valorDescontos = valorDescontos;
    }

    @Override
    public String toString() {
        return "XmlInfo{" +
                "id='" + id + '\'' +
                ", dataEmissaoNf='" + dataEmissaoNf + '\'' +
                ", cnpjEmitenteNf='" + cnpjEmitenteNf + '\'' +
                ", nomeEmitenteNf='" + nomeEmitenteNf + '\'' +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", quantidade=" + quantidade +
                ", valorProduto=" + valorProduto +
                ", valorImpostos=" + valorImpostos +
                ", nomeTransportadora='" + nomeTransportadora + '\'' +
                '}';
    }


}
