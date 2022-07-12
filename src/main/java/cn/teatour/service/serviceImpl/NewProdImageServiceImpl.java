package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.NewProdImageMapper;
import cn.teatour.pojo.NewProdImage;
import cn.teatour.pojo.NewProdImageExample;
import cn.teatour.service.NewProdImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NewProdImageService 实现类
 *
 * @author: @zj
 * @create: 2022-04-28-上午 11:04
 */
@Service
public class NewProdImageServiceImpl implements NewProdImageService {

    @Autowired
    NewProdImageMapper newProdImageMapper;

    public void add(NewProdImage image) {
        newProdImageMapper.insert(image);
    }

    public void deleteByNewProdId(Integer newProd_id) {

        // 按条件查询出需要删除的列表
        NewProdImageExample example = new NewProdImageExample();
        example.or().andNewProd_idEqualTo(newProd_id);
        List<NewProdImage> newProdImages = list(newProd_id);

        // 循环删除
        for (int i = 0; i < newProdImages.size(); i++) {
            newProdImageMapper.deleteByPrimaryKey(newProdImages.get(i).getId());
        }
    }

    public void update(NewProdImage image) {
        newProdImageMapper.updateByPrimaryKey(image);
    }

    public NewProdImage get(Integer id) {
        return newProdImageMapper.selectByPrimaryKey(id);
    }

    public List<NewProdImage> list(Integer newProd_id) {
        NewProdImageExample example = new NewProdImageExample();
        example.or().andNewProd_idEqualTo(newProd_id);
        List<NewProdImage> newProdImages = newProdImageMapper.selectByExample(example);
        return newProdImages;
    }
}
