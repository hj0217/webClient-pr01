package com.webclient.pr01.controller;

import com.webclient.pr01.domain.Member;
import com.webclient.pr01.exceptionHandler.ResourceNotFoundException;
import com.webclient.pr01.repository.MemberRepository;
import com.webclient.pr01.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping (value = "/api/v1")
public class MemberController {

    private final MemberService service;
    private final MemberRepository repository;


    @GetMapping(value = "/GET")
    public List<Member> get() {
        Optional<List<Member>> optionalList = service.findList();
        return optionalList.orElse(Collections.emptyList());
    }

    @GetMapping(value = "/GET/{id}")
    public Optional<Member> getById(@PathVariable(value ="id")Long id) {
        return service.findById(id);
    }


    @PostMapping(value = "/POST")
    public Member post(@RequestBody Member member) {
        return service.save(member);
    }




    @PutMapping(value = "/PUT/{id}")
    public Member updateById(@PathVariable(value ="id") Long id,
                             @RequestBody Member memberDetails) {
        Member member = service.findById(id).orElseThrow();
                member.setUserid(memberDetails.getUserid());
                member.setPw(memberDetails.getPw());

        final Member updateById = service.save(member);
        return updateById;
    }

    @DeleteMapping(value = "/DELETE/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id)  {

            Member member = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

            service.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }



}
