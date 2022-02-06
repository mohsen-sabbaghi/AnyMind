package com.anymind.repositories;

import com.anymind.model.BTC;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Set;


public interface BtcRepository extends CrudRepository<BTC, Long> {

    // this method will query all the BTCs Between specific dates
    Set<BTC> getAllByDatetimeBetween(Date startDate, Date endDate);
}
