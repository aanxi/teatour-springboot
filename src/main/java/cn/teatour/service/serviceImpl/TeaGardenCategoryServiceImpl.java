package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.TeaGardenCategoryMapper;
import cn.teatour.pojo.TeaGardenCategory;
import cn.teatour.pojo.TeaGardenCategoryExample;
import cn.teatour.service.TeaGardenCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TeaGardenCategoryService 的实现类
 *
 * @author: @zj
 * @create: 2022-04-27-下午 16:35
 */
@Service
public class TeaGardenCategoryServiceImpl implements TeaGardenCategoryService {

    @Autowired
    TeaGardenCategoryMapper teaGardenCategoryMapper;

    public List<TeaGardenCategory> list() {
        TeaGardenCategoryExample example = new TeaGardenCategoryExample();
        List<TeaGardenCategory> categories = teaGardenCategoryMapper.selectByExample(example);
        return categories;
    }

    public TeaGardenCategory get(Integer id) {
        return teaGardenCategoryMapper.selectByPrimaryKey(id);
    }

    public void update(TeaGardenCategory teaGardenCategory) {
        teaGardenCategoryMapper.updateByPrimaryKey(teaGardenCategory);
    }


}
