package com.example.member;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PrefectureService {
	private final PrefectureRepository prefectureRepository;

	public PrefectureService(PrefectureRepository prefectureRepository) {
		this.prefectureRepository = prefectureRepository;
	}

	public List<Prefecture> findAll() {
		return prefectureRepository.findAll();
	}

}
