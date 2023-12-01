package com.webclient.pr01.service;

import com.webclient.pr01.domain.Member;
import com.webclient.pr01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository repository;

    //전체 목록 조회
    public Optional<List<Member>> findList() {
        return Optional.of(repository.findAll());
    }

    //Id로 조회
    public Optional<Member> findById(Long id) {
        return repository.findById(id);

    }

    //등록
    public Member save(Member member) {
        return repository.save(member);
    }

    //수정
    //


    //삭제
    public void deleteById(Long id) {
       repository.deleteById(id);
    }

}
