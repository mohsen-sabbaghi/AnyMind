package com.anymind.model;


import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "btc")
@Getter
@Setter
@ToString
public class BTC extends BaseEntity {

    @Column(name = "datetime")
    @Expose
    private Date datetime;

    @Column(name = "amount")
    @Expose
    private Float amount;

}
