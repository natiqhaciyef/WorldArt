package com.natiqhaciyef.worldart.ui.base

import com.natiqhaciyef.worldart.ui.model.ArtFieldModel

object BaseNavigationDeepLink {
    private const val ARCHITECTURE_DEEPLINK = "wa://architecture/details"
    private const val HISTORY_DEEPLINK = "wa://history/details"
    private const val PAINTING_DEEPLINK = "wa://painting/details"
    private const val SCIENCE_DEEPLINK = "wa://science/details"
    private const val TRAVEL_DEEPLINK = "wa://travel/details"
    private const val CUSTOM_DEEPLINK = "wa://custom/details"

    fun getDeepLink(artFieldModel: ArtFieldModel) = when (artFieldModel.title) {
        "Architecture" -> {
            ARCHITECTURE_DEEPLINK
        }

        "History" -> {
            HISTORY_DEEPLINK
        }

        "Painting" -> {
            PAINTING_DEEPLINK
        }

        "Science" -> {
            SCIENCE_DEEPLINK
        }

        "Travel" -> {
            TRAVEL_DEEPLINK
        }

        "Custom" -> {
            CUSTOM_DEEPLINK
        }

        else -> {
            CUSTOM_DEEPLINK
        }
    }
}