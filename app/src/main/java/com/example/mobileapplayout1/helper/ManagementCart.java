package com.example.mobileapplayout1.helper;

import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

import com.example.mobileapplayout1.CartListActivity;
import com.example.mobileapplayout1.Strategy.Apple;
import com.example.mobileapplayout1.Strategy.Context1;
import com.example.mobileapplayout1.Strategy.Samsung;
import com.example.mobileapplayout1.Strategy.brandSale;
import com.example.mobileapplayout1.model.HotSalePhone;
import com.example.mobileapplayout1.model.Products;
import com.example.mobileapplayout1.my_interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Button buy;
    private Context context;
    private CheckDB checkDB;
    private CartListActivity cartListActivity;

    brandSale brandsale;
    public ManagementCart(Context context) {
        this.context = context;
        this.checkDB = new CheckDB(context);
    }
    public void insertProduct(HotSalePhone item){
        ArrayList<HotSalePhone> listProduct=getListCart();
        boolean existAlready = false;
        int n= 0;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductName().equals(item.getProductName())){
                existAlready = true;
                n=i;
                break;
            }
        }
        if(existAlready){
            listProduct.get(n).setNumProduct(item.getNumProduct());
        } else {
            listProduct.add(item);
        }

        checkDB.putListObject("CartList",listProduct);
        Toast.makeText(context, "Sản phẩm đã được thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
    }
    public void insertProducts(Products item){
        ArrayList<Products> listProduct=getListCartPrd();
        boolean existAlready = false;
        int n= 0;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductName().equals(item.getProductName())){
                existAlready = true;
                n=i;
                break;
            }
        }
        if(existAlready){
            listProduct.get(n).setNumProduct(item.getNumProduct());
        } else {
            listProduct.add(item);
        }

        checkDB.putListProduct("CartList",listProduct);
        Toast.makeText(context, "Sản phẩm đã được thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<HotSalePhone> getListCart(){
        return checkDB.getListObject("CartList");
    }
    public ArrayList<Products> getListCartPrd(){
        return checkDB.getListProduct("CartList");
    }
    public void plusNumberProduct(ArrayList<HotSalePhone> listProduct, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listProduct.get(position).setNumProduct(listProduct.get(position).getNumProduct()+1);
        checkDB.putListObject("CartList",listProduct);
        changeNumberItemsListener.changed();
    }

    public void minusNumberProduct(ArrayList<HotSalePhone> listProduct, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if (listProduct.get(position).getNumProduct()==1){
            listProduct.get(position).setNumProduct(1);
        }else {
            listProduct.get(position).setNumProduct(listProduct.get(position).getNumProduct()-1);
        }
        checkDB.putListObject("CartList",listProduct);
        changeNumberItemsListener.changed();
    }
    public void deleteProduct(ArrayList<HotSalePhone> listProduct, int position, ChangeNumberItemsListener changeNumberItemsListener){
        String namePrd = listProduct.get(position).getProductName();
        listProduct.remove(position);
        checkDB.putListObject("CartList",listProduct);
        Toast.makeText(context, "Đã xóa sản phẩm: "+namePrd, Toast.LENGTH_SHORT).show();
        changeNumberItemsListener.changed();
    }
    public double getSaleItem(){
        ArrayList<HotSalePhone> listProduct2 = getListCart();

        double totalSale = 0.0;
        for (int i = 0; i < listProduct2.size() ; i++) {
            if (listProduct2.get(i).getBrand().equals("Samsung")) {
                Context1 context1 = new Context1(new Samsung());
                totalSale +=(listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct())-  context1.excuteSale(listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct());
//                totalitem = (listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct());
            }
            else if (listProduct2.get(i).getBrand().equals("Apple")){
                Context1 context1 = new Context1(new Apple());
                totalSale +=(listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct())- context1.excuteSale(listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct());
            }


        }
        return totalSale;
    }
    public double getTotalItem(){

        ArrayList<HotSalePhone> listProduct2 = getListCart();

        double totalitem = 0.0;
        for (int i = 0; i < listProduct2.size() ; i++) {
            if (listProduct2.get(i).getBrand().equals("Samsung")) {
                Context1 context1 = new Context1(new Samsung());
                totalitem += context1.excuteSale(listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct());
//                totalitem = (listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct());
            }
            else if (listProduct2.get(i).getBrand().equals("Apple")){
                Context1 context1 = new Context1(new Apple());
                totalitem += context1.excuteSale(listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct());
            }
            else {
                totalitem += listProduct2.get(i).getProductPrice() * listProduct2.get(i).getNumProduct();
            }


        }
        return totalitem;
    }

}
