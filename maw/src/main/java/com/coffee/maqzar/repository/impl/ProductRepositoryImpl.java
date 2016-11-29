package com.coffee.maqzar.repository.impl;

import com.coffee.maqzar.domain.Product;
import com.coffee.maqzar.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getProducts() {
        Map<String, Object> params = new HashMap<String, Object>();

        List<Product> result = jdbcTemplate.query("SELECT * FROM SIC_P", params, new ProductMapper());

        return result;
    }

    @Override
    public Product getProductById(Long productId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", productId);

        String query = "SELECT * FROM SIC_P WHERE ID = :id";

        Product product = jdbcTemplate.queryForObject(query, params, new ProductMapper());
        return product;
    }

    @Override
    public void updateStock(long productId, long noUnits) {
        String query = "UPDATE SIC_P SET UNITS_IN_STOCK = :unitsInStock WHERE ID = :productId";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("unitsInStock", noUnits);
        params.put("productId", productId);

        jdbcTemplate.update(query, params);

    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", category);

        String query = "SELECT * FROM SIC_P WHERE CATEGORY = :category";

        List<Product> listProduct = jdbcTemplate.query(query, params, new ProductMapper());
        return listProduct;
    }

    @Override
    public List<Product> getProductsByCategoryLike(String category) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", "%"+category+"%");

        String query = "SELECT * FROM SIC_P WHERE CATEGORY like :category";

        List<Product> listProducts = jdbcTemplate.query(query, params, new ProductMapper());

        return listProducts;
    }

    @Override
    public List<Product> getProductsByCategoryAndPrice(Map<String, List<String>> params) {

        String query = "SELECT * FROM SIC_P WHERE category in(:category) AND UNIT_PRICE <= :price";

        List<Product> listProducts = jdbcTemplate.query(query, params, new ProductMapper());
        return listProducts;
    }

    @Override
    public List<Product> getProductsByManufacturerAndPrice(String manufacturer, Long price) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("manufacturer", "%"+manufacturer+"%");
        params.put("price", price);

        String query = "SELECT * FROM SIC_P WHERE MANUFACTURER like :manufacturer AND UNIT_PRICE <= :price";

        List<Product> listProducts = jdbcTemplate.query(query, params, new ProductMapper());

        return listProducts;
    }

    @Override
    public List<Product> getProductsByCriterias(String category, BigDecimal minPrice, BigDecimal maxPrice, String manufacturer) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", "%"+category+"%");
        params.put("minPrice", minPrice);
        params.put("maxPrice", maxPrice);
        params.put("manufacturer", "%"+manufacturer+"%");

        String query = "SELECT * FROM SIC_P WHERE CATEGORY like :category AND UNIT_PRICE BETWEEN :minPrice AND :maxPrice AND MANUFACTURER like :manufacturer";

        List<Product> listProduct = jdbcTemplate.query(query, params, new ProductMapper());
        return listProduct;
    }

    private static final class ProductMapper implements RowMapper<Product>{

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductId(rs.getLong("ID"));
            product.setName(rs.getString("NAME"));
            product.setDescription(rs.getString("DESCRIPTION"));
            product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
            product.setManufacturer(rs.getString("MANUFACTURER"));
            product.setCategory("CATEGORY");
            product.setCondition("CONDITION");
            product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
            product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
            product.setDiscontinued(rs.getBoolean("DISCONTINUED"));

            return product;
        }
    }
}
