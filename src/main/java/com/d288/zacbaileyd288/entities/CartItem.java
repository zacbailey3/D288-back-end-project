package com.d288.zacbaileyd288.entities;

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
@Getter
@Setter
@Table (name = "cart_items")
@NoArgsConstructor
@AllArgsConstructor

public class CartItem {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "cart_item_id")
private Long id;

@ManyToOne
@JoinColumn(name = "vacation_id")
private Vacation vacation;

@ManyToOne
@JoinColumn(name = "cart_id", nullable = false)
private Cart cart;

@ManyToMany
@JoinTable(
        name = "excursion_cartitem",
        joinColumns = @JoinColumn(name = "cart_item_id"),
        inverseJoinColumns = @JoinColumn(name = "excursion_id")
)
private Set<Excursion> excursions = new HashSet<>();

@Column(name = "create_date", nullable = false)
@CreationTimestamp
private Date create_date;

@Column(name = "last_update", nullable = false)
@UpdateTimestamp
private Date last_update;



}
