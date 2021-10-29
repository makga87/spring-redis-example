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

@SpringBootTest
class TxSrvTest {

    @Autowired
    MemberRepo memberRepo;

    @BeforeEach
    void init() {
        memberRepo.delete();
    }

    @DisplayName("향상된 for문에서 예외를 try-catch로 잡는 경우, 예외 발생 케이스를 제외한 쿼리들은 그대로 진행한다.")
    @Test
    void insert10TimesFor_tryCatch() {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            try {
                if (m.getId() == 3) throw new Exception();
                memberRepo.insert(m);
            } catch (Exception e) {

            }
        }
    }

    @DisplayName("stream에서 예외를 try-catch로 잡는 경우, 예외 발생 케이스를 제외한 쿼리들은 그대로 진행한다.")
    @Test
    void insert10TimesStream() {
        List<Member> memberList = getManyMembers(10);
        memberList.stream().forEach(m -> {
            try {
                if (m.getId() == 4) throw new Exception();
                memberRepo.insert(m);
            } catch (Exception e) {
            }
        });
    }


    @DisplayName("향상된 for문에서 예외를 throw 하는 경우, 예외 발생이후 로직은 진행하지 않는다.")
    @Test
    void insert10TimesFor_throwException() throws Exception {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            if (m.getId() == 3) throw new Exception();
            memberRepo.insert(m);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @DisplayName("향상된 for문에서 예외를 throw 하고, @Transactional 선언한 경우, 롤백이 된다.")
    @Test
    void insert10TimesFor_throwExceptionTransaction() throws Exception {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            if (m.getId() == 3) throw new Exception();
            memberRepo.insert(m);
        }
    }

    public List<Member> getManyMembers(int memberCnt) {
        List<Member> memberList = new ArrayList<>();
        for (int i = 1; i <= memberCnt; i++) {
            memberList.add(new Member(i, "test" + i));
        }
        return memberList;
    }
}