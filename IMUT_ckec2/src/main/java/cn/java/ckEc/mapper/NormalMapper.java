package cn.java.ckEc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import cn.java.ckEc.entity.Normal;
public interface NormalMapper {
    public int deleteByPrimaryKey(Integer id);
    
    @Insert("INSERT INTO normal "
    		+ "SET username=#{username},password=#{password},sex=IF(#{sex},1,0),cellphone=#{cellphone},"
    		+ "email=#{email},head_sculpture=#{headSculpture},"
    		+"permission_type1=0,permission_type2=0,permission_type3=0,"
    		+ "permission_type4=0,permission_type5=0,time_created={#timeCreated}")
    public int insert(Normal norma);

    public int insertSelective(Normal normal);

    public Normal selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Normal normal);

    public int updateByPrimaryKey(Normal normal);
    
    @Select("SELECT username FROM normal WHERE username = #{arg0}")
	public Normal selectByUserName(String username);
}