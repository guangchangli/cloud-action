package com.aladdin.cloud.common.util;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author lgc
 **/
public class DozerUtil {

    static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    /**
     * bean copy
     * @param sourceList beanList
     * @param destinationClass dto
     * @param <T> T
     * @return new bean list
     */
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List destList = Lists.newArrayList();
        for (Iterator iterator = sourceList.iterator(); iterator.hasNext(); ) {
            Object sourceObj = iterator.next();
            Object destObj = dozerBeanMapper.map(sourceObj, destinationClass);
            destList.add(destObj);
        }
        return destList;
    }

}
