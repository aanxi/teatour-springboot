package cn.teatour.service;

import cn.teatour.pojo.NewProdRev;

import java.util.List;

public interface NewProdRevService {

    /**
     * 增加一条评论
     *
     * @param newProdRev
     * @return
     */
    boolean add(NewProdRev newProdRev);

    /**
     * 删除一条评论
     *
     * @param id
     */
    void delete(int id);

    /**
     * 更新一条评论
     *
     * @param newProdRev
     */
    void update(NewProdRev newProdRev);

    /**
     * 通过id返回一条NewProdRev
     *
     * @param id
     * @return
     */
    NewProdRev get(int id);

    /**
     * 根据newProd_id来返回当前产品下的所有评论
     *
     * @param newProd_id
     * @return
     */
    List<NewProdRev> listByNewProdId(Integer newProd_id);

    /**
     * 返回当前产品下评论的数量
     *
     * @param newProd_id
     * @return
     */
    int getCount(int newProd_id);

    /**
     * 查询某一用户是否评价过某一新品
     *
     * @param newProd_id
     * @param
     * @return boolean
     */
    boolean hasReviewed(Integer id, Integer newProd_id);



}
