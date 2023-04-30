package com.example.mobileapplayout1.Strategy;

public class Samsung implements brandSale{
    private double percentDisccount = 0.2;
    @Override
    public double getSaleBrand(double mount){
        mount = mount - (mount*percentDisccount);
        return mount;
    }
}
