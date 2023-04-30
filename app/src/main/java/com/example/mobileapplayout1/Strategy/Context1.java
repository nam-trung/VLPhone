package com.example.mobileapplayout1.Strategy;

public class Context1 {
    private brandSale brandsale;

    public Context1(brandSale brandsale){
        this.brandsale = brandsale;
    }

    public double excuteSale(double mount){
        return brandsale.getSaleBrand(mount);
    }
}
