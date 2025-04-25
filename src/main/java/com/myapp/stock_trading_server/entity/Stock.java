package com.myapp.stock_trading_server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_symbol", nullable = false, length = 10)
    private String stockSymbol;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "last_updated", insertable = false, updatable = false)
    private LocalDateTime lastUpdated;

}
