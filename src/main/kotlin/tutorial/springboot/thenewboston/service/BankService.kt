package tutorial.springboot.thenewboston.service

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import tutorial.springboot.thenewboston.datasource.BankDataSource
import tutorial.springboot.thenewboston.model.Bank

@Service
class BankService(@Qualifier("mock") private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()

    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)

    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

    fun deleteBank(accountNumber: String) = dataSource.deleteBank(accountNumber)
}