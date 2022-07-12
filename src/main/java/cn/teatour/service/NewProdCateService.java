package cn.teatour.service;

import cn.teatour.pojo.NewProdCate;

import java.util.List;

public interface NewProdCateService {

    /**
     * 返回分类列表
     *
     * @return
     */
    List<NewProdCate> list();

    /**
     * 通过id获取对应的数据
     *
     * @param id
     * @return
     */
    NewProdCate get(Integer id);

    /**
     * 更新分类
     *
     * @param newProdCate
     * @return
     */
    void update(NewProdCate newProdCate);
}
