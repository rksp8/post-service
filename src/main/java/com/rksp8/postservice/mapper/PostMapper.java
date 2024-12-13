package com.rksp8.postservice.mapper;

import com.rksp8.postservice.dto.PostCreateDto;
import com.rksp8.postservice.dto.PostDto;
import com.rksp8.postservice.dto.RatingDto;
import com.rksp8.postservice.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    
    @Mapping(target = "ratings", source = "ratings")
    PostDto toDto(Post post, List<RatingDto> ratings);

    Post toEntity(PostCreateDto postDto);
}
