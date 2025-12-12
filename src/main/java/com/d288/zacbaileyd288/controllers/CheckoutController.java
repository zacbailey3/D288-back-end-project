package com.d288.zacbaileyd288.controllers;

import com.d288.zacbaileyd288.services.CheckoutService;
import com.d288.zacbaileyd288.services.Purchase;
import com.d288.zacbaileyd288.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchse")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        return checkoutService.placeOrder(purchase);
    }


}
