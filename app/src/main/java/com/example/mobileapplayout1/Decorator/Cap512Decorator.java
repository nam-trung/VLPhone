package com.example.mobileapplayout1.Decorator;


import com.example.mobileapplayout1.my_interface.Decorator;

public class Cap512Decorator extends CapDecorator{
    public Cap512Decorator(Decorator decorator) {
        super(decorator);
    }

    @Override
    public int getProductPrice() {
        return super.getProductPrice() + Cap512Decorator();
    }
    private int Cap512Decorator(){
        return 1000000;
    }
}
