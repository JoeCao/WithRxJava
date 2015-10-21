package com.qianmi.data.api.bean;

import java.io.Serializable;

/**
 * Created by caozupeng on 15/8/31.
 */
public class Batch implements Serializable {
    public int id;
    public int down_rows;
    public int add_rows;
    public int update_rows;
    public String created;

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", down_rows=" + down_rows +
                ", add_rows=" + add_rows +
                ", update_rows=" + update_rows +
                ", created='" + created + '\'' +
                '}';
    }
}
