package com.jellard.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.zookeeper.data.Id;

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
//		List<Integer> nums = Arrays.asList(1,2,3,4,5);
//		functionnal(nums);
//		listToArray(nums);
//		System.out.println(StringUtils.join(nums, "|"));
		
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			int grade = new Random().nextInt(100);
			User user = new User(i,"name"+i,new BigDecimal(String.valueOf(grade)));;
			users.add(user);
		}
		//System.out.println(users);
		
		List<User> filterUsers = users.stream()
				      .filter(user -> user.getGrade().intValue() >= 80)
		              .filter(user -> user.getGrade().intValue() <= 90)
		              .sorted(Comparator.comparing(User::getGrade))
		              .collect(Collectors.toList());
		//System.out.println(filterUsers);
		
		BigDecimal average = users.stream()
				      .map(user -> user.getGrade())
		              .reduce(new BinaryOperator<BigDecimal>() {
								@Override
								public BigDecimal apply(BigDecimal var1, BigDecimal var2) {
									return var1.add(var2);
								}
					   }).get().divide(new BigDecimal("100"));
		System.out.println("平均分数："+average);
		
		Map<Long, User> userMap = users.stream().collect(Collectors.toMap(User::getId, user->user));
		System.out.println(userMap);
		List<Long> userIds = new ArrayList<>(userMap.keySet());
		Long userId = userIds.stream().filter(id -> id.longValue()==2).findAny().orElse(null);
		List<String> userIdsStr = userIds.stream().map(String::valueOf).collect(Collectors.toList());
		System.out.println(userIdsStr);
		
		users.forEach(user -> System.out.println(user));
		users.forEach(user -> {
			BigDecimal grade = user.getGrade();
			grade.add(new BigDecimal("10"));
			user.setGrade(grade);
			System.out.println(user);
		});
	}

}

class User {
	
	long id;
	String name;
	BigDecimal grade;
	
	public User() {}
	
	public User(long id,String name,BigDecimal grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getGrade() {
		return grade;
	}
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("编号:").append(id)
				   .append("|姓名:").append(name)
				   .append("|成绩:").append(grade).toString();
	}

}
