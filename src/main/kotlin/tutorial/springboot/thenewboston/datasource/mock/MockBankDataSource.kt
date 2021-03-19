package tutorial.springboot.thenewboston.datasource.mock

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository
import tutorial.springboot.thenewboston.datasource.BankDataSource
import tutorial.springboot.thenewboston.model.Bank
import java.lang.IllegalArgumentException

@Repository
@Qualifier("mock")
class MockBankDataSource : BankDataSource {

    val banks = mutableListOf(
        Bank("1234", 1.2, 1),
        Bank("21", 3.2, 0),
        Bank("421", 0.0, 17)
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find bank with accountNumber $accountNumber")

    override fun createBank(bank: Bank): Bank {

        if (banks.any{ it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with accountNumber ${bank.accountNumber} is already existing")
        }
        banks.add(bank)

        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Could not find bank with account number ${bank.accountNumber}")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find bank with account number $accountNumber")

        banks.remove(currentBank)
    }
}