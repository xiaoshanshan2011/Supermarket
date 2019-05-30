package com.shan.admin.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: chenjunshan
 * @Date: 19-5-30 下午12:03
 */
public class FiledReplaceUtils {

    /**
     * 如果之不为空则替换
     * @param dto
     * @param dtoParams
     */
    public static void replace(Object dto, Object dtoParams){
        List<FiledBean> filedBeans = getFieldList(dto);
        List<FiledBean> filedBeansParams = getFieldList(dtoParams);
        for (int i = 0; i < filedBeansParams.size(); i++) {
            FiledBean filedBeanParams = filedBeansParams.get(i);
            if (!isEmpty(filedBeanParams)){
                for (int j = 0; j < filedBeans.size(); j++) {
                    FiledBean filedBean = filedBeans.get(j);
                    if (filedBean.getName().equals(filedBeanParams.getName())) {
                        setNewValue(dto, filedBean.getName(), filedBeanParams.getValue(), filedBean.getType());
                        break;
                    }
                }
            }
        }
    }

    private static void setNewValue(Object model, String name, Object newValue, String type){
        try{
            String newName = name.substring(0,1).toUpperCase()+name.substring(1);
            Method m = model.getClass().getMethod("set"+newName, new Class[] {getClassType(type)});
            m.invoke(model,new Object[] {newValue});
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Class getClassType(String type){
        if (type.equals("class java.lang.String"))
            return String.class;
        else if (type.equals("class java.lang.Integer"))
            return Integer.class;
        else if (type.equals("class java.lang.Double"))
            return Double.class;
        else if (type.equals("class java.lang.Short"))
            return Short.class;
        else if (type.equals("class java.lang.Boolean"))
            return Boolean.class;
        else if (type.equals("class java.lang.Long"))
            return Long.class;
        else if (type.equals("class java.lang.Byte"))
            return Byte.class;
        else if (type.equals("class java.util.Date"))
            return Date.class;
        else if (type.equals("class java.math.BigDecimal"))
            return BigDecimal.class;
        return String.class;
    }

    private static boolean isEmpty(FiledBean filedBean){
        if (filedBean.getValue() == null)
            return true;
        else
            return false;
    }

    /**
     * 获取对象的属性返回List
     * @param object
     * @return
     */
    private static List<FiledBean> getFieldList(Object object) {
        List<FiledBean> filedBeans = new ArrayList<>();
        try {
            Field[] field = object.getClass().getDeclaredFields(); //获取实体类的所有属性，返回Field数组
            for (int j = 0; j < field.length; j++) { //遍历所有属性
                String name = field[j].getName(); //获取属性名
                Object value = getFieldValueByName(name, object); //获取属性值
                String type = field[j].getGenericType().toString(); //获取属性的类型
                filedBeans.add(new FiledBean(name, value, type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filedBeans;
    }

    /**
     * 根据属性名获取属性值
     *
     * @param fieldName
     * @param o
     * @return
     */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }
}
