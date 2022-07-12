package cn.teatour.service;

import cn.teatour.pojo.NewProd;
import cn.teatour.pojo.NewProdCate;

import java.util.List;

public interface NewProdService {

    /**
     * 增加一条数据
     *
     * @param newProd
     */
    void add(NewProd newProd);

    /**
     * 通过id删除一条数据
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新一条数据
     *
     * @param newProd
     */
    void update(NewProd newProd);

    /**
     * 根据id获取一条数据
     *
     * @param id
     * @return
     */
    NewProd get(Integer id);

    /**
     * 根据newProdCate_id返回所有对应的NewProd数据
     *
     * @param newProdCate_id
     * @return
     */
    List<NewProd> list(Integer newProdCate_id);

    /**
     * 为多个分类填充产品集合
     *
     * @param categories
     */
    void fill(List<NewProdCate> categories);

    /**
     * 为一个分类填充产品集合
     *
     * @param newProdCate
     */
    void fill(NewProdCate newProdCate);

    /**
     * 为多个分类填充产品集合
     *
     * @param categories
     */
    void fillByRow(List<NewProdCate> categories);

    /**
     * 为产品填充NewProdRevCount字段
     *
     * @param newProd
     */
    void setNewProdRevCount(NewProd newProd);

    /**
     * 根据keyword返回相应的产品集合
     *
     * @param keyword
     * @return
     */
    List<NewProd> search(String keyword);
}
