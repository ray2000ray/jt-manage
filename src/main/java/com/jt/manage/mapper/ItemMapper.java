package com.jt.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jt.common.po.Item;


public interface ItemMapper {
	
	
	/**
	 * Mybatis不允许多值传参
	 * 1.将数据封装为POJO对象
	 * 2.将数据封装为Map集合(@Param("key" String value))
	 * 3.将数据封装为Array类型
	 * 4.将数据封装为List类型(ArrayList)
	 * @param start
	 * @param rows
	 * @return
	 */
	List<Item> findItemByPage(@Param("start")Integer start, @Param("rows")Integer rows);

	//使用注解的形式查询数据库; mapper.xml和注解方式只能存在一种,不能同id
	//@Insert @Select @@Update @Delete
	@Select("select count(*) from tb_item")
	int findItemCount();
	
	@Select("select name from tb_item_cat where id = #{itemId}")
	String findItemCatNameById(@Param("itemId") Long itemId);
	
	
}
