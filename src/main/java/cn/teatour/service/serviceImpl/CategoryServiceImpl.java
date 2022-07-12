package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.CategoryMapper;
import cn.teatour.pojo.Category;
import cn.teatour.pojo.CategoryExample;
import cn.teatour.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CategoryService 的实现类
 *
 * @author: @zj
 * @create: 2022-04-27-下午 16:35
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        List<Category> categories = categoryMapper.selectByExample(example);
        return categories;
    }

    public Category get(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }


}
