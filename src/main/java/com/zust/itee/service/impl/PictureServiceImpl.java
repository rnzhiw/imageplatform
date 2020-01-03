package com.zust.itee.service.impl;

import com.zust.itee.dao.BlackDao;
import com.zust.itee.dao.PictureDao;
import com.zust.itee.dao.UserDao;
import com.zust.itee.dto.PictureDTO;
import com.zust.itee.entity.Tblacklist;
import com.zust.itee.entity.Tpicture;
import com.zust.itee.entity.Tuser;
import com.zust.itee.service.PictureService;
import com.zust.itee.util.DateUtil;
import com.zust.itee.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ruanzhiwei
 * @date 2019/12/15
 */

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    UserDao userDao;

    @Autowired
    PictureDao pictureDao;

    @Autowired
    BlackDao blackDao;

    @Override
    public List<PictureDTO> searchAllPicture(int userId) {

        if(userId < 0) {
            return new ArrayList<>();
        }

        List<Tpicture> tpictures = pictureDao.findByUserId(userId);

        if(tpictures == null || tpictures.size() == 0) {
            return new ArrayList<>();
        }

        return e2d(tpictures);
    }

    @Override
    public List<PictureDTO> searchonePerson(int userId, String fname) {

        if(userId < 0) {
            return new ArrayList<>();
        }

        if(fname == null || fname == "") {
            fname = "%";
        } else {
            fname = "%" + fname + "%";
        }

        List<Tpicture> tpictures = pictureDao.findByUserIdAndFnameLike(userId, fname);

        return e2d(tpictures);
    }

    @Override
    public boolean delete(int id) {

        if(id < 0) {
            return false;
        }

        Tpicture tpicture = pictureDao.findOne(id);

        if(tpicture == null) {
            return false;
        }

        pictureDao.delete(tpicture);

        return true;
    }

    @Override
    public List<PictureDTO> searchOne(int userId,String fname) {

        if(userId < 0 || fname == null || fname == "") {
            fname = "%";
        } else {
            fname = "%" + fname + "%";
        }

        List<Tpicture> tpictures = pictureDao.findByFnameLike(fname);

        Set<Tpicture> blackPictures = new HashSet<>();

        List<Tblacklist> tblacklists = blackDao.findByBlackerId(userId);

        if(tblacklists == null) {
            tpictures = tpictures;
        } else {
            for(Tblacklist tblacklist : tblacklists) {
                if(tblacklist != null) {
                    //当前登录用户拉黑的用户id
                    Integer blackedId = tblacklist.getBlackedId();
                    //通过该用户id查找到这个用户的所有照片
                    List<Tpicture> tpictures1 = pictureDao.findByUserId(blackedId);
                    //这个为该拉黑用户拥有的图片set化
                    Set<Tpicture> tpictures2 = new HashSet<>(tpictures1);
                    //将这个用户所有的图片添加到总的拉黑图片集合中
                    blackPictures.addAll(tpictures2);
                }
            }
            //总图片set化
            Set<Tpicture> tpictureSet = new HashSet<>(tpictures);
            tpictureSet.removeAll(blackPictures);
            tpictures.clear();
            tpictures.addAll(tpictureSet);
        }

        return e2d(tpictures);
    }

    @Override
    public List<PictureDTO> searchall(int userId) {

        List<Tpicture> tpictures = pictureDao.findAll();

        Set<Tpicture> blackPictures = new HashSet<>();

        List<Tblacklist> tblacklists = blackDao.findByBlackerId(userId);

        if(tblacklists == null) {
            tpictures = tpictures;
        } else {
            for(Tblacklist tblacklist : tblacklists) {
                if(tblacklist != null) {
                    //当前登录用户拉黑的用户id
                    Integer blackedId = tblacklist.getBlackedId();
                    //通过该用户id查找到这个用户的所有照片
                    List<Tpicture> tpictures1 = pictureDao.findByUserId(blackedId);
                    //这个为该拉黑用户拥有的图片set化
                    Set<Tpicture> tpictures2 = new HashSet<>(tpictures1);
                    //将这个用户所有的图片添加到总的拉黑图片集合中
                    blackPictures.addAll(tpictures2);
                }
            }
            //总图片set化
            Set<Tpicture> tpictureSet = new HashSet<>(tpictures);
            tpictureSet.removeAll(blackPictures);
            tpictures.clear();
            tpictures.addAll(tpictureSet);
        }

        DateUtil.ListSort(tpictures);

        return e2d(tpictures);
    }

    @Override
    public List<PictureDTO> searchConcernPicture(int id, String fname) {

        if(fname == null || fname == "") {
            fname = "%";
        } else {
            fname = "%" + fname + "%";
        }

        if(id < 0) {
            return null;
        }

        int userId = id;

        List<Tpicture> tpictures = pictureDao.findByUserIdAndFnameLike(userId, fname);

        if(tpictures == null) {
            return null;
        }

        return e2d(tpictures);
    }

    private PictureDTO e2d(Tpicture tpicture) {

        if(tpicture == null) {
            return null;
        }

        PictureDTO pictureDTO = new PictureDTO();
        BeanUtils.copyProperties(tpicture,pictureDTO);

        int userId = tpicture.getUserId();

        if(userId < 0) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);

        if(tuser == null) {
            return null;
        }

        String username = tuser.getUsername();

        pictureDTO.setUsername(username);

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
