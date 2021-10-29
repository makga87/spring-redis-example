package com.example.springcontexttest.tx.repo;

import com.example.springcontexttest.tx.dto.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepo {

    @Insert("insert into member (id, name) values (#{id}, #{name})")
    int insert(Member member);

    @Delete("delete from member")
    int delete();
}
