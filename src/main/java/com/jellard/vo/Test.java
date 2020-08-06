package com.jellard.vo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
	
	//根据类型来遍历对象的属性
	public void AllByType(Student model) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	    System.out.println("根据类型来遍历对象的属性");
	    java.lang.reflect.Field[] field = model.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组  
	    for(int j=0 ; j<field.length ; j++){     //遍历所有属性
	            String name = field[j].getName();    //获取属性的名字
	            
	            System.out.println("attribute name:"+name);     
	            name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
	            String type = field[j].getGenericType().toString();    //获取属性的类型
	            if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
	                java.lang.reflect.Method m = model.getClass().getMethod("get"+name);
	                String value = (String) m.invoke(model);    //调用getter方法获取属性值
	                if(value != null){
	                    System.out.println("attribute value:"+value);
	                }
	            }
	            if(type.equals("int")){     
	                java.lang.reflect.Method m = model.getClass().getMethod("get"+name);
	                Integer value = (Integer) m.invoke(model);
	                if(value != null){
	                    System.out.println("attribute value:"+value);
	                }
	            }
	    }
	}

	//将所有的属性转换对象
	public void AllByObject(Student model) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	    System.out.println("将所有的属性转换对象");
	    java.lang.reflect.Field[] field = model.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组  
	    for(int j=0 ; j<field.length ; j++){     //遍历所有属性
	        String name = field[j].getName();    //获取属性的名字
	        System.out.println("attribute name:"+name);     
	        name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
	        java.lang.reflect.Method m = model.getClass().getMethod("get"+name);
	        Object value = (Object) m.invoke(model);    //调用getter方法获取属性值
	        if(value != null){
	            System.out.println("attribute value:"+value.toString());
	        }
	    }
	}

	//get方法
	public void allByGet(Student model) throws Exception{
	    System.out.println("get方法");
	    java.lang.reflect.Field[] flds = model.getClass().getFields();  
	    if ( flds != null ){ 
	        for ( int i = 0; i < flds.length; i++ ){
	        	String fieldName = flds[i].getName();
	        	fieldName = fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
	        	String type = flds[i].getGenericType().toString();
	        	if (type.equals("int")) {
					Method method = model.getClass().getMethod("set"+fieldName,int.class);
					method.invoke(model,18);
				}
	        	if (type.equals("class java.lang.String")) {
					Method method = model.getClass().getMethod("set"+fieldName,String.class);
					method.invoke(model,"hello");
				}
	            System.out.println(flds[i].getName() + " - " + flds[i].get(model));  
	        }  
	    }  
	}
	
	public static void main(String[] args) throws Exception{
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("k", "jellard");
			params.put("age", 20);
			params.put("hello", "world");
			params.put("birthday", new Date());
			Student student = VoUtil.mapToVo(new Student(),params);
			System.out.println(student);
			
			Map<String, Object> params2 = new HashMap<String, Object>();
			params2.put("name", "lalalal");
			params2.put("sex", 1);
			params2.put("salary", "36000");
			params2.put("subject", "English");
			params2.put("score", new BigDecimal(88.75));
			Teacher teacher = VoUtil.mapToVo(new Teacher(),params2);
			System.out.println(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		output.AllByType(model);
//		output.AllByObject(model);
//		output.allByGet(model);
	}

}
