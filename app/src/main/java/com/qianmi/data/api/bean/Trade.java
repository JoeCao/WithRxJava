package com.qianmi.data.api.bean;

import java.util.List;

/**
 * Created by wv on 2015/8/21.
 */
public class Trade {

    public String tid;
    public double payment;
    public double pay_status;
    public String pay_status_display;
    public double deliver_status;
    public String deliver_status_display;
    public double complete_status;
    public String complete_status_display;
    public double total_fee;
    public String applier_nick;
    public String reciver_name;
    public String add_user_name;
    public String sale_user_name;
    public String created;
    public String end_time;
    public String applier_memo;
    public String detail;
    public List<Order> orders;

    @Override
    public String toString() {
        return "Trade{" +
                "tid='" + tid + '\'' +
                ", payment=" + payment +
                ", pay_status_display='" + pay_status_display + '\'' +
                ", deliver_status_display='" + deliver_status_display + '\'' +
                ", complete_status_display='" + complete_status_display + '\'' +
                ", total_fee=" + total_fee +
                ", applier_nick='" + applier_nick + '\'' +
                ", reciver_name='" + reciver_name + '\'' +
                ", add_user_name='" + add_user_name + '\'' +
                ", sale_user_name='" + sale_user_name + '\'' +
                ", created='" + created + '\'' +
                ", end_time='" + end_time + '\'' +
                ", applier_memo='" + applier_memo + '\'' +
                '}';
    }
}
