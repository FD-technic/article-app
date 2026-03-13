package fd.ferda.springblog.data.repositories;

import fd.ferda.springblog.data.entities.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Long> {
}
