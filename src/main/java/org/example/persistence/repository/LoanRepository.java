package org.example.persistence.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import org.example.persistence.entity.LoanEntity;

import java.util.List;

@Stateless
public class LoanRepository extends BaseRepository<LoanEntity, Long>{

    public LoanRepository(){
        super(LoanEntity.class);
    }

    public List<LoanEntity> findActiveLoans() {
        TypedQuery<LoanEntity> query = entityManager.createQuery(
                "SELECT l FROM Loan l WHERE l.returnDate IS NULL", LoanEntity.class);
        return query.getResultList();
    }

    public List<LoanEntity> findLoansByUser(Long userId) {
        TypedQuery<LoanEntity> query = entityManager.createQuery(
                "SELECT l FROM Loan l WHERE l.user.id = :userId", LoanEntity.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
