package cn.teatour.controller.admin;

import cn.teatour.pojo.NewProd;
import cn.teatour.pojo.NewProdCate;
import cn.teatour.pojo.NewProdImage;
import cn.teatour.service.NewProdCateService;
import cn.teatour.service.NewProdImageService;
import cn.teatour.service.NewProdService;
import cn.teatour.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * NewProd 控制器
 *
 * @author: @zj
 */
@Controller
@RequestMapping("/admin")
public class NewProdController {

    @Autowired
    NewProdCateService newProdCateService;

    @Autowired
    NewProdService newProdService;

    @Autowired
    NewProdImageService newProdImageService;

    @Autowired
    PropertyValueService propertyValueService;

    @RequestMapping("/listNewProd")
    public String list(Model model, Integer newProdCate_id) {
        List<NewProd> newProds = newProdService.list(newProdCate_id);
        model.addAttribute("newProds", newProds);
        NewProdCate newProdCate = newProdCateService.get(newProdCate_id);
        model.addAttribute("newProdCate", newProdCate);
        return "admin/listNewProd";
    }

    @RequestMapping("/addNewProd")
    public String add(NewProd newProd) {
        newProdService.add(newProd);

        // 创建新的 NewProd 时默认创建 5 个对应的 NewProdImage 数据
        NewProdImage newProdImage = new NewProdImage();
        newProdImage.setNewProd_id(newProd.getId());
        for (int i = 1; i <= 5; i++) {
            newProdImageService.add(newProdImage);
        }

        return "redirect:listNewProd?newProdCate_id=" + newProd.getNewProdCate_id();
    }

    @RequestMapping("/deleteNewProd")
    public String delete(Integer id, HttpServletRequest request) {

        // 在删除产品的时候将对应的 5 个 NewProdImage 数据也删除了
        newProdImageService.deleteByNewProdId(id);
        // 同时删除目录下的相关文件
        String path = request.getSession().getServletContext().getRealPath("" + id);
        deleteDir(new File(path));

//		// 删除外键对应的数据
//		propertyValueService.deleteByNewProdId(id);

        int newProdCate_id = newProdService.get(id).getNewProdCate_id();
        newProdService.delete(id);

        return "redirect:listNewProd?newProdCate_id=" + newProdCate_id;
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     * If a deletion fails, the method stops attempting to
     * delete and returns "false".
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    @RequestMapping("/editNewProd")
    public String edit(Integer id, Model model) {
        NewProd newProd = newProdService.get(id);
        model.addAttribute("newProd", newProd);
        NewProdCate newProdCate = newProdCateService.get(newProd.getNewProdCate_id());
        model.addAttribute("newProdCate", newProdCate);
        return "admin/editNewProd";
    }

    @RequestMapping("/updateNewProd")
    public String update(NewProd newProd) {
        newProdService.update(newProd);
        return "redirect:listNewProd?newProdCate_id=" + newProd.getNewProdCate_id();
    }
}
