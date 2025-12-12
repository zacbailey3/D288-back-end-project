package com.d288.zacbaileyd288.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @JsonProperty("division_name")
    @Column(name = "division")
    private String division_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date update_date;


    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonProperty("country_id")
    @Column(name = "country_id", insertable = false, updatable = false)
    private Long country_id;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private Set<Customer> customers = new HashSet<>();

    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }
}
