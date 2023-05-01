package com.example.mobileapplayout1.Decorator;

import com.example.mobileapplayout1.my_interface.Decorator;

public class GoldDecorator extends ColorDecorator{
    public GoldDecorator(Decorator decorator) {
        super(decorator);
    }

    @Override
    public int getProductPrice() {
        return super.getProductPrice() + GoldDecorator();
    }

    private int GoldDecorator(){
        return 500000;
    }
}
