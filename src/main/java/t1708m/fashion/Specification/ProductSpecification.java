package t1708m.fashion.Specification;

import org.springframework.data.jpa.domain.Specification;
import t1708m.fashion.entity.Product;
import t1708m.fashion.entity.ProductCategory;

import javax.persistence.criteria.*;


public class ProductSpecification implements Specification<Product> {

    private SearchCriteria criteria;

    public ProductSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        if (criteria.getOperation().equalsIgnoreCase(">=")) {
            return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("<=")) {
            return builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("!=")) {
            return builder.notEqual(root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("=")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                        root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        } else if (criteria.getOperation().equalsIgnoreCase("joinProductCategory")) {
            Join<Product, ProductCategory> productCategoryJoin = root.join("category");
            Predicate predicate = builder.or(
                    builder.equal(productCategoryJoin.get("id"), criteria.getValue())
            );
            return predicate;
        } else if (criteria.getOperation().equalsIgnoreCase("join")) {
            Join<Product, ProductCategory> ProductCategoryJoin = root.join("category");
            Predicate predicate = builder.or(
                    builder.like(root.get("name"), "%" + criteria.getValue() + "%"),
                    builder.like(root.get("description"), "%" + criteria.getValue() + "%"),
                    builder.like(ProductCategoryJoin.get("name"), "%" + criteria.getValue() + "%")
            );
            return predicate;
        }
        return null;
    }
}
