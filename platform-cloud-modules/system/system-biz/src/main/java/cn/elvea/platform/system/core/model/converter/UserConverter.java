package cn.elvea.platform.system.core.model.converter;

import cn.elvea.platform.system.core.model.dto.UserDto;
import cn.elvea.platform.system.core.model.dto.UserLoginDto;
import cn.elvea.platform.system.core.model.dto.UserRegisterDto;
import cn.elvea.platform.system.core.model.dto.UserSaveDto;
import cn.elvea.platform.system.core.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author elvea
 * @since 0.0.1
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(target = "organizations", ignore = true)
    @Mapping(target = "positions", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    UserLoginDto entity2UserLoginDto(UserEntity entity);

    @Mapping(target = "passwordExpireAt", ignore = true)
    @Mapping(target = "passwordErrorAt", ignore = true)
    @Mapping(target = "passwordErrorCount", ignore = true)
    @Mapping(target = "lastLoginStatus", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedAt", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "deletedBy", ignore = true)
    UserEntity saveDtoToEntity(UserSaveDto saveDto);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedAt", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "deletedBy", ignore = true)
    UserDto entityToDto(UserEntity entity);

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "mobileCountryCode", ignore = true)
    @Mapping(target = "mobile", ignore = true)
    @Mapping(target = "displayName", ignore = true)
    @Mapping(target = "idCardType", ignore = true)
    @Mapping(target = "idCardNo", ignore = true)
    @Mapping(target = "sex", ignore = true)
    @Mapping(target = "birthday", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "passwordExpireAt", ignore = true)
    @Mapping(target = "passwordErrorAt", ignore = true)
    @Mapping(target = "passwordErrorCount", ignore = true)
    @Mapping(target = "lastLoginStatus", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedAt", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "deletedBy", ignore = true)
    UserEntity userRegisterDtoToEntity(UserRegisterDto dto);

}
