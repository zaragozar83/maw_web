package com.coffee.maqzar.repository.impl;

import com.coffee.maqzar.domain.Product;
import com.coffee.maqzar.exception.ProductNotFoundException;
import com.coffee.maqzar.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        List<Product> result = new ArrayList<Product>();

        try{
            result = processListProducts(jdbcTemplate.query("SELECT * FROM SIC_P", params, new ProductMapper()));

            return result;
        }catch (DataAccessException e) {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public Product getProductById(Long productId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", productId);

        String query = "SELECT * FROM SIC_P WHERE ID = :id";

        try{
            Product product = jdbcTemplate.queryForObject(query, params, new ProductMapper());

            if(product == null){
                throw new ProductNotFoundException();
            }

            return product;
        }catch(DataAccessException e){
            throw new ProductNotFoundException(productId.toString());
        }
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

        List<Product> listProduct = new ArrayList<Product>();

        try{
            listProduct = processListProducts(jdbcTemplate.query(query, params, new ProductMapper()));

            return listProduct;
        }catch(DataAccessException e){
            throw new ProductNotFoundException();
        }
    }

    @Override
    public List<Product> getProductsByCategoryLike(String category) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", "%"+category+"%");

        String query = "SELECT * FROM SIC_P WHERE CATEGORY like :category";

        List<Product> listProducts = new ArrayList<Product>();

        try{

            listProducts = processListProducts(jdbcTemplate.query(query, params, new ProductMapper()));
            return listProducts;

        }catch(DataAccessException e){
            throw new ProductNotFoundException();
        }
    }

    @Override
    public List<Product> getProductsByCategoryAndPrice(Map<String, List<String>> params) {

        String query = "SELECT * FROM SIC_P WHERE category in(:category) AND UNIT_PRICE <= :price";

        List<Product> listProducts = new ArrayList<Product>();

        try{
            listProducts = processListProducts(jdbcTemplate.query(query, params, new ProductMapper()));
            return listProducts;
        }catch(DataAccessException e){
            throw new ProductNotFoundException();
        }
    }

    @Override
    public List<Product> getProductsByManufacturerAndPrice(String manufacturer, Long price) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("manufacturer", "%"+manufacturer+"%");
        params.put("price", price);

        String query = "SELECT * FROM SIC_P WHERE MANUFACTURER like :manufacturer AND UNIT_PRICE <= :price";

        List<Product> listProducts = new ArrayList<Product>();
        try{
            listProducts = processListProducts(jdbcTemplate.query(query, params, new ProductMapper()));
            return listProducts;
        }catch(DataAccessException e){
            throw new ProductNotFoundException();
        }
    }

    @Override
    public List<Product> getProductsByCriterias(String category, BigDecimal minPrice, BigDecimal maxPrice, String manufacturer) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", "%"+category+"%");
        params.put("minPrice", minPrice);
        params.put("maxPrice", maxPrice);
        params.put("manufacturer", "%"+manufacturer+"%");

        String query = "SELECT * FROM SIC_P WHERE CATEGORY like :category AND UNIT_PRICE BETWEEN :minPrice AND :maxPrice AND MANUFACTURER like :manufacturer";

        List<Product> listProduct = new ArrayList<Product>();
        try{
            listProduct = processListProducts(jdbcTemplate.query(query, params, new ProductMapper()));
            return listProduct;
        }catch (DataAccessException e){
            throw new ProductNotFoundException();
        }
    }

    @Override
    public int addProduct(Product product) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", product.getName());
        params.put("description", product.getDescription());
        params.put("unitPrice", product.getUnitPrice());
        params.put("manufacturer", product.getManufacturer());
        params.put("category", product.getCategory());
        params.put("condition", product.getCondition());
        params.put("unitStock", product.getUnitsInStock());
        params.put("unitOrder", product.getUnitsInOrder());
        params.put("discontinued", product.isDiscontinued());

        String query = "INSERT INTO SIC_P " +
                "(NAME," +
                "DESCRIPTION, " +
                "UNIT_PRICE, " +
                "MANUFACTURER, " +
                "CATEGORY, " +
                "CONDITION," +
                "UNITS_IN_STOCK," +
                "UNITS_IN_ORDER, " +
                "DISCONTINUED) " +
                "VALUES (" +
                ":name, " +
                ":description," +
                ":unitPrice," +
                ":manufacturer," +
                ":category," +
                ":condition," +
                ":unitStock," +
                ":unitOrder," +
                ":discontinued)";

        jdbcTemplate.update(query, params);

        String queryLastId = "SELECT TOP 1 ID FROM SIC_P ORDER BY ID DESC";

        Map<String, Object> params2 = new HashMap<String, Object>();

        int lastIdProduct = jdbcTemplate.queryForObject(queryLastId, params2, Integer.class);

        return lastIdProduct;
    }

    private List<Product> processListProducts(List<Product> listProducts){
        if(listProducts == null
                || listProducts.isEmpty()){
            throw new ProductNotFoundException();
        }
        return listProducts;
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
            product.setCategory(rs.getString("CATEGORY"));
            product.setCondition(rs.getString("CONDITION"));
            product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
            product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
            product.setDiscontinued(rs.getBoolean("DISCONTINUED"));

            return product;
        }
    }
}
