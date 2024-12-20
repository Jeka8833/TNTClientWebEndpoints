package com.jeka8833.tntclientendpoints.services.discordbot.service.mojang.mappers;

import com.jeka8833.tntclientendpoints.services.discordbot.service.mojang.MojangProfile;
import com.jeka8833.tntclientendpoints.services.discordbot.service.mojang.dtos.MojangProfileDto;
import com.jeka8833.tntclientendpoints.services.general.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Slf4j
@Mapper(componentModel = "spring")
public abstract class MojangProfileMapper {
    @Mapping(target = "uuid", source = "id", qualifiedByName = "toUUID")
    public abstract MojangProfile toMojangProfile(MojangProfileDto dto);

    @Named("toUUID")
    static UUID toUUID(String value) {
        try {
            return UuidUtil.parseWithoutDash(value);
        } catch (Throwable e) {
            log.warn("Failed to parse uuid: {}", value, e);
        }

        return null;
    }
}
