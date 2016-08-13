package com.ai.bot.common.base;

import com.ai.message.actor.Creator;

public abstract class CreatorBase<T> implements Creator<T> {

	private static final long serialVersionUID = -4091305484503508194L;
	
	private String id = "";
	
	public CreatorBase(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
