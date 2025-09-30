package com.example.Account_Transaction.service;

import com.example.Account_Transaction.domain.Account;
import com.example.Account_Transaction.domain.TransferAmountDTO;
import com.example.Account_Transaction.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class AccountServiceImp implements AccountService{

    private final Logger logger = Logger.getLogger(AccountServiceImp.class.getName());
    private final AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void addAccount(Account account) {
        accountRepository.addAccount(account);
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteAccountById(id);
    }

    @Override
    public Account findAccountById(Long id){
        return accountRepository.findAccountById(id);
    }

    @Override
    public List<Account> findAllAccount(){
        return accountRepository.findAllAccount();
    }

    // 송금 / 입금 트랜잭션 logic
    @Override
    public void transferAmountTransaction(TransferAmountDTO transferAmountDTO) {
        // 송금자 / 입금자 객체 생성 및 바인딩
        Account sender = accountRepository.findAccountById(transferAmountDTO.getSenderId());
        Account receiver = accountRepository.findAccountById(transferAmountDTO.getReceiverId());

        // 송금자와 수신자가 동일
        if (sender.getId().equals(receiver.getId())) {
            logger.severe("sender & receiver same account");

            throw new IllegalArgumentException("송금자와 수신자가 같습니다.");
        }
        
        // 송금자의 잔액이 송금 금액 만큼 존재하는지 확인
        if(sender.getAmount().compareTo(transferAmountDTO.getAmount()) < 0){
            logger.severe("sender error");

            throw new RuntimeException("잔액 부족");
        }

        // 새 잔액에 송금 입금 후 금액 바인딩
        BigDecimal senderNewAmount = sender.getAmount().subtract(transferAmountDTO.getAmount());
        BigDecimal receiverNewAmount = receiver.getAmount().add(transferAmountDTO.getAmount());

        // 송금자 / 입금자 잔액 변경
        accountRepository.UpdateTransferAmount(senderNewAmount, sender.getId());
        accountRepository.UpdateTransferAmount(receiverNewAmount, receiver.getId());
    }

}
