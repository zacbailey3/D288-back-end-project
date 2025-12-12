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

@Table(name = "countries")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long id;

    @JsonProperty("country_name")
    @Column(name = "country", nullable = false)
    private String country_name;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private Date update_date;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Division> divisions = new HashSet<>();


}
