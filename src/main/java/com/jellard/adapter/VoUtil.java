package com.jellard.adapter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.elasticsearch.common.lang3.ObjectUtils.Null;

public class VoUtil<T> {
	
	public static <T> T mapToVo(T t, Map<String, Object> params) throws Exception {
		Field[] fields = t.getClass().getFields();
		if (fields == null || fields.length > 0) {
			String fieldName,methodName;
			for (Field field : fields) {
				fieldName = field.getName();
				methodName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
				Method method = null;
				String fieldType = field.getGenericType().toString();
				if (fieldType.equals("int")) {
					method = t.getClass().getMethod(methodName,int.class);
				}
				if (fieldType.equals("long")) {
					method = t.getClass().getMethod(methodName,long.class);
				}
				if (fieldType.equals("float")) {
					method = t.getClass().getMethod(methodName,float.class);
				}
				if (fieldType.equals("double")) {
					method = t.getClass().getMethod(methodName,double.class);
				}
				if (fieldType.equals("class java.lang.Integer")) {
					method = t.getClass().getMethod(methodName,Integer.class);
				}
				if (fieldType.equals("class java.lang.Long")) {
					method = t.getClass().getMethod(methodName,Long.class);
				}
				if (fieldType.equals("class java.lang.Float")) {
					method = t.getClass().getMethod(methodName,Float.class);
				}
				if (fieldType.equals("class java.lang.Double")) {
					method = t.getClass().getMethod(methodName,Double.class);
				}
				if (fieldType.equals("class java.lang.String")) {
					method = t.getClass().getMethod(methodName,String.class);
				}
				if (fieldType.equals("class java.util.Date")) {
					method = t.getClass().getMethod(methodName,Date.class);
				}
				if (fieldType.equals("class java.math.BigDecimal")) {
					method = t.getClass().getMethod(methodName,BigDecimal.class);
				}
				if (method != null) {
					if (params.get(fieldName) == null) {
						continue;
					}
					method.invoke(t, params.get(fieldName));
				}else {
					throw new Exception("unsupported type");
				}
			}
		}
		return t;
	}

}
