package com.example.member.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.member.domain.model.Prefecture;
import com.example.member.domain.repository.PrefectureRepository;

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
