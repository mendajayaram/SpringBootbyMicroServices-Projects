package com.nt.jai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.model.StockQuote;
import com.nt.jai.producer.ProducerService;
import com.nt.jai.service.MessageStoreService;
@RestController
@RequestMapping("/api/quote")
public class StockQuoteRestController {

	@Autowired
	private ProducerService producer;
	@Autowired
	private MessageStoreService storeService;
	//1. send StockQuote
	@PostMapping("/create")
	public ResponseEntity<String> createStockQuote(
	@RequestBody StockQuote stockQuote)
	{
	producer.sendData(stockQuote);
	return ResponseEntity.ok("Quote Data is sent!");
	}
	//2. view all received
	@GetMapping("/all")
	public ResponseEntity<List<StockQuote>> getAllQoutes() {
	List<StockQuote> list =
	storeService.getAllStockQuotes();
	return ResponseEntity.ok(list);
	}
	
}
