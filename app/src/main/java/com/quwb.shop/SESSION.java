package com.quwb.shop;

import com.external.activeandroid.Model;
import com.external.activeandroid.annotation.Column;
import com.external.activeandroid.annotation.Table;

@Table(name = "SESSION")
public class SESSION extends Model {
    @Column(name = "uid")
    public int uid ;

    @Column(name = "sid")
    public String sid;

    public static SESSION instance;
    public static SESSION getInstance() {
        if (instance == null) {
            instance = new SESSION();
        }
        return instance;
    }
}
