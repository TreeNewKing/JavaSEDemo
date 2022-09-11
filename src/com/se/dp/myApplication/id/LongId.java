package com.se.dp.myApplication.id;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class LongId implements ID{
    private  static  AtomicLong id;
    @Override
    public  synchronized   Long getID(){
        Long time=Long.valueOf(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()))*1000;
        if (id==null){
            id=new AtomicLong(time);
            return id.get();
        }
        if (time<=id.get()){
            id.addAndGet(1);
        }else {
            id=new AtomicLong(time);
        }
        return id.get();
    }
}
