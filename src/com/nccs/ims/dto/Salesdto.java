package com.nccs.ims.dto;
public class Salesdto {

    String Todaydate;
    int SaleId;

    public int getSaleId() {
        return SaleId;
    }

    public void setSaleId(int SaleId) {
        this.SaleId = SaleId;
    }

    public String getTodaydate() {
        return Todaydate;
    }

    public void setTodaydate(String Todaydate) {
        this.Todaydate = Todaydate;
    }
    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public int getRpu() {
        return Rpu;
    }

    public void setRpu(int Rpu) {
        this.Rpu = Rpu;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    int CustomerId,Qty,Rpu,Total;
    String Company,CustomerName,Address,Contact,Product,Status;
    String Date;

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
}
