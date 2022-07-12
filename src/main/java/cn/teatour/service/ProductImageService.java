package cn.teatour.service;

import cn.teatour.pojo.ProductImage;

import java.util.List;

public interface ProductImageService {

    void add(ProductImage image);

    void deleteByProductId(Integer product_id);

    void update(ProductImage image);

    ProductImage get(Integer id);

    List<ProductImage> list(Integer product_id);
}
