package com.tomyli.dao;

import com.tomyli.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * zhipeng.li@chelaile.net.cn
 * Created by tomyli on 2016/09/05 10:54.
 */
public class UserMapperTest {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    @Test
    public void selectUserByID() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = session.selectOne("com.tomyli.dao.UserMapper.selectUserByID", 1);
            System.out.println(user.getUserName());
        } finally {
            session.close();
        }


    }

}
