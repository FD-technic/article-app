package fd.ferda.springblog.controller;

import fd.ferda.springblog.model.dto.ArticleDTO;
import fd.ferda.springblog.model.dto.maper.ArticleMapper;
import fd.ferda.springblog.model.exception.ArticleNotFoundException;
import fd.ferda.springblog.model.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String renderIndex(Model model) {
        List<ArticleDTO> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "pages/articles/index";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute ArticleDTO articleDTO) {
        return "pages/articles/create";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("create")
    public String createArticle(
            @Valid @ModelAttribute ArticleDTO article,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderCreateForm(article);

        //System.out.println(article.getTitle() + " - " + article.getDescription());
        articleService.create(article);
        redirectAttributes.addFlashAttribute("success", "Článek vytvořen.");

        return "redirect:/articles";
    }

    @GetMapping("{articleId}")
    public String renderDetail(
            @PathVariable long articleId,
            Model model
    ) {
        ArticleDTO article = articleService.getById(articleId);
        model.addAttribute("article", article);

        return "pages/articles/detail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("edit/{articleId}")
    public String renderEditForm(
            @PathVariable Long articleId,
            ArticleDTO article
    ) {
        ArticleDTO fetchedArticle = articleService.getById(articleId);
        articleMapper.updateArticleDTO(fetchedArticle, article);

        return "pages/articles/edit";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("edit/{articleId}")
    public String editArticle(
            @PathVariable long articleId,
            @Valid ArticleDTO article,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if ( result.hasErrors())
            return renderEditForm(articleId, article);

        article.setArticleId(articleId);
        articleService.edit(article);
        redirectAttributes.addFlashAttribute("success", "Článek byl upraven.");

        return "redirect:/articles";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("delete/{articleId}")
    public String deleteArticle(@PathVariable long articleId,
                                RedirectAttributes redirectAttributes
    ) {
        articleService.remove(articleId);
        redirectAttributes.addFlashAttribute("success", "Článek smazán.");
        return "redirect:/articles";
    }

    @ExceptionHandler({ArticleNotFoundException.class})
    public String handleArticleNotFoundException(
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addFlashAttribute("error", "Článek nenalezen!");
        return "redirect:/articles";
    }

}
