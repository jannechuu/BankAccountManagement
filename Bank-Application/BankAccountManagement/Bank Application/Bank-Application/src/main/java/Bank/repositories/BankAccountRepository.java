package Bank.repositories;

import Bank.entities.BankAccountEntity;
import Bank.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author janne
 */

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long>{
    
    @Query(value = " select * from tb_conta_bancaria cb "
                 + " inner join tb_cliente c on cb.ID_CLIENTE = c.ID_CLIENTE and c.NR_CPF_CNPJ = :document", nativeQuery = true)   
    public BankAccount findBalance(@Param("document") String document);
    
    @Modifying
    @Query(value = " update tb_conta_bancaria cb SET NR_SALDO = (NR_SALDO+ :values "
            + "where cb.NR_AGENCIA = :branch and cb.NR_CONTA = :account and cb.NR_CODIGO_BANCO = :bankCode)", nativeQuery = true)   
    public void deposit(@Param("branch") String branch, @Param("account") String account, @Param("bankCode") String bankCode, @Param("value") Double value);

    @Query(value = " select * from tb_conta_bancaria cb "
            + " where cb.NR_AGENCIA = :branch and cb.NR_CONTA = :account", nativeQuery = true)  
    public BankAccount findBankAccount(String branch, String account);

    @Modifying
    @Query(value = "update tb_conta_bancaria cb SET NR_SALDO = (NR_SALDO - :values "
            + "where cb.NR_AGENCIA = :branch and cb.NR_CONTA = :account)", nativeQuery = true) 
    public void withdraw(String branch, String account, Double value);
    
}
