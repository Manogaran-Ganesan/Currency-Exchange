package com.in28mints.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment environment;

	@Autowired
	CurrencyExchangeDao currencyExchangeDao;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeBean retriveCurrency(@PathVariable String from, @PathVariable String to) {

		String port = environment.getProperty("local.server.port");

		CurrencyExchangeBean currencyExchangeBean = currencyExchangeDao.findByFromAndTo(from, to);

		if (currencyExchangeBean == null) {

			throw new RuntimeException("unable to find from :" + from + " and to :" + to);
		}

		currencyExchangeBean.setEnvironment(port);

		return currencyExchangeBean;

	}

}
