package com.tomyli.dao;

import com.tomyli.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 李志鹏 2016/09/05 10:52.
 */
public interface UserMapper {

    User selectUserByID(@Param("id") int id);
}
