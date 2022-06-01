package com.example.superbank;

import com.example.superbank.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@AllArgsConstructor
public class BankService {

    private final BalanceRepository repository;

    public BigDecimal getBalance(Long accountId) {
        BigDecimal balance = repository.getBalanceForId(accountId);
        if(balance==null){
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {

        if(repository.getBalanceForId(to) == null){
          repository.save(to,amount);
          return amount;
        }

        BigDecimal updateBalance = repository.getBalanceForId(to).add(amount);
        repository.save(to,updateBalance);
        return updateBalance;
    }

    public void makeTransfer(Person transferBalance) {
       BigDecimal fromBalance = repository.getBalanceForId(transferBalance.getFrom());
       BigDecimal toBalance = repository.getBalanceForId(transferBalance.getTo());

       if(fromBalance==null || toBalance == null) {
           throw new IllegalArgumentException("I don't know this client... =(");
       }


       if(transferBalance.getAmount().compareTo(fromBalance)> 0){
            throw new IllegalArgumentException("no money");
       }
       BigDecimal newFromBalance = fromBalance.subtract(transferBalance.getAmount());
       BigDecimal newToBalance = toBalance.add(transferBalance.getAmount());

       repository.save(transferBalance.getFrom(), newFromBalance);
       repository.save(transferBalance.getTo(),newToBalance);
    }

    public Map<Long, BigDecimal> getAllBalance() {
        return repository.getAllMoneyFromAllAccounts();
    }
}
