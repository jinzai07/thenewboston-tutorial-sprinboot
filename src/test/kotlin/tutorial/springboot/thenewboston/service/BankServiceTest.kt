package tutorial.springboot.thenewboston.service

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import tutorial.springboot.thenewboston.datasource.BankDataSource

internal class BankServiceTest {

    private val dataSource: BankDataSource = mockk(relaxed = true)
    private val bankService = BankService(dataSource)

    @Test
    fun `should call its datasource to retrieve banks`() {
        //when
        val banks = bankService.getBanks()

        //then
        verify(exactly = 1) { dataSource.retrieveBanks() }
    
    }
}