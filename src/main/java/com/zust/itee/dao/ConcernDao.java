package com.zust.itee.dao;

import com.zust.itee.entity.Tcomplaint;
import com.zust.itee.entity.Tconcern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ruanzhiwei
 * @date 2019/12/18
 */

@Repository
public interface ConcernDao extends JpaRepository<Tconcern, Integer>, JpaSpecificationExecutor<Tconcern> {


}
