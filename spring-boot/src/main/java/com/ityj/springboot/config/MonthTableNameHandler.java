package com.ityj.springboot.config;

import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * 按月份参数，组成动态表名
 */
public class MonthTableNameHandler implements TableNameHandler {

    //用于记录哪些表可以使用该月份动态表名处理器（即哪些表按月分表）
    private List<String> tableNames;
    //构造函数，构造动态表名处理器的时候，传递tableNames参数
    public MonthTableNameHandler(String ...tableNames) {
        this.tableNames = Arrays.asList(tableNames);
    }

    //每个请求线程维护一个month数据，避免多线程数据冲突。所以使用ThreadLocal
    private static final ThreadLocal<String> MONTH_DATA = new ThreadLocal<>();
    //设置请求线程的month数据
    public static void setData(String month) {
        MONTH_DATA.set(month);
    }
    //删除当前请求线程的month数据
    public static void removeData() {
        MONTH_DATA.remove();
    }

    //动态表名接口实现方法
    @Override
    public String dynamicTableName(String sql, String tableName) {
        if (this.tableNames.contains(tableName)){
            if (MONTH_DATA.get()==null)
            {
                LocalDate date = LocalDate.now();
                return tableName + "_" + date.format(DateTimeFormatter.ofPattern("yyyyMM"));  //表名增加月份后缀
            }
            return tableName + "_" + MONTH_DATA.get();  //表名增加月份后缀
        }else{
            return tableName;   //表名原样返回
        }
    }
}
