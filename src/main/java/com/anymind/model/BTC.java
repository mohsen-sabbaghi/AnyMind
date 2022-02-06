package com.anymind.model;


import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NonNull;
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
    @NonNull
    private Date datetime;

    @Column(name = "amount")
    @Expose
    @NonNull
    private Float amount;

}
