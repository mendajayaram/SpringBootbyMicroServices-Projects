package com.nt.jai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.jai.model.StockQuote;

public interface StockQuoteRepository extends JpaRepository<StockQuote, Integer> {

}
