package com.zust.itee.dao;

import com.zust.itee.entity.Trole;
import com.zust.itee.entity.Tuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ruanzhiwei
 * @date 2019/12/16
 */

@Repository
public interface Role extends JpaRepository<Trole, Integer>, JpaSpecificationExecutor<Trole> {

}
