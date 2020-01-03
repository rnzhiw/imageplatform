package com.zust.itee.dao;

import com.zust.itee.entity.Tcomplaint;
import com.zust.itee.entity.Tuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ruanzhiwei
 * @date 2019/12/13
 */

@Repository
public interface ComplaintDao extends JpaRepository<Tcomplaint, Integer>, JpaSpecificationExecutor<Tcomplaint> {

}
