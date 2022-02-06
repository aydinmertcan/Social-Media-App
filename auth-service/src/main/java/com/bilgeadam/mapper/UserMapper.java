package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    // Birebir aynı olan alanların eşlenmesi durumu var
    // Eğer alanların yani değişkenlerin adları aynı değilse set işlemi nasıl olacak?
//    @Mapping(source ="email", target = "username") ==> Tek tek maplemek için birden çok kez yazılabilir.
    @Mapping(source = "email", target = "username")
    User toUser(final RegisterRequestDto dto);

    DoLoginResponseDto doLoginResponseDto(User user);
}
