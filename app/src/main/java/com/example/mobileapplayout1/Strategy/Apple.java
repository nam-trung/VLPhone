package com.example.mobileapplayout1.Strategy;

public class Apple implements brandSale{
    private double percentDisccount = 0.1;
    @Override
    public double getSaleBrand(double mount){
        mount = mount - (mount * percentDisccount);
        return mount;
    }
}
