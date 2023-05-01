package com.example.mobileapplayout1.Decorator;

import com.example.mobileapplayout1.my_interface.Decorator;

public abstract class ColorDecorator implements Decorator {
    private Decorator decorator;
    public ColorDecorator(Decorator decorator){
        this.decorator = decorator;
    }
    @Override
    public int getProductPrice() {
        return decorator.getProductPrice();
    }
}
