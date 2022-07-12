package cn.teatour.controller.admin;

import cn.teatour.pojo.NewProd;
import cn.teatour.pojo.NewProdImage;
import cn.teatour.service.NewProdImageService;
import cn.teatour.service.NewProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * NewProdImage 的控制器
 *
 * @author: @zj
 * @create: 2022-04-28-下午 14:10
 */
@Controller
@RequestMapping("/admin")
public class NewProdImageController {

    @Autowired
    NewProdImageService newProdImageService;

    @Autowired
    NewProdService newProdService;

    @RequestMapping("/editNewProdImage")
    public String edit(Model model, Integer newProd_id) {
        List<NewProdImage> newProdImages = newProdImageService.list(newProd_id);
        model.addAttribute("newProdImages", newProdImages);
        NewProd newProd = newProdService.get(newProd_id);
        model.addAttribute("newProd", newProd);
        return "admin/editNewProdImage";
    }

    @RequestMapping(value = "/updateNewProdImage", method = RequestMethod.POST)
    public String update(HttpServletRequest request,
//						 @RequestParam("newProdImage") NewProdImage newProdImage,
                         Integer newProd_id,
                         Integer id,
                         @RequestParam("picture") MultipartFile picture) {

        // 上传文件到指定位置
        String filePath = request.getSession().getServletContext()
                .getRealPath("img/newProd/" + newProd_id);
        // 因为 id 是自增长键，所以需要 % 5 来作为文件名
        String fileName = (id % 5 == 0 ? 5 : id % 5) + ".jpg";
        File uploadPicture = new File(filePath, fileName);
        if (!uploadPicture.exists()) {
            uploadPicture.mkdirs();
        }
        // 保存
        try {
            picture.transferTo(uploadPicture);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:editNewProdImage?newProd_id=" + newProd_id;
    }

    @RequestMapping("/deleteNewProdImage")
    public String delete(Integer id, Integer newProd_id, HttpServletRequest request) {
        // 不删除表中的数据（在 NewProdController 中统一删除），删除对应文件
        String filePath = request.getSession().getServletContext()
                .getRealPath("img/newProd/" + newProd_id);
        String fileName = id + ".jpg";
        new File(filePath, fileName).delete();

        return "redirect:editNewProdImage?newProd_id=" + newProd_id;
    }
}
