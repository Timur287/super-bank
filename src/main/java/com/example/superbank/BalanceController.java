package com.example.superbank;

import com.example.superbank.entity.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@Slf4j
@RestController("/balance")
public class BalanceController {

    private final BankService bankService;


    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId){
        return bankService.getBalance(accountId);
    }

    @GetMapping("/accounts")
    public Map<Long,BigDecimal> getAllBalance(){
        return bankService.getAllBalance();
    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody Person transferBalance){
        return bankService.addMoney(transferBalance.getTo(),transferBalance.getAmount());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody Person transferBalance){
        bankService.makeTransfer(transferBalance);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return "MAMA, YA SLOMALSYA!!!";
    }
}
