package me.javaroad.mcloud.blog.repository;

import java.util.List;
import me.javaroad.mcloud.blog.entity.Category;
import me.javaroad.mcloud.blog.entity.QCategory;
import me.javaroad.mcloud.blog.entity.QUser;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * @author heyx
 */
public class CategoryRepositoryImpl extends QueryDslRepositorySupport implements CategoryRepositoryCustom {

    private QCategory category = QCategory.category;
    private QUser user = QUser.user;

    public CategoryRepositoryImpl() {
        super(Category.class);
    }

    @Override
    public List<Category> findByUser(String username) {
        return from(category)
            .innerJoin(category.user, user)
            .where(user.username.eq(username))
            .fetch();
    }
}
