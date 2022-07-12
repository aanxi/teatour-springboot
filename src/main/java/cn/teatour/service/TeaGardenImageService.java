package cn.teatour.service;

import cn.teatour.pojo.TeaGardenImage;

import java.util.List;

public interface TeaGardenImageService {

    void add(TeaGardenImage image);

    void deleteByTeaGardenId(Integer teaGarden_id);

    void update(TeaGardenImage image);

    TeaGardenImage get(Integer id);

    List<TeaGardenImage> list(Integer teaGarden_id);
}
