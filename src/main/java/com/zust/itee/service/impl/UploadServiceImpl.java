package com.zust.itee.service.impl;

import com.zust.itee.dao.PictureDao;
import com.zust.itee.dao.UserDao;
import com.zust.itee.dto.PictureDTO;
import com.zust.itee.entity.Tpicture;
import com.zust.itee.entity.Tuser;
import com.zust.itee.service.UploadService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/14
 */

@Service
@Transactional
public class UploadServiceImpl implements UploadService {

    @Autowired
    UserDao userDao;

    @Autowired
    PictureDao pictureDao;

    @Override
    public PictureDTO save(Integer userId, String name, String tag,String imageHashs) {

        if(userId < 0 || name == null || tag == null) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);

        if(tuser == null) {
            return null;
        }

        Tpicture tpicture = new Tpicture();
        tpicture.setUserId(userId);
        tpicture.setFname(name);
        tpicture.setIntro(tag);
        tpicture.setUploadTime(new Date());
        tpicture.setAddress(imageHashs);

        pictureDao.save(tpicture);

        return e2d(tpicture);
    }

    private PictureDTO e2d(Tpicture tpicture) {

        if(tpicture == null) {
            return null;
        }

        PictureDTO pictureDTO = new PictureDTO();
        BeanUtils.copyProperties(tpicture,pictureDTO);

        return pictureDTO;
    }

    private List<PictureDTO> e2d(List<Tpicture> tpictures) {

        if(tpictures == null || tpictures.size() == 0) {
            return new ArrayList<>();
        }

        List<PictureDTO> pictureDTOS = new ArrayList<>();

        for(Tpicture tpicture : tpictures) {
            if(tpicture != null) {
                pictureDTOS.add(e2d(tpicture));
            }
        }

        return pictureDTOS;
    }
}
