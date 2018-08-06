package org.launchcode.models.data;

import org.launchcode.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */
@Repository
@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {
}
