package com.example.member.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.member.domain.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	@Query("SELECT m FROM Member m WHERE " +
	           "(:searchQuery IS NULL OR " +
	           "CAST(m.id AS string) LIKE CONCAT('%', :searchQuery, '%')) OR " +
	           "(m.firstName LIKE CONCAT('%', :searchQuery, '%')) OR " +
	           "(m.lastName LIKE CONCAT('%', :searchQuery, '%'))")
	    List<Member> searchMembers(@Param("searchQuery") String searchQuery);
}
