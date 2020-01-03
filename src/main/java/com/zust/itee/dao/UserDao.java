package com.zust.itee.dao;

import com.zust.itee.entity.Tuser;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Repository
public interface UserDao extends JpaRepository<Tuser, Integer>, JpaSpecificationExecutor<Tuser> {

    /**
     * 按照手机号查找用户
     *
     * @param mobile
     * @return
     */
    Tuser findByMobile(String mobile);

    /**
     * 通过用户id查找用户
     *
     * @param id
     * @return
     */
    Tuser findById(Integer id);

}
