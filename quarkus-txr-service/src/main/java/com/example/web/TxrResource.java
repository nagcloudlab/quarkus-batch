package com.example.web;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.example.service.TxrService;

@Path("/api/txr")
public class TxrResource {

	@Inject
	TxrService txrService;

	@POST
	public TxrResponse doTxr(@Valid TxrRequest request) {
		txrService.txr(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
		TxrResponse txrResponse = new TxrResponse();
		txrResponse.setMessage("txr success");
		return txrResponse;
	}

}
