package com.zust.itee.dao;

import com.zust.itee.entity.Tresource;
import com.zust.itee.entity.Tuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Repository
public interface ResourceDao extends JpaRepository<Tresource, Integer> {

    List<Tresource> findByStatus(boolean status);
}
