package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.NewProdMapper;
import cn.teatour.pojo.NewProd;
import cn.teatour.pojo.NewProdCate;
import cn.teatour.pojo.NewProdExample;
import cn.teatour.service.NewProdRevService;
import cn.teatour.service.NewProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * NewProdService 实现类
 *
 * @author: @zj
 * @create: 2022-04-27-下午 20:16
 */
@Service
public class NewProdServiceImpl implements NewProdService {

    @Autowired
    NewProdMapper newProdMapper;

    @Autowired
    NewProdRevService newProdRevService;

    @Override
    public void add(NewProd newProd) {
        newProdMapper.insert(newProd);
    }

    @Override
    public void delete(Integer id) {
        newProdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(NewProd newProd) {
        newProdMapper.updateByPrimaryKey(newProd);
    }

    @Override
    public NewProd get(Integer id) {
        return newProdMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NewProd> list(Integer newProdCate_id) {
        NewProdExample example = new NewProdExample();
        example.or().andNewProdCate_idEqualTo(newProdCate_id);
        List<NewProd> newProds = newProdMapper.selectByExample(example);
        return newProds;
    }

    @Override
    public void fill(List<NewProdCate> categories) {
        for (NewProdCate newProdCate : categories) {
            fill(newProdCate);
        }
    }

    @Override
    public void fill(NewProdCate newProdCate) {
        List<NewProd> newProds = list(newProdCate.getId());
        newProdCate.setNewProds(newProds);
    }

    @Override
    public void fillByRow(List<NewProdCate> categories) {
        int newProdNumberOfEachRow = 8;
        for (NewProdCate newProdCate : categories) {
            List<NewProd> newProds = newProdCate.getNewProds();
            List<List<NewProd>> newProdByRow = new ArrayList<>();
            for (int i = 0; i < newProds.size(); i += newProdNumberOfEachRow) {
                int size = i + newProdNumberOfEachRow;
                size = size > newProds.size() ? newProds.size() : size;
                List<NewProd> newProdsOfEachRow = newProds.subList(i, size);
                newProdByRow.add(newProdsOfEachRow);
            }
            newProdCate.setNewProdByRow(newProdByRow);
        }
    }

    @Override
    public void setNewProdRevCount(NewProd newProd) {
        int newProdRevCount = newProdRevService.getCount(newProd.getId());
        newProd.setNewProdRevCount(newProdRevCount);
    }

    @Override
    public List<NewProd> search(String keyword) {
        NewProdExample example = new NewProdExample();
        example.or().andNameLike("%" + keyword + "%");
        example.setOrderByClause("id desc");
        return newProdMapper.selectByExample(example);
    }
}
