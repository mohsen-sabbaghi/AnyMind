package com.anymind.bootstrap;

import com.anymind.model.BTC;
import com.anymind.repositories.BtcRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class DataLoader implements CommandLineRunner {

    private final BtcRepository btcRepository;

    @Autowired
    public DataLoader(BtcRepository btcRepository) {
        this.btcRepository = btcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (btcRepository.count() == 0) {
            loadDemoData();
        }
    }

    private void loadDemoData() {

        BTC btc00 = new BTC();
        btc00.setAmount(1.01f);
        btc00.setDatetime(new DateTime("2011-10-05T10:48:01+00:00").toDate());
        btcRepository.save(btc00);

        BTC btc01 = new BTC();
        btc01.setAmount(5.04f);
        btc01.setDatetime(new DateTime("2011-10-05T10:48:01+00:00").plusHours(1).toDate());
        btcRepository.save(btc01);

        BTC btc02 = new BTC();
        btc02.setAmount(0.0005f);
        btc02.setDatetime(new DateTime().toDate());
        btcRepository.save(btc02);

        BTC btc03 = new BTC();
        btc03.setAmount(0.03f);
        btc03.setDatetime(new DateTime().plusHours(1).toDate());
        btcRepository.save(btc03);

        BTC btc04 = new BTC();
        btc04.setAmount(20f);
        btc04.setDatetime(new DateTime().plusHours(2).toDate());
        btcRepository.save(btc04);
    }
}
