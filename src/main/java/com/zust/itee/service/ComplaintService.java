package com.zust.itee.service;

import com.zust.itee.common.PageInfo;
import com.zust.itee.dto.ComplaintDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/13
 */

@Service
public interface ComplaintService {


    /**
     * 搜索所有投诉
     *
     * @param pageSize 每页显示的条数
     * @param pageNum 页码
     * @return
     */
    PageInfo<ComplaintDTO> searchComplaints(int pageSize, int pageNum);

    /**
     * 保存用户提交的投诉
     *
     * @param userId
     * @param title
     * @param content
     * @return
     */
    ComplaintDTO saveComplaint(int userId,String title,String content);

    /**
     * 根据id查找投诉
     *
     * @param id
     * @return
     */
    ComplaintDTO findOne(int id);

    /**
     * 根据id删除投诉
     *
     * @param id
     * @return
     */
    boolean deleteComplaint(int id);

}
