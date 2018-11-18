
package com.nccs.ims.dto;

import java.util.Date;


public class Itemdto {

    String Todaydate;
    int PurchaseId;
    int Total;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    public int getPurchaseId() {
        return PurchaseId;
    }

    public void setPurchaseId(int PurchaseId) {
        this.PurchaseId = PurchaseId;
    }

    public String getTodaydate() {
        return Todaydate;
    }

    public void setTodaydate(String Todaydate) {
        this.Todaydate = Todaydate;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int Rate) {
        this.Rate = Rate;
    }
    String Name,Supplier;
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
   int Id,Quantity,Rate;
    
}
