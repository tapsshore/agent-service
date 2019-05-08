package com.shoshore.agentservice.business.criteria.mapper;

import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-07T18:30:39+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class DtoMapperImpl extends DtoMapper {

    @Override
    public UserDto map(ServiceResponse user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }

    @Override
    public User map(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setDateOfBirth( userDto.getDateOfBirth() );
        user.setIdNumber( userDto.getIdNumber() );
        user.setGender( userDto.getGender() );
        user.setMobileNumber( userDto.getMobileNumber() );
        user.setCity( userDto.getCity() );
        user.setHomeAddress( userDto.getHomeAddress() );
        user.setEmailAddress( userDto.getEmailAddress() );
        user.setDateCreated( userDto.getDateCreated() );
        user.setDateLastUpdated( userDto.getDateLastUpdated() );

        return user;
    }

    @Override
    public List<User> mapUser(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( users.size() );
        for ( User user : users ) {
            list.add( user );
        }

        return list;
    }

    @Override
    public PropertyDto map(Property property) {
        if ( property == null ) {
            return null;
        }

        PropertyDto propertyDto = new PropertyDto();

        propertyDto.setId( property.getId() );
        propertyDto.setPropertyStatus( property.getPropertyStatus() );
        propertyDto.setPropertyType( property.getPropertyType() );
        propertyDto.setNumberOfRooms( property.getNumberOfRooms() );
        propertyDto.setDescription( property.getDescription() );
        propertyDto.setCity( property.getCity() );
        propertyDto.setCountry( property.getCountry() );
        propertyDto.setSuburb( property.getSuburb() );
        propertyDto.setStreet( property.getStreet() );
        propertyDto.setPrice( property.getPrice() );
        propertyDto.setDateCreated( property.getDateCreated() );
        propertyDto.setDateLastUpdated( property.getDateLastUpdated() );

        return propertyDto;
    }

    @Override
    public Property map(PropertyDto propertyDto) {
        if ( propertyDto == null ) {
            return null;
        }

        Property property = new Property();

        property.setId( propertyDto.getId() );
        property.setPropertyStatus( propertyDto.getPropertyStatus() );
        property.setPropertyType( propertyDto.getPropertyType() );
        property.setNumberOfRooms( propertyDto.getNumberOfRooms() );
        property.setDescription( propertyDto.getDescription() );
        property.setCity( propertyDto.getCity() );
        property.setCountry( propertyDto.getCountry() );
        property.setSuburb( propertyDto.getSuburb() );
        property.setStreet( propertyDto.getStreet() );
        property.setPrice( propertyDto.getPrice() );
        property.setDateCreated( propertyDto.getDateCreated() );
        property.setDateLastUpdated( propertyDto.getDateLastUpdated() );

        return property;
    }
}
