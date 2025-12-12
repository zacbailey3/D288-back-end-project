package com.d288.zacbaileyd288.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Table(name = "excursions")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @JsonProperty("excursion_price")
    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @JsonProperty("excursion_title")
    @Column(name = "excursion_title")
    private String excursion_title;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="vacation_id", nullable = false)
    private Vacation vacation;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date update_date;

    @JsonProperty("image_URL")
    @Column(name = "image_url")
    private String image_URL;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItem;

}
