package ru.netology

import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    // Case 1

    @Test
    fun calcCommission_case1_transferMonthLimitReached() {
    // arrange
        val case = "Maestro_Or_Mastercard"
        val amount = 150_000.0
        val previousAmount = 650_000.0
    // act
        var result = calcCommission(amount, previousAmount, case)
    // assert
        assertEquals(-10.0,result, 0.01)
    }

    @Test
    fun calcCommission_case1_transferDayLimitReached() {
        // arrange
        val case = "Maestro_Or_Mastercard"
        val amount = 330_000.0
        val previousAmount = 550_000.0
        // act
        var result = calcCommission(amount, previousAmount, case)
        // assert
        assertEquals(-1.0,result, 0.01)
    }

    @Test
    fun calcCommission_case1_activateCommission() {
    // arrange
        val case = "Maestro_Or_Mastercard"
        val amount = 100_000.0
        val previousAmount = 50_000.0
    // act
        var result = calcCommission(amount, previousAmount, case)
    // assert
        assertEquals(640.00,result, 0.01)
    }

    @Test
    fun calcCommission_case1_deactivateCommission() {
    // arrange
        val case = "Maestro_Or_Mastercard"
        val amount = 70_000.0
        val previousAmount = 50_000.0
    // act
        var result = calcCommission(amount, previousAmount, case)
    // assert
        assertEquals(0.00,result, 0.00)
    }

    @Test
    fun calcCommission_case1_defaultPreviousAmount() {
    // arrange
        val case = "Maestro_Or_Mastercard"
        val amount = 40_000.0
    // act
        var result = calcCommission(amount, case = case)
    // assert
        assertEquals(0.00,result, 0.01)
    }

    // Case 2

    @Test
    fun calcCommission_case2_transferMonthLimitReached() {
        // arrange
        val case = "Visa_Or_Mir"
        val amount = 140_000.0
        val previousAmount = 700_000.0
        // act
        var result = calcCommission(amount, previousAmount, case)
        // assert
        assertEquals(-1.0,result, 0.01)
    }

    @Test
    fun calcCommission_case2_transferDayLimitReached() {
        // arrange
        val case = "Visa_Or_Mir"
        val amount = 200_000.0
        val previousAmount = 600_000.0
        // act
        var result = calcCommission(amount, previousAmount, case)
        // assert
        assertEquals(-1.0,result, 0.01)
    }

    @Test
    fun calcCommission_case2_activateDefaultCommission() {
        // arrange
        val case = "Visa_Or_Mir"
        val amount = 4_000.0
        val previousAmount = 50_000.0
        // act
        var result = calcCommission(amount, previousAmount, case)
        // assert
        assertEquals(35.00,result, 0.01)
    }

    @Test
    fun calcCommission_case2_activateCommission() {
        // arrange
        val case = "Visa_Or_Mir"
        val amount = 30_000.0
        val previousAmount = 50_000.0
        // act
        var result = calcCommission(amount, previousAmount, case)
        // assert
        assertEquals(225.00,result, 0.01)
    }

    @Test
    fun calcCommission_case2_defaultPreviousAmount() {
        // arrange
        val case = "Visa_Or_Mir"
        val amount = 70_000.0
        // act
        var result = calcCommission(amount, case = case)
        // assert
        assertEquals(525.0,result, 0.01)
    }

    // Case 3

    @Test
    fun calcCommission_case3_transferMonthLimitReached() {
        // arrange
        val case = "VK_Pay"
        val amount = 10_000.0
        val previousAmount = 45_000.0
        // act
        var result = calcCommission(amount, previousAmount, case)
        // assert
        assertEquals(-1.0,result, 0.01)
    }
    @Test
    fun calcCommission_case3_transferDayLimitReached() {
        // arrange
        val case = "VK_Pay"
        val amount = 16_000.0
        val previousAmount = 30_000.0
        // act
        var result = calcCommission(amount, previousAmount, case)
        // assert
        assertEquals(-1.0,result, 0.01)
    }

    @Test
    fun calcCommission_case3_deactivateCommission() {
        // arrange
        val case = "VK_Pay"
        val amount = 5_000.0
        val previousAmount = 20_000.0
        // act
        var result = calcCommission(amount, previousAmount, case)
        // assert
        assertEquals(0.0,result, 0.01)
    }

    @Test
    fun calcCommission_case3_deactivateCommissionForDefaultCase() {
        // arrange
        // val case = "VK_Pay" -> commented out to check default case works
        val amount = 5_000.0
        val previousAmount = 20_000.0
        // act
        var result = calcCommission(amount, previousAmount)
        // assert
        assertEquals(0.0,result, 0.01)
    }

    // Case 4

    @Test
    fun calcCommission_case4_NonExistingTransferMethod() {
        // arrange
        val case = "Galaxy_Transfer"
        val amount = 1_000_000.0
        val previousAmount = 45_000_000.0
        // act
        var result = calcCommission(amount, previousAmount, case)
        // assert
        assertEquals(-1.0,result, 0.01)
    }

}