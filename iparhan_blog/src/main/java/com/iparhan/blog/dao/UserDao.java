package com.iparhan.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iparhan.blog.bean.User;

@Repository
public interface UserDao extends CrudRepository<User,Integer>{
	/**
	 * selectUserById
	 * @param id
	 * @return
	 */
	
	
	/**
	 * selectAll
	 * @return
	 */

	public User findByUsernameAndPassword(String username,String password);

}
