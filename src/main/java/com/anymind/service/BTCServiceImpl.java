package com.anymind.service;

import com.anymind.model.BTC;
import com.anymind.repositories.BtcRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class BTCServiceImpl implements BTCService {

    private final BtcRepository btcRepository;

    @Autowired
    public BTCServiceImpl(BtcRepository btcRepository) {
        this.btcRepository = btcRepository;
    }


    @Override
    public Set<BTC> getAllByDatetimeBetween(String startDate, String endDate) {
        Set<BTC> btcSet;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        try {
            Date startDatetime = df.parse(startDate);
            Date endDatetime = df.parse(endDate);
            btcSet = btcRepository.getAllByDatetimeBetween(startDatetime, endDatetime);
        } catch (ParseException e) {
            throw new RuntimeException("invalid dateTime format");
        }
        return btcSet;
    }


    @Override
    public Set<BTC> findAll() {
        Set<BTC> BTCs = new HashSet<>();
        btcRepository.findAll().forEach(BTCs::add);
        return BTCs;
    }

    @Override
    public BTC findById(Long Id) {
        return btcRepository.findById(Id).orElse(null);
    }

    @Override
    public BTC save(BTC object) {
        return btcRepository.save(object);
    }

    @Override
    public void delete(BTC object) {
        btcRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        btcRepository.deleteById(aLong);
    }
}
