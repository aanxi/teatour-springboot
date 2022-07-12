package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.TeaGardenMapper;
import cn.teatour.pojo.TeaGarden;
import cn.teatour.pojo.TeaGardenCategory;
import cn.teatour.pojo.TeaGardenExample;
import cn.teatour.service.TeaGardenReviewService;
import cn.teatour.service.TeaGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TeaGardenService 实现类
 *
 * @author: @zj
 * @create: 2022-04-27-下午 20:16
 */
@Service
public class TeaGardenServiceImpl implements TeaGardenService {

    @Autowired
    TeaGardenMapper teaGardenMapper;

    @Autowired
    TeaGardenReviewService teaGardenReviewService;

    @Override
    public void add(TeaGarden teaGarden) {
        teaGardenMapper.insert(teaGarden);
    }

    @Override
    public void delete(Integer id) {
        teaGardenMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(TeaGarden teaGarden) {
        teaGardenMapper.updateByPrimaryKey(teaGarden);
    }

    @Override
    public TeaGarden get(Integer id) {
        return teaGardenMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TeaGarden> list(Integer teaGardenCategory_id) {
        TeaGardenExample example = new TeaGardenExample();
        example.or().andTeaGardenCategory_idEqualTo(teaGardenCategory_id);
        List<TeaGarden> teaGardens = teaGardenMapper.selectByExample(example);
        return teaGardens;
    }

    @Override
    public void fill(List<TeaGardenCategory> categories) {
        for (TeaGardenCategory teaGardenCategory : categories) {
            fill(teaGardenCategory);
        }
    }

    @Override
    public void fill(TeaGardenCategory teaGardenCategory) {
        List<TeaGarden> teaGardens = list(teaGardenCategory.getId());
        teaGardenCategory.setTeaGardens(teaGardens);
    }

    @Override
    public void fillByRow(List<TeaGardenCategory> categories) {
        int teaGardenNumberOfEachRow = 8;
        for (TeaGardenCategory teaGardenCategory : categories) {
            List<TeaGarden> teaGardens = teaGardenCategory.getTeaGardens();
            List<List<TeaGarden>> teaGardenByRow = new ArrayList<>();
            for (int i = 0; i < teaGardens.size(); i += teaGardenNumberOfEachRow) {
                int size = i + teaGardenNumberOfEachRow;
                size = size > teaGardens.size() ? teaGardens.size() : size;
                List<TeaGarden> teaGardensOfEachRow = teaGardens.subList(i, size);
                teaGardenByRow.add(teaGardensOfEachRow);
            }
            teaGardenCategory.setTeaGardenByRow(teaGardenByRow);
        }
    }

    @Override
    public void setTeaGardenReviewCount(TeaGarden teaGarden) {
        int teaGardenReviewCount = teaGardenReviewService.getCount(teaGarden.getId());
        teaGarden.setTeaGardenReviewCount(teaGardenReviewCount);
    }

    @Override
    public List<TeaGarden> search(String keyword) {
        TeaGardenExample example = new TeaGardenExample();
        example.or().andNameLike("%" + keyword + "%");
        example.setAppointmentByClause("id desc");
        return teaGardenMapper.selectByExample(example);
    }
}
