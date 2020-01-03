package com.zust.itee.service.impl;

import com.zust.itee.common.PageInfo;
import com.zust.itee.dao.ComplaintDao;
import com.zust.itee.dao.UserDao;
import com.zust.itee.dto.ComplaintDTO;
import com.zust.itee.dto.UserDTO;
import com.zust.itee.entity.Tcomplaint;
import com.zust.itee.entity.Tuser;
import com.zust.itee.service.ComplaintService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/13
 */

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    UserDao userDao;

    @Autowired
    ComplaintDao complaintDao;

    @Override
    public PageInfo<ComplaintDTO> searchComplaints(int pageSize, int pageNum) {

        if(pageSize < 0 || pageNum < 0) {
            return null;
        }

        Pageable pageable = new PageRequest(pageNum - 1,pageSize);

        Page<Tcomplaint> tcomplaints = complaintDao.findAll(pageable);

        if(tcomplaints == null) {
            return null;
        }

        return page2pageInfo(tcomplaints);
    }

    @Override
    public ComplaintDTO findOne(int id) {

        Tcomplaint tcomplaint = complaintDao.findOne(id);

        if(tcomplaint == null) {
            return null;
        }

        return e2d(tcomplaint);
    }

    @Override
    public ComplaintDTO saveComplaint(int userId, String title, String content) {

        if(userId < 0 || title == null || content == null) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);

        if(tuser == null) {
            return null;
        }

        Tcomplaint tcomplaint = new Tcomplaint();
        tcomplaint.setTitle(title);
        tcomplaint.setContent(content);
        tcomplaint.setTuser(tuser);
        tcomplaint.setTime(new Date());
        tcomplaint.setUserId(userId);

        complaintDao.save(tcomplaint);

        return e2d(tcomplaint);
    }

    @Override
    public boolean deleteComplaint(int id) {

        if(id < 0) {
            return false;
        }

        Tcomplaint tcomplaint = complaintDao.findOne(id);

        if(tcomplaint == null) {
            return false;
        }

        complaintDao.delete(tcomplaint);

        return true;
    }

    private PageInfo<ComplaintDTO> page2pageInfo(Page<Tcomplaint> p) {
        if (p == null) {
            return null;
        }
        PageInfo<ComplaintDTO> pageInfo = new PageInfo<>();
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

    public ComplaintDTO e2d(Tcomplaint tcomplaint) {

        if(tcomplaint == null) {
            return null;
        }

        ComplaintDTO complaintDTO = new ComplaintDTO();
        BeanUtils.copyProperties(tcomplaint,complaintDTO);

        int userId = tcomplaint.getUserId();

        if(userId < 0) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);

        if(tuser == null) {
            return null;
        }

        String username = tuser.getUsername();

        complaintDTO.setComplaintName(username);

        return complaintDTO;
    }

    public List<ComplaintDTO> e2d(List<Tcomplaint> tcomplaints) {

        if(tcomplaints == null || tcomplaints.size() == 0) {
            return new ArrayList<>();
        }

        List<ComplaintDTO> complaintDTOS = new ArrayList<>();

        for(Tcomplaint tcomplaint : tcomplaints) {
            if(tcomplaint != null) {
                complaintDTOS.add(e2d(tcomplaint));
            }
        }

        return complaintDTOS;
    }
}
