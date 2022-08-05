package com.in28mints.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeDao extends JpaRepository<CurrencyExchangeBean, Integer> {

	CurrencyExchangeBean findByFromAndTo(String from, String to);

}
