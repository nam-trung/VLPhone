//package com.example.mobileapplayout1.helper;
//
//import com.example.mobileapplayout1.model.HotSalePhone;
//
//
//import android.content.Context;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.example.mobileapplayout1.CartListActivity;
//import com.example.mobileapplayout1.model.HotSalePhone;
//import com.example.mobileapplayout1.model.Products;
//import com.example.mobileapplayout1.my_interface.ChangeNumberItemsListener;
//
//import java.util.ArrayList;
//
//
//public class applePhone implements brandSale {
//
//    private CheckDB checkDB;
//
//    public ArrayList<HotSalePhone> getListCart() {
//        return checkDB.getListObject("CartList");
//    }
//
//    public double getSaleBrand(ArrayList<HotSalePhone> listProducts) {
//        ArrayList<HotSalePhone> listProduct2 = getListCart();
//        double totalitem = 0.0;
//
//        for (int i = 0; i < listProduct2.size(); i++) {
//            totalitem = totalitem + ((listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct() - ((listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct()) * 0.1)));
//        }
//        return totalitem;
//    }
//}
//
