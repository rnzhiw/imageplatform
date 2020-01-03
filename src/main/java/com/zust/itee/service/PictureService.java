package com.zust.itee.service;

import com.zust.itee.dto.PictureDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/15
 */

@Service
public interface PictureService {

    /**
     * 查找个人所有的图片信息
     *
     * @param userId
     * @return
     */
    List<PictureDTO> searchAllPicture(int userId);

    /**
     * 根据照片的名称模糊查询自己的照片
     *
     * @param userId
     * @param fname
     * @return
     */
    List<PictureDTO> searchonePerson(int userId,String fname);

    /**
     * 根据照片的名称模糊查询照片
     * @param fname
     * @return
     */
    List<PictureDTO> searchOne(int userId,String fname);

    /**
     * 查找所有照片
     *
     * @return
     */
    List<PictureDTO> searchall(int userId);

    /**
     * 按照关注的人的id和图片名称查找图片
     *
     * @param id
     * @param fname
     * @return
     */
    List<PictureDTO> searchConcernPicture(int id,String fname);

    /**
     * 根据id删除照片
     *
     * @param id
     * @return
     */
    boolean delete(int id);

}
