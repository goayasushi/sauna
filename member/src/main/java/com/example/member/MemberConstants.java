package com.example.member;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class MemberConstants {
	public final Integer GENDER_MAN = 1;
	public final Integer GENDER_WOMAN = 2;
	@SuppressWarnings("serial")
	public final Map<Integer, String> GENDERS = new LinkedHashMap<>() {
		{
			put(GENDER_MAN, "男性");
			put(GENDER_WOMAN, "女性");
		}
	};
}
