package com.d288.zacbaileyd288.services;

import com.d288.zacbaileyd288.entities.Cart;
import com.d288.zacbaileyd288.entities.CartItem;
import com.d288.zacbaileyd288.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;


@Getter
@Setter
public class Purchase {
    private Cart cart;

    private Customer customer;

    private Set<CartItem> cartItems;
}
