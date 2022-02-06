package com.anymind.controller;


import com.anymind.model.BTC;
import com.anymind.service.BTCService;
import com.google.gson.GsonBuilder;
import lombok.NonNull;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RequestMapping("/btc")
@Controller
public class BtcController {

    private final BTCService btcService;

    @Autowired
    public BtcController(BTCService btcService) {
        this.btcService = btcService;
    }

    //Handle the empty path page request
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String btcList(Model model) {
        model.addAttribute("btcList", btcService.findAll());
        return "btc/index";
    }

    //this controller method get date range in body and query the database
    @PostMapping(path = "/getInRange", consumes = MediaType.APPLICATION_JSON_VALUE,
                                          produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getBtcListInRange(@RequestBody @NonNull DateRangeDto dateRangeDto) {

        Set<BTC> btcSet;
        btcSet = btcService.getAllByDatetimeBetween(dateRangeDto.getStartDatetime(), dateRangeDto.getEndDatetime());

        if (btcSet.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BTC Not Found in desired date range!");
        }
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create().toJson(btcSet);
    }

    //this controller method will save a new BTC
    @PostMapping(path = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BTC> saveBtc(@RequestBody @NonNull BTC newBtc) {
        BTC btc = btcService.save(newBtc);
        return new ResponseEntity<>(btc, HttpStatus.CREATED);
    }


}