package com.d288.zacbaileyd288.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "vacations")
@Entity
@Getter
@Setter

public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @JsonProperty("vacation_title")
    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    @JsonProperty("travel_price")
    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @JsonProperty("image_URL")
    @Column(name = "image_url")
    private String image_URL;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date update_date;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private Set<Excursion> excursions = new HashSet<>();


}
