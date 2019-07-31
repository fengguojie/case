package com.jellard.netty;

import java.util.Date;

public class UnixTime {

    private final long value;
    private String name;
    
    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }
    
    public UnixTime(long value) {
        this.value = value;
    }
        
    public long value() {
        return value;
    }
        
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return new Date((value() - 2208988800L) * 1000L).toString()+":"+name;
    }
}
