package com.zust.itee.service;

import com.zust.itee.dto.ResourceDTO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/10
 */

@Service
public interface ResourceService {

    /**
     * 根据id查找资源
     *
     * @param id
     * @return
     */
    ResourceDTO findOne(int id);

    /**
     * 列出所有资源
     *
     * @return
     */
    List<ResourceDTO> findAll();

    /**
     * 保存上传的资源
     *
     * @param resName
     * @param resKey
     * @param menuUrl
     * @param status
     * @return
     */
    ResourceDTO save(String resName,String resKey,String menuUrl,Boolean status);

    /**
     * 更新资源
     *
     * @param resName
     * @param resKey
     * @param menuUrl
     * @param status
     * @return
     */
    ResourceDTO update(int id,String resName,String resKey,String menuUrl,Boolean status);

    /**
     * 根据id删除资源
     *
     * @param id
     * @return
     */
    boolean delete(int id);
}
