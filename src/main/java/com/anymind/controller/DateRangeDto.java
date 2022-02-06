package com.anymind.controller;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class DateRangeDto {
    private String startDatetime;
    private String endDatetime;
}
