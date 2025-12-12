package com.d288.zacbaileyd288.services;

import com.d288.zacbaileyd288.dao.CartItemRepository;
import com.d288.zacbaileyd288.dao.CartRepository;
import com.d288.zacbaileyd288.dao.CustomerRepository;
import com.d288.zacbaileyd288.entities.Cart;
import com.d288.zacbaileyd288.entities.CartItem;
import com.d288.zacbaileyd288.entities.Customer;
import com.d288.zacbaileyd288.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


@Service
public class CheckoutServiceImpl implements CheckoutService {


    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //FIX FOR non-populating tracking number
        //setting to null to populate purchase response
        Cart cart = purchase.getCart();
        if (cart.getId() != null && cart.getId() == 0) {
            cart.setId(null);
        }

        String orderTrackingNumber = generateOrderTrackingNumber();

        Set<CartItem> cartItems = purchase.getCartItems();

        cart.setOrderTrackingNumber(orderTrackingNumber);

        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.add(item);
        });

        cart.setStatus(StatusType.ordered);

        Customer customer = purchase.getCustomer();

        //FIX FOR non-populating tracking number
        //setting to null to populate purchase response
        if (customer.getId() != null && customer.getId() == 0) {
            customer.setId(null);
        }

        customer.add(cart);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // random UUID
        return UUID.randomUUID().toString();
    }
}
