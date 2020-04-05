package com.jellard.common;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class StreamUtil {
	
	private Integer version = 1;
	
	public static void functionnal(List<Integer> nums) {
		Predicate<Integer> pridicate = num -> num > 3;
		List<Integer> filterNum = nums.stream()
				                      .filter(pridicate)
				                      .collect(Collectors.toList());
		System.out.println(filterNum);
		
		Function<Integer, String> function = String::valueOf;
		List<String> numStr = nums.stream().map(function).collect(Collectors.toList());
		System.out.println(numStr);
		
		Supplier<StreamUtil> supplier = StreamUtil::new;
		StreamUtil util = supplier.get();
		System.out.println(util.version);
				
		Consumer<StreamUtil> consumer = (s) -> System.out.println("Hello, " + s.version);
		consumer.accept(new StreamUtil());
	}
	
	public static Integer[] listToArray(List<Integer> list) {
		Integer[] array = list.stream().toArray(Integer[]::new);
		return array;
	} 
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,4,5);
		functionnal(nums);
		
		Integer[] array = listToArray(nums);
		//System.out.println(array);
		
		System.out.println(StringUtils.join(nums, "|"));
		
		System.out.println(RandomStringUtils.random(8, "0123456789qwert"));
		Date day = DateUtils.addDays(new Date(), -1);
		String dayStr = DateFormatUtils.format(day, DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.getPattern());
		System.out.println(dayStr);
		
		/*=====*/
		System.out.println("123");
		
	}
	
	
	

}
