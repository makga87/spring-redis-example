package com.example.springcontexttest.tx.srv;

import com.example.springcontexttest.tx.dto.Member;
import com.example.springcontexttest.tx.repo.MemberRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TxSrv {

    private final long DELAY = 5000;
    private final MemberRepo memberRepo;

    public TxSrv(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public void insert10TimesFor_tryCatch() {

        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            try {
                if (m.getId() == 3) throw new Exception();
                memberRepo.insert(m);
            } catch (Exception e) {

            }
        }
    }

    public void insert10TimesStream() {
        List<Member> memberList = getManyMembers(10);
        memberList.stream().forEach(m -> {
            try {
                if (m.getId() == 4) throw new Exception();
                memberRepo.insert(m);
            } catch (Exception e) {
            }
        });
    }

    public void insert10TimesFor_throwException() throws Exception {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            if (m.getId() == 5) throw new Exception();
            memberRepo.insert(m);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void insert10TimesFor_throwExceptionTransaction() throws Exception {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            if (m.getId() == 6) throw new Exception();
            memberRepo.insert(m);
        }
    }

    @Transactional
    public void insert10TimesFor_throwExceptionTransaction_withoutRollbackFor() throws Exception {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            if (m.getId() == 6) throw new Exception();
            memberRepo.insert(m);
        }
    }

    public void insert10TimesFor_throwRuntimeException() throws RuntimeException {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            if (m.getId() == 6) throw new RuntimeException();
            memberRepo.insert(m);
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void insert10TimesFor_throwRuntimeExceptionTransaction() throws RuntimeException {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            if (m.getId() == 6) throw new RuntimeException();
            memberRepo.insert(m);
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void insert10TimesStream_throwExceptionTransaction() {
        List<Member> memberList = getManyMembers(10);
        memberList.stream()
                .forEach((m) -> {
                    try {
                        if (m.getId() == 6) throw new Exception();
                        memberRepo.insert(m);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    public void insert10TimesStream_throwRuntimeException() {
        List<Member> memberList = getManyMembers(10);
        memberList.stream()
                .forEach((m) -> {
                    try {
                        if (m.getId() == 6) throw new RuntimeException();
                        memberRepo.insert(m);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    @Transactional(rollbackFor = Exception.class)
    public void insert10TimesStream_throwRuntimeExceptionTransaction() {
        List<Member> memberList = getManyMembers(10);
        memberList.stream()
                .forEach((m) -> {
                    try {
                        if (m.getId() == 6) throw new RuntimeException();
                        memberRepo.insert(m);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    public void transactional_with_sleep_db_down_1() throws InterruptedException {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            Thread.sleep(DELAY);
            memberRepo.insert(m);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void transactional_with_sleep_db_down_2() throws InterruptedException {
        List<Member> memberList = getManyMembers(10);
        for (Member m : memberList) {
            Thread.sleep(DELAY);
            memberRepo.insert(m);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public void transactional_with_sleep_db_down_3() {
        List<Member> memberList = getManyMembers(10);
        memberList.stream()
                .forEach((m) -> {
                    try {
                        Thread.sleep(DELAY);
                        memberRepo.insert(m);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    public void transactional_with_sleep_db_down_4() {
        List<Member> memberList = getManyMembers(10);
        memberList.stream()
                .forEach((m) -> {
                    try {
                        Thread.sleep(DELAY);
                        memberRepo.insert(m);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Transactional(rollbackFor = {Exception.class})
    public void insert3Times_private() throws Exception {
        private_insert1();
        private_insert2();
        private_insert3();
    }

    @Transactional(rollbackFor = {Exception.class})
    public void insert3Times_public() throws Exception {
        public_insert1();
        public_insert2();
        public_insert3();
    }

    private void private_insert1(){
        memberRepo.insert(new Member(1l, "test" + 1));
    }
    private void private_insert2(){
        memberRepo.insert(new Member(2l, "test" + 2));

    }
    private void private_insert3() throws Exception {
        memberRepo.insert(new Member(null, "test" + 3));
    }

    public void public_insert1(){
        memberRepo.insert(new Member(1l, "test" + 1));
    }
    public void public_insert2(){
        memberRepo.insert(new Member(2l, "test" + 2));

    }
    public void public_insert3() throws Exception {
        memberRepo.insert(new Member(null, "test" + 3));
    }


    public void delete() {
        memberRepo.delete();
    }

    public List<Member> getManyMembers(int memberCnt) {
        List<Member> memberList = new ArrayList<>();
        for (long i = 1; i <= memberCnt; i++) {
            memberList.add(new Member(i, "test" + i));
        }
        return memberList;
    }
}
