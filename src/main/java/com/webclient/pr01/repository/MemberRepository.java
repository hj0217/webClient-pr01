package com.webclient.pr01.repository;

import com.webclient.pr01.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long > {

    @Override
    Optional<Member> findById(Long aLong);
}
