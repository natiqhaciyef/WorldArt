package com.natiqhaciyef.worldart.ui.base

import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.ui.model.ArtFieldModel

object BaseNavigationDeepLink {
    const val ARCHITECTURE_MAIN_DEEPLINK = "wa://architecture/main"
    const val HISTORY_MAIN_DEEPLINK = "wa://history/main"
    const val PAINTING_MAIN_DEEPLINK = "wa://painting/main"
    const val SCIENCE_MAIN_DEEPLINK = "wa://science/main"
    const val TRAVEL_MAIN_DEEPLINK = "wa://travel/main"
    const val CUSTOM_MAIN_DEEPLINK = "wa://custom/main"

    val ARCHITECTURE_NAVIGATION = R.id.architectureMainFragment
    val HISTORY_NAVIGATION = R.id.architectureMainFragment
    val PAINTING_NAVIGATION = R.id.architectureMainFragment
    val SCIENCE_NAVIGATION = R.id.architectureMainFragment
    val TRAVEL_NAVIGATION = R.id.architectureMainFragment
    val CUSTOM_NAVIGATION = R.id.architectureMainFragment

    fun getDeepLink(artFieldModel: ArtFieldModel) = when (artFieldModel.title) {
        "Architecture" -> {
            ARCHITECTURE_MAIN_DEEPLINK
        }

        "History" -> {
            HISTORY_MAIN_DEEPLINK
        }

        "Painting" -> {
            PAINTING_MAIN_DEEPLINK
        }

        "Science" -> {
            SCIENCE_MAIN_DEEPLINK
        }

        "Travel" -> {
            TRAVEL_MAIN_DEEPLINK
        }

        "Custom" -> {
            CUSTOM_MAIN_DEEPLINK
        }

        else -> {
            CUSTOM_MAIN_DEEPLINK
        }
    }

    fun getNavGraph(artFieldModel: ArtFieldModel) = when (artFieldModel.title) {
        "Architecture" -> {
            ARCHITECTURE_NAVIGATION
        }

        "History" -> {
            HISTORY_NAVIGATION
        }

        "Painting" -> {
            PAINTING_NAVIGATION
        }

        "Science" -> {
            SCIENCE_NAVIGATION
        }

        "Travel" -> {
            TRAVEL_NAVIGATION
        }

        "Custom" -> {
            CUSTOM_NAVIGATION
        }

        else -> {
            CUSTOM_NAVIGATION
        }
    }
}