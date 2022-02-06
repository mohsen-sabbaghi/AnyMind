package com.anymind.service;

import com.anymind.model.BTC;

import java.util.Date;

public interface BtcService extends CrudService<BTC, Long> {
    BTC findByDate(Date date);
}
