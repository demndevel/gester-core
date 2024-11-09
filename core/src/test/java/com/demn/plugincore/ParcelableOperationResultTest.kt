package com.demn.plugincore

import com.demn.plugincore.operationresult.BasicOperationResult
import com.demn.plugincore.operationresult.TransitionOperationResult
import com.demn.plugincore.parcelables.ParcelableOperationResult
import com.demn.plugincore.parcelables.toOperationResult
import kotlin.test.Test

class ParcelableOperationResultTest {
    @Test
    fun `ParcelableOperationResult with BasicOperationResult`() {
        val basicOperationResult = BasicOperationResult(
            text = "some sample text",
            label = "test",
            pinToTop = false
        )

        val parcelableOperationResult =
            ParcelableOperationResult.buildParcelableOperationResult(basicOperationResult)

        val convertedBasicOperationResult =
            parcelableOperationResult.toOperationResult() as BasicOperationResult

        assert(basicOperationResult == convertedBasicOperationResult)
    }

    @Test
    fun `ParcelableOperationResult with TransitionOperationResult`() {
        val transitionOperationResult = TransitionOperationResult(
            initialText = "initial text",
            initialDescription = "initial description",
            finalText = "final text",
            finalDescription = "final description"
        )

        val parcelableOperationResult =
            ParcelableOperationResult.buildParcelableOperationResult(transitionOperationResult)

        val convertedTransitionOperationResult =
            parcelableOperationResult.toOperationResult() as TransitionOperationResult


        assert(transitionOperationResult == convertedTransitionOperationResult)
    }
}