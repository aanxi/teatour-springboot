package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.NewProdRevMapper;
import cn.teatour.pojo.NewProdRev;
import cn.teatour.pojo.NewProdRevExample;
import cn.teatour.pojo.User;
import cn.teatour.service.NewProdRevService;
import cn.teatour.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NewProdRevService 实现类
 *
 * @author: @zj
 * @create: 2022-05-02-上午 7:51
 */
@Service
public class NewProdRevServiceImpl implements NewProdRevService {

    @Autowired
    NewProdRevMapper newProdRevMapper;

    @Autowired
    UserService userService;

    @Override
    public boolean add(NewProdRev newProdRev) {
        int count = newProdRevMapper.selectCount(new QueryWrapper<NewProdRev>()
                .eq("user_id", newProdRev.getUser_id())
                .eq("newProd_id", newProdRev.getNewProd_id()));
        if(count > 0) {
            return false;
        }
        newProdRevMapper.insert(newProdRev);
        return true;
    }

    @Override
    public void delete(int id) {
        newProdRevMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(NewProdRev newProdRev) {
        newProdRevMapper.updateByPrimaryKeySelective(newProdRev);
    }

    @Override
    public NewProdRev get(int id) {
        return newProdRevMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NewProdRev> listByNewProdId(Integer newProd_id) {
        NewProdRevExample example = new NewProdRevExample();
        example.or().andNewProd_idEqualTo(newProd_id);
        example.setOrderByClause("id desc");

        List<NewProdRev> newProdRevs = newProdRevMapper.selectByExample(example);
        setUser(newProdRevs);
        return newProdRevs;
    }

    public void setUser(List<NewProdRev> newProdRevs) {
        for (NewProdRev newProdRev : newProdRevs) {
            setUser(newProdRev);
        }
    }

    private void setUser(NewProdRev newProdRev) {
        int user_id = newProdRev.getUser_id();
        User user = userService.get(user_id);
        newProdRev.setUser(user);
    }

    @Override
    public int getCount(int newProd_id) {
        return listByNewProdId(newProd_id).size();
    }

    @Override
    public boolean hasReviewed(Integer id, Integer newProd_id) {
        int count = newProdRevMapper.selectCount(new QueryWrapper<NewProdRev>()
                .eq("user_id", id)
                .eq("newProd_id", newProd_id));
        return count > 0;
    }
}
