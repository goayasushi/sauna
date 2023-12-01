package com.example.member;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class AccountConstants {
//	public final Integer GENDER_MAN = 1;
//	public final Integer GENDER_WOMAN = 2;
	@SuppressWarnings("serial")
	public final Map<String, String>  ROLES = new LinkedHashMap<>() {
		{
			put("ADMIN", "管理者");
			put("USER", "一般");
		}
	};
}
