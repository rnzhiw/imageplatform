package com.zust.itee.service;

import com.zust.itee.dto.PictureDTO;
import org.springframework.stereotype.Service;

/**
 * @author ruanzhiwei
 * @date 2019/12/14
 */

@Service
public interface UploadService {

    /**
     * 上传的图片登记
     *
     * @param userId
     * @param name
     * @param tag
     * @return
     */
    PictureDTO save(Integer userId,String name,String tag,String imageHashs);

}
