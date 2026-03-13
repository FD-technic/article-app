package fd.ferda.springblog.model.service;

import fd.ferda.springblog.data.repositories.ArticleRepository;
import fd.ferda.springblog.model.dto.maper.ArticleMapper;
import fd.ferda.springblog.model.exception.ArticleNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceImplTest {

    @Mock
    private ArticleRepository repository;

    @Mock
    private ArticleMapper mapper;

    @InjectMocks
    private ArticleServiceImpl service;

    @Test
    void shouldThrowExceptionWhenArticleNotFound() {

        when(repository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(
                ArticleNotFoundException.class,
                () -> service.getById(99L)
        );
    }

}