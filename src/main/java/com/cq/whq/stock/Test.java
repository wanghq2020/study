package com.cq.whq.stock;

import java.util.*;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 20:44
 */
public class Test {
    private static List<Data> dataList = new ArrayList<Data>();

    public static void main(String[] args) {

        List<Data> list = new ArrayList<>();
        list.add(new Data(1L,1L,1L,"REL",50L,"INSERT","buy"));
        list.add(new Data(2L,2L,1L,"ITC",40L,"INSERT","sell"));
        list.add(new Data(3L,3L,1L,"INF",70L,"INSERT","buy"));
        list.add(new Data(4L,1L,2L,"REL",60L,"UPDATE","buy"));
        list.add(new Data(5L,2L,2L,"ITC",30L,"CANCEL","buy"));
        list.add(new Data(6L,4L,1L,"INF",20L,"INSERT","sell"));


        for (Data d : list) {
            System.out.println(addRecord(d));
        }

    }

    private static String addRecord(Data d){
        dataList.add(d);
        // 排序
        dataList.sort((a,b) -> Long.valueOf(a.getTransactionID() - b.getTransactionID()).intValue());

        Map<String,Long> ret = new HashMap<String,Long>(16);

        for (Data data : dataList) {
            if(ret.containsKey(data.getSecurityCode())){
                Long retVal = ret.get(data.getSecurityCode());
                switch (data.getOption()){
                    case "INSERT":
                        retVal = retVal + getVal(data.getCalc(),data.getQuantity());
                        break;
                    case "UPDATE":
                        retVal =  getVal(data.getCalc(),data.getQuantity());
                        break;
                    case "CANCEL":
                        retVal = 0L;
                        break;
                    default:
                        break;
                }
                ret.put(data.getSecurityCode(),retVal);
            } else {
                Long defVal = 0L;
                switch (data.getOption()){
                    case "INSERT":
                    case "UPDATE":
                        defVal = getVal(data.getCalc(),data.getQuantity());
                        break;
                    case "CANCEL":
                        break;
                    default:
                        break;
                }
                ret.put(data.getSecurityCode(),defVal);
            }
        }

        return format(ret);
    }

    private static Long getVal(String calc,Long val){
        return "buy".equals(calc) ? val : val * -1;
    }


    private static String format(Map<String,Long> ret){
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Long>> entries = ret.entrySet();
        Iterator<Map.Entry<String, Long>> iterator = entries.iterator();
        int index = 0;
        while (iterator.hasNext()){
            Map.Entry<String, Long> next = iterator.next();
            if(index != 0){
                sb.append(" and ");
            }
            sb.append(next.getKey());
            sb.append(" = ");
            sb.append(next.getValue());
            index ++;
        }

        return sb.toString();
    }
}
