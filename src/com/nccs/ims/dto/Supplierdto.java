
package com.nccs.ims.dto;


public class Supplierdto {

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public String getContact(){
        return Contact;
    }
    public void setContact(String Contact){
        this.Contact=Contact;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }
    int Id;
    String Name;
    String Item;
    String Contact;
    int Rpu;

    public int getRpu() {
        return Rpu;
    }

    public void setRpu(int Rpu) {
        this.Rpu = Rpu;
    }

   
 }
