package com.demn.plugincore

import io.github.demndevel.gester.core.operationresult.BasicOperationResult
import io.github.demndevel.gester.core.operationresult.TransitionOperationResult
import io.github.demndevel.gester.core.parcelables.ParcelableOperationResult
import io.github.demndevel.gester.core.parcelables.toOperationResult
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
