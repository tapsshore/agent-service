package com.shoshore.agentservice.business.criteria.mapper;

import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DtoMapper {

    public abstract UserDto map(ServiceResponse user);

    public abstract User map(UserDto userDto);

    public abstract List<User> mapUser(List<User> users);


    public abstract PropertyDto map(Property property);

    public abstract Property map(PropertyDto propertyDto);

}
