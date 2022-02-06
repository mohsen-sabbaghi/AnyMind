package com.anymind.service;

import com.anymind.model.BTC;

import java.util.Set;

public interface BTCService extends CRUDService<BTC, Long> {
    Set<BTC> getAllByDatetimeBetween(String startDate, String endDate);
}
