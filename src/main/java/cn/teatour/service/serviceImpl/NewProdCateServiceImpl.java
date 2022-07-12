package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.NewProdCateMapper;
import cn.teatour.pojo.NewProdCate;
import cn.teatour.pojo.NewProdCateExample;
import cn.teatour.service.NewProdCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NewProdCateService 的实现类
 *
 * @author: @zj
 * @create: 2022-04-27-下午 16:3511
 * 4
 */
@Service
public class NewProdCateServiceImpl implements NewProdCateService {

    @Autowired
    NewProdCateMapper newProdCateMapper;

    public List<NewProdCate> list() {
        NewProdCateExample example = new NewProdCateExample();
        List<NewProdCate> categories = newProdCateMapper.selectByExample(example);
        return categories;
    }

    public NewProdCate get(Integer id) {
        return newProdCateMapper.selectByPrimaryKey(id);
    }

    public void update(NewProdCate newProdCate) {
        newProdCateMapper.updateByPrimaryKey(newProdCate);
    }


}
