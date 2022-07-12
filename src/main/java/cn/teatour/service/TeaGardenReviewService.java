package cn.teatour.service;

import cn.teatour.pojo.TeaGardenReview;

import java.util.List;

public interface TeaGardenReviewService {

    /**
     * 增加一条评论
     *
     * @param teaGardenReview
     */
    void add(TeaGardenReview teaGardenReview);

    /**
     * 删除一条评论
     *
     * @param id
     */
    void delete(int id);

    /**
     * 更新一条评论
     *
     * @param teaGardenReview
     */
    void update(TeaGardenReview teaGardenReview);

    /**
     * 通过id返回一条TeaGardenReview
     *
     * @param id
     * @return
     */
    TeaGardenReview get(int id);

    /**
     * 根据teaGarden_id来返回当前产品下的所有评论
     *
     * @param teaGarden_id
     * @return
     */
    List<TeaGardenReview> listByTeaGardenId(Integer teaGarden_id);

    /**
     * 返回当前产品下评论的数量
     *
     * @param teaGarden_id
     * @return
     */
    int getCount(int teaGarden_id);
}
