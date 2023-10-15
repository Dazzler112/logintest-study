package com.logintest.logintest.mapper;

import com.logintest.logintest.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    @Select("""
            SELECT * FROM
            TB_LOGIN_MEMBER tm 
            LEFT JOIN 
            TB_AUTHORITY ta 
            ON
            tm.login_id = ta.member_id
            WHERE login_id = #{id}
            """)
    @ResultMap("memberMap")
    Member selectByMemberId(String id);

    @Insert("""
            INSERT INTO
            TB_LOGIN_MEMBER
                  (
                    login_id
                  , password
                  , name
                  , old
                  , gender
                  , phone_number
                  , email
                  , member_type
                  , address
                  , is_active
                  )
            VALUES
                  (
                  #{id}
                  , #{password}
                  , #{name}
                  , #{old}
                  , #{gender}
                  , #{phoneNumber}
                  , #{email}
                  , #{memberType}
                  , #{address}
                  , #{isActive}
                  )
            """)
    Integer signUpInsert(Member mem);
}
