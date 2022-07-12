package cn.teatour.service;

import cn.teatour.pojo.TeaGardenCategory;

import java.util.List;

public interface TeaGardenCategoryService {

    /**
     * 返回分类列表
     *
     * @return
     */
    List<TeaGardenCategory> list();

    /**
     * 通过id获取对应的数据
     *
     * @param id
     * @return
     */
    TeaGardenCategory get(Integer id);

    /**
     * 更新分类
     *
     * @param teaGardenCategory
     * @return
     */
    void update(TeaGardenCategory teaGardenCategory);
}
