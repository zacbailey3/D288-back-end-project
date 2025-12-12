package com.d288.zacbaileyd288.controller;

import com.d288.zacbaileyd288.services.CheckoutService;
import com.d288.zacbaileyd288.services.Purchase;
import com.d288.zacbaileyd288.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }


}
