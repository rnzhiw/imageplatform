package com.zust.itee.service;

import com.zust.itee.common.PageInfo;
import com.zust.itee.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Service
public interface UserService {

    /**
     * 用户登录
     *
     * @param mobile 用户登录手机号
     * @param password 用户登录密码
     * @param session 用户会话
     */
    public String login(String mobile, String password, HttpSession session);

    /**
     * 根据id获取用户
     *
     * @param userId
     * @return
     */
    UserDTO findOne(Integer userId);

    /**
     * 修改密码
     *
     * @param userId
     * @param newPassword1
     * @param newPassword2
     */
    void update(int userId,String newPassword1,String newPassword2);

    /**
     * 查找用户关注的所有人
     *
     * @param userId
     */
    List<UserDTO> findAllConcerners(int userId);

    /**
     * 修改个人信息
     *
     * @param username
     * @param province
     * @param city
     * @param QQ
     * @return
     */
    UserDTO modify(int userId,String username,String province,String city,String QQ);

    /**
     * 显示个人信息
     *
     * @param userId
     * @return
     */
    UserDTO showPerson(int userId);

    /**
     * 搜索所有用户
     *
     * @param pageSize 每页显示的条数
     * @param pageNum 页码
     * @return
     */
    PageInfo<UserDTO> searchMembers(int pageSize,int pageNum);

//    /**
//     * 搜索该用户拉黑的所有用户
//     *
//     * @param userId
//     * @param pageSize
//     * @param pageNum
//     * @return
//     */
//    PageInfo<UserDTO> searchBlackLists(int userId,int pageSize,int pageNum);

    /**
     * 新增用户信息
     *
     * @param name
     * @param mobile
     * @param province
     * @param roleId
     * @return
     */
    UserDTO save(String name,String mobile,String province,int roleId,String email);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 编辑用户信息
     *
     * @param id
     * @param name
     * @param mobile
     * @param province
     * @param roleId
     * @param email
     * @return
     */
    UserDTO update(int id,String name,String mobile,String province,int roleId,String email);

    /**
     * 根据用户id查找用户详细信息
     *
     * @param id
     * @return
     */
    UserDTO findPersondetail(int id);

    /**
     * 添加关注
     *
     * @param userId 当前登录用户id
     * @param id 与当前登录用户操作的id
     * @return
     */
    UserDTO addConcern(int userId,int id);

    /**
     * 取消关注
     *
     * @param userId 当前登录用户id
     * @param id 与当前登录用户操作的id
     * @return
     */
    UserDTO removeConcern(int userId,int id);

    /**
     * 更改用户的头像
     *
     * @param userId
     * @param imageHashs
     * @return
     */
    UserDTO changeImage(int userId,String imageHashs);

}
