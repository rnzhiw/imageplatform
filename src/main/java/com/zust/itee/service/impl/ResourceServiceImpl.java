package com.zust.itee.service.impl;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.dao.ResourceDao;
import com.zust.itee.dto.ResourceDTO;
import com.zust.itee.entity.Tresource;
import com.zust.itee.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/10
 */

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Value("1")
    private Integer superUserId;

    @Autowired
    ResourceDao resourceDao;

    @Override
    public ResourceDTO findOne(int id) {

        if(id < 0) {
            return null;
        }

        Tresource tresource = resourceDao.findOne(id);

        if(tresource == null) {
            return null;
        }

        return e2d(tresource);
    }

    @Override
    public List<ResourceDTO> findAll() {

        List<Tresource> allResources = resourceDao.findAll();

        return e2d(allResources);
    }



    @Override
    public ResourceDTO save(String resName, String resKey, String menuUrl, Boolean status) {

        if(resName == null || resKey == null || menuUrl == null || status == null) {
            return null;
        }

        Tresource tresource = new Tresource();
        tresource.setResName(resName);
        tresource.setResKey(resKey);
        tresource.setMenuUrl(menuUrl);
        tresource.setStatus(status);

        return e2d(resourceDao.save(tresource));
    }

    @Override
    public ResourceDTO update(int id,String resName, String resKey, String menuUrl, Boolean status) {

        if(resName == null || resKey == null || menuUrl == null || status == null) {
            return null;
        }

        Tresource tresource = resourceDao.findOne(id);

        if(tresource == null) {
            return null;
        }

        tresource.setResName(resName);
        tresource.setResKey(resKey);
        tresource.setMenuUrl(menuUrl);
        tresource.setStatus(status);

        return e2d(tresource);
    }

    @Override
    public boolean delete(int id) {

        if(id < 0) {
            return false;
        }

        Tresource tresource = resourceDao.findOne(id);

        if(tresource == null) {
            return false;
        }

        resourceDao.delete(tresource);

        return true;
    }

    public ResourceDTO e2d(Tresource tresource) {

        ResourceDTO resourceDTO = new ResourceDTO();

        if(tresource == null) {
            return resourceDTO;
        }

        BeanUtils.copyProperties(tresource,resourceDTO);

        return resourceDTO;
    }

    public List<ResourceDTO> e2d(List<Tresource> resources) {

        if (resources == null || resources.size() == 0) {
            return new ArrayList<>();
        }

        List<ResourceDTO> resourceDTOs = new ArrayList<>();
        for (Tresource resource : resources) {
            if (resource != null) {
                resourceDTOs.add(e2d(resource));
            }
        }

        return resourceDTOs;

    }
}
