package com.vip.pojo;
//积分台账
public class Bill {
    private String date;
    private Integer point;
    private String reason;
    private Integer uid;

    public Bill() {
    }

    public Bill(String date, Integer point, String reason, Integer uid) {
        this.date = date;
        this.point = point;
        this.reason = reason;
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "date='" + date + '\'' +
                ", point=" + point +
                ", reason='" + reason + '\'' +
                ", uid=" + uid +
                '}';
    }
}
