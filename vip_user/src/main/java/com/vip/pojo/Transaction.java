package com.vip.pojo;

public class Transaction {
    private Integer uid;
    private String goods;
    private Double payment;
    private String way;

    public Transaction() {
    }

    public Transaction(Integer uid, String goods, Double payment, String way) {
        this.uid = uid;
        this.goods = goods;
        this.payment = payment;
        this.way = way;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "uid=" + uid +
                ", goods='" + goods + '\'' +
                ", payment=" + payment +
                ", way='" + way + '\'' +
                '}';
    }
}
