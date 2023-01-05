package com.example.oldguy.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
 * @author ZZQ
 * @Date 2022/12/1 3:35 下午
 */
public class CopyUtil {
    public static <F, T> List<T> copyList(final Collection<F> sources, final Class<T> clazz) {
        if (sources == null) {
            return new ArrayList(0);
        } else {
            List<T> list = new ArrayList(sources.size());
            Iterator var3 = sources.iterator();

            while(var3.hasNext()) {
                Object source = var3.next();

                try {
                    T dest = clazz.newInstance();
                    BeanUtils.copyProperties(source, dest);
                    list.add(dest);
                } catch (Throwable var6) {
                }
            }
            return list;
        }
    }

}
