package com.rksp8.postservice.mapper;

import com.rksp8.postservice.dto.PostCreateDto;
import com.rksp8.postservice.dto.PostDto;
import com.rksp8.postservice.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostDto toDto(Post post);

    Post toEntity(PostCreateDto postDto);
}
