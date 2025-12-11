package com.d288.zacbaileyd288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Table(name = "vacations")
@Entity
@Getter
@Setter

public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id", nullable = false)
    private Long id;

    @Column(name = "vacation_title", nullable = false)
    private String vacation_title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "travel_fare_price", nullable = false)
    private BigDecimal travel_price;

    @Column(name = "image_url", nullable = false)
    private String image_URL;

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private Date update_date;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Excursion> excursions;


}
