package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.TeaGardenImageMapper;
import cn.teatour.pojo.TeaGardenImage;
import cn.teatour.pojo.TeaGardenImageExample;
import cn.teatour.service.TeaGardenImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TeaGardenImageService 实现类
 *
 * @author: @zj
 * @create: 2022-04-28-上午 11:04
 */
@Service
public class TeaGardenImageServiceImpl implements TeaGardenImageService {

    @Autowired
    TeaGardenImageMapper teaGardenImageMapper;

    public void add(TeaGardenImage image) {
        teaGardenImageMapper.insert(image);
    }

    public void deleteByTeaGardenId(Integer teaGarden_id) {

        // 按条件查询出需要删除的列表
        TeaGardenImageExample example = new TeaGardenImageExample();
        example.or().andTeaGarden_idEqualTo(teaGarden_id);
        List<TeaGardenImage> teaGardenImages = list(teaGarden_id);

        // 循环删除
        for (int i = 0; i < teaGardenImages.size(); i++) {
            teaGardenImageMapper.deleteByPrimaryKey(teaGardenImages.get(i).getId());
        }
    }

    public void update(TeaGardenImage image) {
        teaGardenImageMapper.updateByPrimaryKey(image);
    }

    public TeaGardenImage get(Integer id) {
        return teaGardenImageMapper.selectByPrimaryKey(id);
    }

    public List<TeaGardenImage> list(Integer teaGarden_id) {
        TeaGardenImageExample example = new TeaGardenImageExample();
        example.or().andTeaGarden_idEqualTo(teaGarden_id);
        List<TeaGardenImage> teaGardenImages = teaGardenImageMapper.selectByExample(example);
        return teaGardenImages;
    }
}
