package cn.teatour.service;

import cn.teatour.pojo.TeaGarden;
import cn.teatour.pojo.TeaGardenCategory;

import java.util.List;

public interface TeaGardenService {

    /**
     * 增加一条数据
     *
     * @param teaGarden
     */
    void add(TeaGarden teaGarden);

    /**
     * 通过id删除一条数据
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新一条数据
     *
     * @param teaGarden
     */
    void update(TeaGarden teaGarden);

    /**
     * 根据id获取一条数据
     *
     * @param id
     * @return
     */
    TeaGarden get(Integer id);

    /**
     * 根据teaGardenCategory_id返回所有对应的TeaGarden数据
     *
     * @param teaGardenCategory_id
     * @return
     */
    List<TeaGarden> list(Integer teaGardenCategory_id);

    /**
     * 为多个分类填充产品集合
     *
     * @param categorie
     */
    void fill(List<TeaGardenCategory> categories);

    /**
     * 为一个分类填充产品集合
     *
     * @param teaGardenCategory
     */
    void fill(TeaGardenCategory teaGardenCategory);

    /**
     * 为多个分类填充产品集合
     *
     * @param categories
     */
    void fillByRow(List<TeaGardenCategory> categories);

    /**
     * 为产品填充TeaGardenReviewCount字段
     *
     * @param teaGarden
     */
    void setTeaGardenReviewCount(TeaGarden teaGarden);

    /**
     * 根据keyword返回相应的产品集合
     *
     * @param keyword
     * @return
     */
    List<TeaGarden> search(String keyword);
}
