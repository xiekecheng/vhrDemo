package com.xiekc.vhr.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-26 00:16
 **/

// @Component
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(s);
        } catch (ParseException e) {

            e.printStackTrace();
        }

        return null;
    }
}
