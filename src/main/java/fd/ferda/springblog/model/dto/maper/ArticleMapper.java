package fd.ferda.springblog.model.dto.maper;

import fd.ferda.springblog.data.entities.ArticleEntity;
import fd.ferda.springblog.model.dto.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleEntity toEntity(ArticleDTO source);

    ArticleDTO toDTO(ArticleEntity source);

    void updateArticleDTO(ArticleDTO source, @MappingTarget ArticleDTO target);

    void updateArticleEntity(ArticleDTO source, @MappingTarget ArticleEntity target);
}
