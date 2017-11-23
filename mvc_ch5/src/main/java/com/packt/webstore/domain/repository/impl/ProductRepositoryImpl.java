package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Product> result = jdbcTemplate.query("SELECT * FROM products", params, new ProductMapper());
        return result;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY =:category";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", category);
        return jdbcTemplate.query(SQL, params, new
                ProductMapper());
    }

    // http://localhost:8080/market/products/filter/params;categories=tablet;brands=Dell,Apple,google
    @Override
    public List<Product> getProductsByFilter(Map<String,
            List<String>> filterParams) {
        String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY IN (:categories ) AND MANUFACTURER IN ( :brands)";
        return jdbcTemplate.query(SQL, filterParams, new ProductMapper());
    }

    @Override
    public Product getProductById(String productID) {
        String SQL = "SELECT * FROM PRODUCTS WHERE ID = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", productID);
        try {
            return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
        } catch (DataAccessException e) {
            throw new ProductNotFoundException(productID);
        }
    }

    //    http://localhost:8080/market/products/Tablet/price;low=100;high=500?brand=Google
    @Override
    public List<Product> filterProducts(String brand, Map<String, String> filterPrice, String productCategory) {
        String SQL = "SELECT * FROM PRODUCTS WHERE manufacturer =:manufacturer AND category =:category AND unit_price <=:high AND unit_price >=:low";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("manufacturer", brand);
        params.put("category", productCategory);
        params.put("low", filterPrice.get("low"));
        params.put("high", filterPrice.get("high"));
        return jdbcTemplate.query(SQL, params, new ProductMapper());
    }

    //
    @Override
    public void addProduct(Product product) {
        String SQL = "INSERT INTO PRODUCTS (ID, "
                + "NAME,"
                + "DESCRIPTION,"
                + "UNIT_PRICE,"
                + "MANUFACTURER,"
                + "CATEGORY,"
                + "CONDITION1,"
                + "UNITS_IN_STOCK,"
                + "UNITS_IN_ORDER,"
                + "DISCONTINUED) "
                + "VALUES (:id, :name, :desc, :price, :manufacturer, :category, :condition, :inStock, :inOrder, :discontinued)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", product.getProductId());
        params.put("name", product.getName());
        params.put("desc", product.getDescription());
        params.put("price", product.getUnitPrice());
        params.put("manufacturer", product.getManufacturer());
        params.put("category", product.getCategory());
        params.put("condition", product.getCondition1());
        params.put("inStock", product.getUnitsInStock());
        params.put("inOrder", product.getUnitsInOrder());
        params.put("discontinued", product.isDiscontinued());
        jdbcTemplate.update(SQL, params);
    }

    private static final class ProductMapper implements
            RowMapper<Product> {
        public Product mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            Product product = new Product();
            product.setProductId(rs.getString("ID"));
            product.setName(rs.getString("NAME"));
            product.setDescription(rs.getString("DESCRIPTION"));
            product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
            product.setManufacturer(rs.getString("MANUFACTURER"));
            product.setCategory(rs.getString("CATEGORY"));
            product.setCondition1(rs.getString("CONDITION1"));
            product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
            product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
            product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
            return product;
        }
    }
}
