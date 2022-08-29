package com.fpr.persistence;

import com.fpr.domain.Member;
import com.fpr.domain.SavingsProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<SavingsProduct, Long> {


    Member recommend(Integer age, String job);

    SavingsProduct search(String kor_co_nm);
}
