package cn.elvea.platform.system.core.service;

import cn.elvea.platform.commons.core.service.CachingEntityService;
import cn.elvea.platform.commons.core.service.EntityService;
import cn.elvea.platform.system.core.model.dto.UserRoleSaveDto;
import cn.elvea.platform.system.core.model.entity.UserRoleEntity;

import java.util.List;

/**
 * @author elvea
 * @see EntityService
 * @see CachingEntityService
 * @since 0.0.1
 */
public interface UserRoleService extends CachingEntityService<UserRoleEntity, Long> {

    /**
     * @param userId 用户ID
     * @return 用户角色关联
     */
    List<UserRoleEntity> findByUserId(Long userId);

    /**
     * @param userId 用户ID
     * @return 角色ID
     */
    List<Long> findRoleIdByUserId(Long userId);

    /**
     * @param userIdList 用户ID
     * @return 用户角色关联
     */
    List<UserRoleEntity> findAllByUserId(List<Long> userIdList);

    /**
     * @param userIdList 用户ID
     * @return 角色ID
     */
    List<Long> findAllRoleIdByUserId(List<Long> userIdList);

    /**
     * @param roleId 角色ID
     * @return 用户角色关联
     */
    List<UserRoleEntity> findByRoleId(Long roleId);

    /**
     * @param roleId 角色ID
     * @return 用户ID
     */
    List<Long> findUserIdByRoleId(Long roleId);

    /**
     * @param roleIdList 角色ID
     * @return 用户角色关联
     */
    List<UserRoleEntity> findAllByRoleId(List<Long> roleIdList);

    /**
     * @param roleIdList 角色ID
     * @return 用户ID
     */
    List<Long> findAllUserIdByRoleId(List<Long> roleIdList);

    /**
     * 保存用户和角色关联
     *
     * @param saveDto {@link UserRoleSaveDto}
     * @return boolean
     */
    boolean saveUserRole(UserRoleSaveDto saveDto);

}
