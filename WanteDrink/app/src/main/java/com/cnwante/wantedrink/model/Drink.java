package com.cnwante.wantedrink.model;

/**
 * Created by Administrator on 2016/7/30 0030.
 */
public class Drink {
    private int id;
    private String drinkName;
    private String price;
    private String pic;

    public Drink(int id, String drinkName, String price, String pic) {
        setId(id);
        setDrinkName(drinkName);
        setPrice(price);
        setPic(pic);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getPic() {
        return pic;
    }

}
