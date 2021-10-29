package com.example.springcontexttest.tx.srv;

import com.example.springcontexttest.tx.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxSrv {

    @Autowired
    private MemberRepo memberRepo;



}
