package fd.ferda.springblog;

import fd.ferda.springblog.data.repositories.ArticleRepository;
import fd.ferda.springblog.model.exception.ArticleNotFoundException;
import fd.ferda.springblog.model.service.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpringBlogApplicationTest {

    @Mock
    private ArticleRepository repository;

    @InjectMocks
    private ArticleServiceImpl service;

    @Test
    void shouldThrowExceptionWhenArticleNotFound() {
        assertThrows(
                ArticleNotFoundException.class,
                () -> service.getById(99L)
        );
    }

}