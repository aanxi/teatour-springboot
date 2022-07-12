package cn.teatour.service;

import cn.teatour.pojo.NewProdImage;

import java.util.List;

public interface NewProdImageService {

    void add(NewProdImage image);

    void deleteByNewProdId(Integer newProd_id);

    void update(NewProdImage image);

    NewProdImage get(Integer id);

    List<NewProdImage> list(Integer newProd_id);
}
