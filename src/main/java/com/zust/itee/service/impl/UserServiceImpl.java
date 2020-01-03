package com.zust.itee.service.impl;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.Constants;
import com.zust.itee.common.PageInfo;
import com.zust.itee.dao.ResourceDao;
import com.zust.itee.dao.UserDao;
import com.zust.itee.dto.UserDTO;
import com.zust.itee.entity.*;
import com.zust.itee.form.SessionInfo;
import com.zust.itee.service.UserService;
import com.zust.itee.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * 超级管理员
     */
    @Value("1")
    private Integer superUserId;

    @Autowired
    UserDao userDao;

    @Autowired
    ResourceDao resourceDao;

    @Override
    public UserDTO findOne(Integer userId) {

        if(userId == null) {
            return null;
        }

        return e2d(userDao.findOne(userId));
    }

    @Override
    public UserDTO changeImage(int userId, String imageHashs) {

        if(userId < 0 || imageHashs == null) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);

        if(tuser == null) {
            return null;
        }

        tuser.setAddress(imageHashs);

        userDao.save(tuser);

        return e2d(tuser);
    }

    @Override
    public void update(int userId, String newPassword1, String newPassword2) {
        if(userId <= 0 || newPassword1 == null || newPassword2 == null) {
            return;
        }
        Tuser tuser = userDao.findById(userId);
        if(tuser == null) {
            return;
        }
        tuser.setPassword(newPassword1);
        userDao.save(tuser);
    }

    @Override
    public UserDTO modify(int userId,String username, String province, String city, String QQ) {

        if(userId < 0 || username == null || province == null || city == null || QQ == null) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);

        if(tuser == null) {
            return null;
        }

        tuser.setUsername(username);
        tuser.setProvince(province);
        tuser.setCity(city);
        tuser.setQQ(QQ);

        Tuser tuser1 = userDao.save(tuser);

        return e2d(tuser1);
    }

    @Override
    public List<UserDTO> findAllConcerners(int userId) {

        if(userId < 0) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);

        if(tuser == null) {
            return null;
        }

        Set<Tuser> concerners = tuser.getConcerner();

        List<Tuser> resultConcerners = new ArrayList<>(concerners);

        return e2d(resultConcerners);
    }

    @Override
    public UserDTO showPerson(int userId) {

        if(userId < 0) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);

        UserDTO userDTO = e2d(tuser);

        Set<Tpicture> tpictures = tuser.getTpictures();
        Set<Tuser> concerners = tuser.getConcerner();
        Set<Tuser> concerneds = tuser.getConcerned();

        if(tpictures == null) {
            return null;
        }

        if(concerners == null) {
            return null;
        }

        if(concerneds == null) {
            return null;
        }

        int pictureSize = tpictures.size();
        int concernerSize = concerners.size();
        int concernedSize = concerneds.size();

        userDTO.setPictureSize(pictureSize);
        userDTO.setConernerSize(concernerSize);
        userDTO.setConcernedSize(concernedSize);

        return userDTO;
    }

    @Override
    public PageInfo<UserDTO> searchMembers(int pageSize, int pageNum) {

        if(pageSize < 0 || pageNum < 0) {
            return null;
        }

        Pageable pageable = new PageRequest(pageNum - 1,pageSize);

        Page<Tuser> tusers = userDao.findAll(pageable);

        if(tusers == null) {
            return null;
        }

        return page2pageInfo(tusers);
    }

//    @Override
//    public PageInfo<UserDTO> searchBlackLists(int userId, int pageSize, int pageNum) {
//
//        if(pageSize < 0 || pageNum < 0) {
//            return null;
//        }
//
//        Pageable pageable = new PageRequest(pageNum - 1,pageSize);
//
//        Tuser tuser = userDao.findById(userId);
//
//        if(tuser == null) {
//            return null;
//        }
//
//        List<Tblacklist> tblacklisters = tuser.getTblacklisters();
//
//        if(tblacklisters == null) {
//            return null;
//        }
//
//        List<UserDTO> userDTOS = new ArrayList<>();
//
//        for(Tblacklist tblacklist : tblacklisters) {
//
//            if(tblacklist != null) {
//                tblacklist.get
//            }
//
//        }
//
//        Page<Tblacklist> tblacklists = new PageImpl<>(tblacklisters,pageable,tblacklisters.size());
//
////        if(tblacklists == null) {
////            return null;
////        }
////
////        return page2pageInfo(tblacklists);
//        return null;
//    }

    @Override
    public UserDTO save(String name, String mobile, String province, int roleId,String email) {

        if(name == null || mobile == null || province == null || roleId < 0 || email == null) {
            return null;
        }

        Tuser tuser = new Tuser();
        tuser.setUsername(name);
        tuser.setMobile(mobile);
        tuser.setProvince(province);
        tuser.setEmail(email);
        tuser.setPassword("0000");

        Short a = 1;
        tuser.setStatus(a);

        List<Trole> troles = new ArrayList<>();
        Trole trole = new Trole();
        trole.setId(roleId);
        troles.add(trole);

        tuser.setTroles(troles);

        return e2d(userDao.save(tuser));
    }

    @Override
    public boolean delete(int id) {

        if(id < 0) {
            return false;
        }

        Tuser tuser = userDao.findById(id);

        if(tuser == null) {
            return false;
        }

        userDao.delete(tuser);

        return true;
    }

    @Override
    public UserDTO update(int id, String name, String mobile, String province, int roleId, String email) {

        if(id < 0 || name == null || mobile == null || province == null || roleId < 0 || email == null) {
            return null;
        }

        Tuser tuser = userDao.findById(id);

        if(tuser == null) {
            return null;
        }

        tuser.setUsername(name);
        tuser.setMobile(mobile);
        tuser.setProvince(province);
        tuser.setEmail(email);
        List<Trole> troles = new ArrayList<>();
        Trole trole = new Trole();
        trole.setId(roleId);
        troles.add(trole);

        tuser.setTroles(troles);


        return null;
    }

    @Override
    public UserDTO findPersondetail(int id) {

        if(id < 0) {
            return null;
        }

        Tuser tuser = userDao.findOne(id);

        if(tuser == null) {
            return null;
        }

        UserDTO userDTO = e2d(tuser);

        Set<Tpicture> tpictures = tuser.getTpictures();
        Set<Tuser> concerners = tuser.getConcerner();
        Set<Tuser> concerneds = tuser.getConcerned();

        if(tpictures == null) {
            return null;
        }

        if(concerners == null) {
            return null;
        }

        if(concerneds == null) {
            return null;
        }

        int pictureSize = tpictures.size();
        int concernerSize = concerners.size();
        int concernedSize = concerneds.size();

        userDTO.setPictureSize(pictureSize);
        userDTO.setConernerSize(concernerSize);
        userDTO.setConcernedSize(concernedSize);

        return userDTO;
    }

    @Override
    public UserDTO addConcern(int userId, int id) {

        if(userId < 0 || id < 0) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);
        Set<Tuser> concerner = tuser.getConcerner();
        Tuser userConcern = userDao.findById(id);

        if(tuser == null || userConcern == null || concerner == null) {
            return null;
        }

        concerner.add(userConcern);
        tuser.setConcerner(concerner);

        userDao.save(tuser);

        return e2d(tuser);
    }

    @Override
    public UserDTO removeConcern(int userId, int id) {

        if(userId < 0 || id < 0) {
            return null;
        }

        Tuser tuser = userDao.findById(userId);
        Set<Tuser> concerner = tuser.getConcerner();
        Tuser userConcern = userDao.findById(id);

        if(tuser == null || userConcern == null || concerner == null) {
            return null;
        }

        concerner.remove(userConcern);
        tuser.setConcerner(concerner);

        return e2d(tuser);
    }

    @Override
    public String login(String mobile, String password, HttpSession session) {

        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            return "账号或者用户名为空";
        }

        Tuser tuser = userDao.findByMobile(mobile);

        String dbpassword = tuser.getPassword();

        if(tuser == null) {
            return "该用户不存在";
        } else {
            if(!dbpassword.equals(password)) {
                return "密码错误";
            }
        }

        //所有资源，不同角色的相同资源不重复添加
        List<Tresource> allResources = new ArrayList<>();
        //用户对应的权限
        List<Trole> troles = tuser.getTroles();
        //所有资源中的目录资源
        List<Tresource> menus = new ArrayList<>();
        //所有请求资源路径,若用户访问的资源路径不在此范围内，则将被拦截器拦截
        Set<String> urls = new HashSet<>();
        //所有资源的标识
        Set<String> resourceKey = new HashSet<>();

        if (superUserId.equals(tuser.getId())) {
            //若用户为超级管理员，直接获得所有权限资源
            allResources = resourceDao.findByStatus(true);
        } else {
            //直接遍历用户对应的所有角色的可用资源，可能出现重复
            List<Tresource> resourceList = new ArrayList<>();
            for (Trole role : troles) {
                //遍历用户的所有角色，并将该角色对应的资源存入集合
                resourceList.addAll(role.getResource());
            }
            //不同角色可能有持有相同的resource，这一步进行去重
            allResources = resourceList.stream().distinct().collect(Collectors.toList());
        }

        for (Tresource t : allResources) {

            //获取可用菜单，用于主页面左侧菜单栏的显示

            //不将系统管理放入菜单
            if (!"system".equals(t.getResKey())) {
                menus.add(t);
            }

            //获取所有请求资源路径，若访问的资源不在urls里，则将被拦截
            if (StringUtil.isEmpty(t.getMenuUrl())) {
                urls.add(t.getMenuUrl());
            }

            //添加资源标识
            resourceKey.add(t.getResKey());
        }

        //将用户可用菜单和权限存入sessionInfo
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setMenus(menus);
        sessionInfo.setUrls(urls);
        sessionInfo.setResourceKey(resourceKey);
        sessionInfo.setUserId(tuser.getId());
        sessionInfo.setRoleNames(tuser.getTroles().stream().map(Trole::getRoleName).collect(Collectors.toList()));
        sessionInfo.setSuperUser(superUserId.equals(tuser.getId()));
        if(superUserId.equals(tuser.getId())) {
            sessionInfo.setSuperUser(true);
            tuser.setType(1);
            userDao.save(tuser);
        } else {
            sessionInfo.setSuperUser(false);
            tuser.setType(0);
            userDao.save(tuser);
        }

        //将sessionInfo存入session
        session.setAttribute(Constants.SESSION_INFO, sessionInfo);

        SessionInfo sessionInfo2 = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        System.out.println(sessionInfo2);
        return "success";
    }

    private PageInfo<UserDTO> page2pageInfo(Page<Tuser> p) {
        if (p == null) {
            return null;
        }
        PageInfo<UserDTO> pageInfo = new PageInfo<>();
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


    private UserDTO e2d(Tuser tuser) {

        if (tuser == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(tuser, userDTO);

        //将role对象转为roleId/roleName存入MemberDTO
        List<Integer> roleIds = new ArrayList<>();
        List<String> roleNames = new ArrayList<>();
        if (tuser.getTroles() != null && tuser.getTroles().size() != 0) {
            for (Trole role : tuser.getTroles()) {
                roleIds.add(role.getId());
                roleNames.add(role.getRoleName());
            }
        }
        userDTO.setRoleIds(roleIds);
        userDTO.setRoleNames(roleNames);

        //加入每个用户的所有图片hash值
        Set<Tpicture> tpictures = tuser.getTpictures();
        Set<String> imageHashs = new HashSet<>();

        if(tpictures == null) {
            tuser.setTpictures(null);
        } else {
            for(Tpicture tpicture : tpictures) {
                if(tpicture != null) {
                    String tpictureAddress = tpicture.getAddress();
                    if(tpictureAddress != null) {
                        imageHashs.add(tpictureAddress);
                    }
                }
            }
        }

        userDTO.setImageHashs(imageHashs);

        return userDTO;
    }

    private List<UserDTO> e2d(List<Tuser> members) {

        if (members == null || members.size() == 0) {
            return new ArrayList<>();
        }

        List<UserDTO> memberDTOs = new ArrayList<>();

        for (Tuser member : members) {
            if (member != null) {
                memberDTOs.add(e2d(member));
            }
        }

        return memberDTOs;
    }
}
