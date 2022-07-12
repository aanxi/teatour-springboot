package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.TeaGardenReviewMapper;
import cn.teatour.pojo.TeaGardenReview;
import cn.teatour.pojo.TeaGardenReviewExample;
import cn.teatour.pojo.User;
import cn.teatour.service.TeaGardenReviewService;
import cn.teatour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TeaGardenReviewService 实现类
 *
 * @author: @zj
 * @create: 2022-05-02-上午 7:51
 */
@Service
public class TeaGardenReviewServiceImpl implements TeaGardenReviewService {

    @Autowired
    TeaGardenReviewMapper teaGardenReviewMapper;

    @Autowired
    UserService userService;

    @Override
    public void add(TeaGardenReview teaGardenReview) {
        teaGardenReviewMapper.insert(teaGardenReview);
    }

    @Override
    public void delete(int id) {
        teaGardenReviewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(TeaGardenReview teaGardenReview) {
        teaGardenReviewMapper.updateByPrimaryKeySelective(teaGardenReview);
    }

    @Override
    public TeaGardenReview get(int id) {
        return teaGardenReviewMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TeaGardenReview> listByTeaGardenId(Integer teaGarden_id) {
        TeaGardenReviewExample example = new TeaGardenReviewExample();
        example.or().andTeaGarden_idEqualTo(teaGarden_id);
        example.setAppointmentByClause("id desc");

        List<TeaGardenReview> teaGardenReviews = teaGardenReviewMapper.selectByExample(example);
        setUser(teaGardenReviews);
        return teaGardenReviews;
    }

    public void setUser(List<TeaGardenReview> teaGardenReviews) {
        for (TeaGardenReview teaGardenReview : teaGardenReviews) {
            setUser(teaGardenReview);
        }
    }

    private void setUser(TeaGardenReview teaGardenReview) {
        int user_id = teaGardenReview.getUser_id();
        User user = userService.get(user_id);
        teaGardenReview.setUser(user);
    }

    @Override
    public int getCount(int teaGarden_id) {
        return listByTeaGardenId(teaGarden_id).size();
    }
}
