package com.anymind.controller;


import com.anymind.model.BTC;
import com.anymind.repositories.BtcRepository;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@RequestMapping("/btc")
@Controller
public class BtcController {

    private final BtcRepository btcRepository;

    @Autowired
    public BtcController(BtcRepository btcRepository) {
        this.btcRepository = btcRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String btcList(Model model) {
        model.addAttribute("btcList", btcRepository.findAll());
        return "btc/index";
    }

    @PostMapping(path = "/getInRange",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getBtcListInRange(@RequestBody DateRangeDto dateRangeDto) {

        Set<BTC> btcSet;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        try {
            Date startDatetime = df.parse(dateRangeDto.getStartDatetime());
            Date endDatetime = df.parse(dateRangeDto.getEndDatetime());
            btcSet = btcRepository.getAllByDatetimeBetween(startDatetime, endDatetime);
        } catch (ParseException e) {
            throw new RuntimeException("invalid dateTime format");
        }

        if (btcSet.isEmpty()) {
            throw new RuntimeException("Nothing Found on the desired date range!");
        }
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create().toJson(btcSet);
    }

    @PostMapping(path = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BTC> saveBtc(@RequestBody BTC newBtc) {
        BTC btc = btcRepository.save(newBtc);
        return new ResponseEntity<>(btc, HttpStatus.CREATED);
    }


}