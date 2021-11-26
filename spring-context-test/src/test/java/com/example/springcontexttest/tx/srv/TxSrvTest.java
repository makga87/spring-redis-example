package com.example.springcontexttest.tx.srv;

import com.example.springcontexttest.tx.dto.Member;
import com.example.springcontexttest.tx.repo.MemberRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

class TxSrvTest {

    @DisplayName("향상된 for문에서 예외를 try-catch로 잡는 경우, 예외 발생 케이스를 제외한 로그는 그대로 찍는다")
    @Test
    void _10TimesFor_tryCatch() {

        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            try {
                if (m.getId() == 3) throw new Exception();
                System.out.println(m.getId());
            } catch (Exception e) {
            }
        }
    }

    @DisplayName("향상된 for문에서 예외를 Exception throw 하는 경우, 예외 발생이후 로직은 진행하지 않는다.")
    @Test
    void _10TimesFor_throwException() throws Exception {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            if (m.getId() == 3l) throw new Exception();
            System.out.println(m.getId());
        }
    }

    @DisplayName("stream에서 예외를 try-catch로 잡는 경우, 예외 발생 케이스를 제외한 쿼리들은 그대로 진행한다.")
    @Test
    void _10TimesStream() {
        List<Member> memberList = getManyMembers(10);
        memberList.stream().forEach(m -> {
            try {
                if (m.getId() == 3) throw new Exception();
                System.out.println(m.getId());
            } catch (Exception e) {
            }
        });
    }

    public List<Member> getManyMembers(int memberCnt) {
        List<Member> memberList = new ArrayList<>();
        for (long i = 1; i <= memberCnt; i++) {
            memberList.add(new Member(i, "test" + i));
        }
        return memberList;
    }
}