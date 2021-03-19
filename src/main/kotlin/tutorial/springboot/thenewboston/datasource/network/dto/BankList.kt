package tutorial.springboot.thenewboston.datasource.network.dto

import tutorial.springboot.thenewboston.model.Bank

data class BankList (
    val results: Collection<Bank>
)