package com.example.removebg.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name= "tbh_orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique =true)
    private String orderId;

    private String clerkId;

    private String plan;

    private Double amount;

    private Integer credits;

    private Boolean payment;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @PrePersist
    public void prePersist(){
        if(payment=null){
            payment=false;
        }
    }

    public OrderEntity() {
    }

    public OrderEntity(Long id, String orderId, String clerkId, String plan, Double amount, Integer credits, Boolean payment, Timestamp createdAt) {
        this.id = id;
        this.orderId = orderId;
        this.clerkId = clerkId;
        this.plan = plan;
        this.amount = amount;
        this.credits = credits;
        this.payment = payment;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClerkId() {
        return clerkId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public static class Builder {
        private Long id;
        private String orderId;
        private String clerkId;
        private String plan;
        private Double amount;
        private Integer credits;
        private Boolean payment;
        private Timestamp createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder clerkId(String clerkId) {
            this.clerkId = clerkId;
            return this;
        }

        public Builder plan(String plan) {
            this.plan = plan;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder credits(Integer credits) {
            this.credits = credits;
            return this;
        }

        public Builder payment(Boolean payment) {
            this.payment = payment;
            return this;
        }

        public Builder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public OrderEntity build() {
            return new OrderEntity(id, orderId, clerkId, plan, amount, credits, payment, createdAt);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
