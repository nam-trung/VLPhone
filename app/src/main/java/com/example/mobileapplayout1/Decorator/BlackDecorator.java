package com.example.mobileapplayout1.Decorator;

import com.example.mobileapplayout1.my_interface.Decorator;

public class BlackDecorator extends ColorDecorator{
    public BlackDecorator(Decorator decorator) {
        super(decorator);
    }

    @Override
    public int getProductPrice() {
        return super.getProductPrice() + BlackDecorator();
    }

    private int BlackDecorator(){
        return 0;
    }
}
