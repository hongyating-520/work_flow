package com.example.oldguy.modules.modeler.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oldguy.common.utils.CopyUtil;
import com.example.oldguy.modules.app.dao.ActIdUser;
import com.example.oldguy.modules.app.services.IActIdUserService;
import org.flowable.ui.common.model.RemoteGroup;
import org.flowable.ui.common.model.RemoteToken;
import org.flowable.ui.common.model.RemoteUser;
import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyRemoteServiceImpl
 * @Author: ren
 * @Description:
 * @CreateTIme: 2020/1/25 0025 下午 11:27
 **/
@Service
public class MyRemoteServiceImpl implements RemoteIdmService {

    private Logger LOGGER = LoggerFactory.getLogger(MyRemoteServiceImpl.class);

    @Resource
    private IActIdUserService userService;

    @Override
    public RemoteUser authenticateUser(String username, String password) {
        ActIdUser user = userService.getOne(new QueryWrapper<ActIdUser>().eq("DISPLAY_NAME_", username).eq("PWD_",password));
        if (user !=null){
            RemoteUser remoteUser = new RemoteUser();
            BeanUtils.copyProperties(user,remoteUser);
            return remoteUser;
        }
        return null;
    }

    @Override
    public RemoteToken getToken(String tokenValue) {
        LOGGER.warn("MyRemoteServiceImpl:getToken");
        return null;
    }

    @Override
    public RemoteUser getUser(String userId) {
        ActIdUser user = userService.getOne(new QueryWrapper<ActIdUser>().eq("id", userId));
        if (user !=null){
            RemoteUser remoteUser = new RemoteUser();
            BeanUtils.copyProperties(user,remoteUser);
            return remoteUser;
        }
        return null;
    }

    @Override
    public List<RemoteUser> findUsersByNameFilter(String filter) {
        List<ActIdUser> list = userService.list(new QueryWrapper<ActIdUser>().like("FIRST_", filter));
        if (!CollectionUtils.isEmpty(list)){
            List<RemoteUser> remoteUserList = CopyUtil.copyList(list, RemoteUser.class);
            return remoteUserList;
        }
        return null;
    }

    @Override
    public List<RemoteUser> findUsersByGroup(String groupId) {
        LOGGER.warn("MyRemoteServiceImpl:findUsersByGroup");
        return null;
    }

    /**
     *  org.flowable.ui.modeler.rest.app.EditorGroupsResource#getGroups(java.lang.String)
     *  url: http://localhost:8081/flowable-modeler-demo/app/rest/editor-groups

     * @param groupId
     * @return
     */
    @Override
    public RemoteGroup getGroup(String groupId) {
        LOGGER.warn("MyRemoteServiceImpl:getGroup");
        return new RemoteGroup();
    }

    /**
     *  分配用户功能
     *
     *  http://localhost:8081/flowable-modeler-demo/app/rest/editor-groups
     *  org.flowable.ui.modeler.rest.app.EditorGroupsResource#getGroups(java.lang.String)
     * @param filter
     * @return
     */
    @Override
    public List<RemoteGroup> findGroupsByNameFilter(String filter) {
        LOGGER.warn("MyRemoteServiceImpl:findGroupsByNameFilter");

        List<RemoteGroup> groups = new ArrayList<>();
        groups.add(new RemoteGroup("01","组-01"));
        groups.add(new RemoteGroup("02","组-02"));
        return groups;
    }
}
