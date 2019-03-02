package cn.java.ckEc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.java.ckEc.entity.Member;

public interface MemberMapper {
    public int deleteByPrimaryKey(Byte id);
    
    @Insert("INSERT INTO member SET member_name=#{memberName},password=#{password},major=#{major},description=#{description},"
            +"sex=IF(TRUE,1,0),head_sculpture=IFNULL(#{headSculpture},'/images/xxx.jpg'),cellphone=#{cellphone},"
		    +"permission_type1=0,permission_type2=0,permission_type3=0,"
		    +"permission_type4=0,permission_type5=0,time_created=#{timeCreated}")
    public int insert(Member member);

    public int insertSelective(Member member);

    public Member selectByPrimaryKey(Byte id);

    public int updateByPrimaryKeySelective(Member member);

    public int updateByPrimaryKey(Member member);
    

	@Select("SELECT member_name FROM member WHERE member_name = #{arg0}")
	public Member selectByUserName(String member_name);
}