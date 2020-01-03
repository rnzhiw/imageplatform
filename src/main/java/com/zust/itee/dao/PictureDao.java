package com.zust.itee.dao;

import com.zust.itee.entity.Tpicture;
import com.zust.itee.entity.Tuser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/14
 */

@Repository
public interface PictureDao extends JpaRepository<Tpicture, Integer>, JpaSpecificationExecutor<Tpicture> {

    /**
     * 查找个人所有照片
     *
     * @return
     */
    List<Tpicture> findByUserId(int userId);

    /**
     * 根据照片的名称查找自己的照片
     *
     * @param userId
     * @param fname
     * @return
     */
    List<Tpicture> findByUserIdAndFnameLike(int userId,String fname);

    /**
     * 根据照片的名称查找照片
     *
     * @param fname
     * @return
     */
    List<Tpicture> findByFnameLike(String fname);

    /**
     * 根据关注的人的id和图片名称模糊查询
     *
     * @param id
     * @param fname
     * @return
     */
    List<Tpicture> findByIdAndFnameLike(int id,String fname);
}
