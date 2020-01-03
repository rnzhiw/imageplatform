package com.zust.itee.dao;

import com.zust.itee.entity.Tblacklist;
import com.zust.itee.entity.Tcomplaint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/20
 */

@Repository
public interface BlackDao extends JpaRepository<Tblacklist, Integer>, JpaSpecificationExecutor<Tblacklist> {

    /**
     * 通过用户的id查找被该用户拉黑的名单
     * @param blackerId
     * @return
     */
    Page<Tblacklist> findByBlackerId(int blackerId, Pageable pageable);

    /**
     * 通过当前登录用户的id去找黑名单的信息
     *
     * @param blackerId
     * @return
     */
    List<Tblacklist> findByBlackerId(int blackerId);
}
