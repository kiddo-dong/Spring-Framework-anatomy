package com.example.ch13_ex1.service;

import com.example.ch13_ex1.domain.Account;
import com.example.ch13_ex1.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
//@Transactional
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender,
                               long idReceiver,
                               BigDecimal amount){

        // find Id로 계좌 정보 호출 및 새 객체로 저장
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        // 게좌 잔고 및 송수신 logic
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount); // 송신자 잔액 -> sub(-)
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount); // 수신자 잔액 -> add(+)

        // DB Update 로직 호출(DATA Persistence)
        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

        //throw new RuntimeException("Transation error service rollback");
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAllAccounts();
    }

}
