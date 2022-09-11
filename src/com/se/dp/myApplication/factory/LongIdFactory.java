package com.se.dp.myApplication.factory;

import com.se.dp.myApplication.id.ID;
import com.se.dp.myApplication.id.LongId;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

public  class LongIdFactory implements IDFactory {


    /**
     * 使用时间戳作为种子生成longId。同时加锁防止高并发下的id重复
     * @return
     */

    @Override
    public String info() {
        return "返回Long类型id生成器";
    }

    @Override
    public ID getIdGenarator() {
        return new LongId();
    }
}
