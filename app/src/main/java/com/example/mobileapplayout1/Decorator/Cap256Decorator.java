package com.example.mobileapplayout1.Decorator;


import com.example.mobileapplayout1.my_interface.Decorator;

public class Cap256Decorator extends CapDecorator{
    public Cap256Decorator(Decorator decorator) {
        super(decorator);
    }

    @Override
    public int getProductPrice() {
        return super.getProductPrice() + Cap256Decorator();
    }
    private int Cap256Decorator(){
        return 0;
    }
}
