package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.ProductMapper;
import cn.teatour.pojo.Category;
import cn.teatour.pojo.Product;
import cn.teatour.pojo.ProductExample;
import cn.teatour.service.ProductService;
import cn.teatour.service.ReviewService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductService 实现类
 *
 * @author: @zj
 * @create: 2022-04-27-下午 20:16
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ReviewService reviewService;

    @Override
    public void add(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void delete(Integer id) {
        productMapper.deleteById(id);
    }

    @Override
    public void update(Product product) {
        productMapper.updateById(product);
    }

    @Override
    public Product get(Integer id) {
        return productMapper.selectById(id);
    }

    @Override
    public List<Product> list(Integer category_id) {
//        ProductExample example = new ProductExample();
//        example.or().andCategory_idEqualTo(category_id);
        List<Product> products = productMapper.selectList(new QueryWrapper<Product>()
                .eq("category_id",category_id));
        return products;
    }

    @Override
    public void fill(List<Category> categories) {
        for (Category category : categories) {
            fill(category);
        }
    }

    @Override
    public void fill(Category category) {
        List<Product> products = list(category.getId());
        category.setProducts(products);
    }

    @Override
    public void fillByRow(List<Category> categories) {
        int productNumberOfEachRow = 8;
        for (Category category : categories) {
            List<Product> products = category.getProducts();
            List<List<Product>> productByRow = new ArrayList<>();
            for (int i = 0; i < products.size(); i += productNumberOfEachRow) {
                int size = i + productNumberOfEachRow;
                size = size > products.size() ? products.size() : size;
                List<Product> productsOfEachRow = products.subList(i, size);
                productByRow.add(productsOfEachRow);
            }
            category.setProductByRow(productByRow);
        }
    }

    @Override
    public void setReviewCount(Product product) {
        int reviewCount = reviewService.getReviewCount(product.getId());
        product.setReviewCount(reviewCount);
    }

    @Override
    public List<Product> search(String keyword) {
        return productMapper.selectList(new QueryWrapper<Product>()
                .like("name","%"+ keyword + "%"));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void updateSaleAndStock(Integer product_id, Integer number) {
        int newStock = productMapper.selectProductStockAndLock(product_id) - number;
        int newSale = productMapper.selectProductSaleAndLock(product_id) + number;
        productMapper.updateSaleAndStock(product_id, newStock, newSale);

    }
}
