package com.example.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.member.domain.model.Prefecture;
import com.example.member.domain.repository.PrefectureRepository;
import com.example.member.domain.service.PrefectureService;

public class PrefectureServiceTest {

	@Mock
	private PrefectureRepository prefectureRepository;

	private PrefectureService prefectureService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		prefectureService = new PrefectureService(prefectureRepository);
	}

	@Test
	void findAllShouldReturnAllPrefectures() {
		List<Prefecture> mockPrefectures = Arrays.asList(
			    createPrefecture(1, "Hokkaido"),
			    createPrefecture(2, "Tokyo"),
			    createPrefecture(3, "Osaka")
			);

		when(prefectureRepository.findAll()).thenReturn(mockPrefectures);

		List<Prefecture> result = prefectureService.findAll();

		assertEquals(3, result.size());
	}
	
	private Prefecture createPrefecture(int id, String name) {
	    Prefecture prefecture = new Prefecture();
	    prefecture.setId(id);
	    prefecture.setName(name);
	    return prefecture;
	}
}
