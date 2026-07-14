package com.example.removebg.dto;


import java.util.Date;

public class RazorpayOrderDTO {

    private String id;
    private String entity;

    private Integer amount;

    private String currency;

    private String status;

    private Date created_at;

    private String receipt;

    public RazorpayOrderDTO() {
    }

    public RazorpayOrderDTO(String id, String entity, Integer amount, String currency, String status, Date created_at, String receipt) {
        this.id = id;
        this.entity = entity;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.created_at = created_at;
        this.receipt = receipt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public static class Builder {
        private String id;
        private String entity;
        private Integer amount;
        private String currency;
        private String status;
        private Date created_at;
        private String receipt;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder entity(String entity) {
            this.entity = entity;
            return this;
        }

        public Builder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder createdAt(Date created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder receipt(String receipt) {
            this.receipt = receipt;
            return this;
        }

        public RazorpayOrderDTO build() {
            return new RazorpayOrderDTO(id, entity, amount, currency, status, created_at, receipt);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
