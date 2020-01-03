package com.zust.itee.service.impl;

import com.zust.itee.common.PageInfo;
import com.zust.itee.dao.BlackDao;
import com.zust.itee.dao.UserDao;
import com.zust.itee.dto.BlackDTO;
import com.zust.itee.entity.Tblacklist;
import com.zust.itee.entity.Tuser;
import com.zust.itee.service.BlackService;
import com.zust.itee.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/20
 */

@Service
@Transactional
public class BlackServiceImpl implements BlackService {

    @Autowired
    UserDao userDao;

    @Autowired
    BlackDao blackDao;

    @Autowired
    UserService userService;

    @Override
    public PageInfo<BlackDTO> searchBlackeds(int userId, int pageSize, int pageNum) {

        if(userId < 0 || pageSize < 0 || pageNum < 0) {
            return null;
        }

        Pageable pageable = new PageRequest(pageNum - 1,pageSize);

        Page<Tblacklist> tblacklists = blackDao.findByBlackerId(userId, pageable);

        if(tblacklists == null) {
            return null;
        }

        return page2pageInfo(tblacklists);
    }

    @Override
    public boolean deleteBlack(int id) {

        /**
         * 这里的id指的是黑名单表单序号
         */
        if(id < 0) {
            return false;
        }

        Tblacklist tblacklist = blackDao.findOne(id);

        if(tblacklist == null) {
            return false;
        }

        blackDao.delete(tblacklist);

        return true;
    }

    @Override
    public BlackDTO addBlack(int userId, int id) {

        if(userId < 0 || id < 0) {
            return null;
        }

        Tuser tuser1 = userDao.findById(userId);
        Tuser tuser2 = userDao.findById(id);

        if(tuser1 == null || tuser2 == null) {
            return null;
        }

        Tblacklist tblacklist = new Tblacklist();

        tblacklist.setBlackerId(userId);
        tblacklist.setBlackedId(id);

        blackDao.save(tblacklist);

        userService.removeConcern(userId,id);

        return e2d(tblacklist);
    }

    private PageInfo<BlackDTO> page2pageInfo(Page<Tblacklist> p) {
        if (p == null) {
            return null;
        }
        PageInfo<BlackDTO> pageInfo = new PageInfo<>();
        Integer page = p.getTotalPages();
        Integer pageNum = p.getNumber();
        pageInfo.setTotal(p.getTotalElements());
        if (pageNum == 0) {
            pageInfo.setFirstPage(true);
        } else {
            pageInfo.setFirstPage(false);
        }
        if (pageNum.equals(page)) {
            pageInfo.setLastPage(true);
        } else {
            pageInfo.setLastPage(false);
        }
        pageInfo.setPageNum(p.getNumber());
        pageInfo.setTotal(p.getTotalElements());
        pageInfo.setPages(page);
        pageInfo.setList(e2d(p.getContent()));
        pageInfo.setPageSize(p.getSize());
        pageInfo.setSize(p.getContent().size());

        return pageInfo;
    }

    private BlackDTO e2d(Tblacklist tblacklist) {

        if(tblacklist == null) {
            return null;
        }

        BlackDTO blackDTO = new BlackDTO();
        BeanUtils.copyProperties(tblacklist,blackDTO);

        Integer blackedId = tblacklist.getBlackedId();

        if(blackedId == null) {
            return null;
        }

        Tuser tuser = userDao.findById(blackedId);
        if(tuser == null) {
            return null;
        }

        String username = tuser.getUsername();
        String province = tuser.getProvince();
        String email = tuser.getEmail();

        if(username == null || province == null || email == null) {
            return null;
        }

        blackDTO.setUsername(username);
        blackDTO.setProvince(province);
        blackDTO.setEmail(email);

        return blackDTO;
    }

    private List<BlackDTO> e2d(List<Tblacklist> tblacklists) {

        if(tblacklists == null || tblacklists.size() == 0) {
            return new ArrayList<>();
        }

        List<BlackDTO> blackDTOS = new ArrayList<>();

        for(Tblacklist tblacklist : tblacklists) {
            if(tblacklist != null) {
                blackDTOS.add(e2d(tblacklist));
            }
        }

        return blackDTOS;
    }
}
