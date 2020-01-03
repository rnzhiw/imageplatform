package com.zust.itee.util;

import com.zust.itee.dto.PictureDTO;
import com.zust.itee.entity.Tpicture;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 日期格式转换工具类
 *
 * @author ruanzhiwei
 * @date 2019/12/9
 */
public class DateUtil {

    public static String date2string(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static Date string2date(String stringDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(stringDate);
    }


    public static void ListSort(List<Tpicture> list) {
        {    //排序方法
            Collections.sort(list, new Comparator<Tpicture>() {
                @Override
                public int compare(Tpicture o1, Tpicture o2) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        // format.format(o1.getTime()) 表示 date转string类型 如果是string类型就不要转换了
                        Date dt1 = format.parse(format.format(o1.getUploadTime()));
                        Date dt2 = format.parse(format.format(o2.getUploadTime()));
                        // 这是由大向小排序   如果要由小向大转换比较符号就可以
                        if (dt1.getTime() > dt2.getTime()) {
                            return 1;
                        } else if (dt1.getTime() < dt2.getTime()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return 0;
                }

            });
        }
    }



}
