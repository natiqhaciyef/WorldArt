package com.natiqhaciyef.worldart.ui.fragment.admin

import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.common.classes.Status
import com.natiqhaciyef.worldart.common.helpers.getNow
import com.natiqhaciyef.worldart.common.helpers.toSQLiteString
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.data.model.ArtistModel
import com.natiqhaciyef.worldart.data.model.PlaceModel
import com.natiqhaciyef.worldart.data.model.enums.AdCategories
import com.natiqhaciyef.worldart.data.model.enums.ArtField
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.domain.usecase.ad.InsertAdRemoteUseCase
import com.natiqhaciyef.worldart.domain.usecase.arch.InsertArchitectureRemoteUseCase
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminViewModel @Inject constructor(
    private val insertAdRemoteUseCase: InsertAdRemoteUseCase,
    private val insertArchitectureRemoteUseCase: InsertArchitectureRemoteUseCase,
) : BaseViewModel() {

    fun insertAd(adsModel: AdsModel = adModel){
        viewModelScope.launch {
            insertAdRemoteUseCase.invoke(UIResult(
                id = 0,
                data = adsModel,
                publishDate = getNow()
            )).collectLatest { result ->
                when(result.status){
                    Status.SUCCESS -> {
                        println("${result.data} Ads")
                    }
                    Status.ERROR -> {
                        println("${result.message} Ads")
                    }
                    Status.LOADING -> {}
                }
            }
        }
    }



    fun insertArch(archModel: ArchitectureModel = architectureModel){
        viewModelScope.launch {
            insertArchitectureRemoteUseCase.invoke(UIResult(
                id = 0,
                data = archModel,
                publishDate = getNow()
            )).collectLatest { result ->
                when(result.status){
                    Status.SUCCESS -> {
                        println("${result.data} Arch")
                    }
                    Status.ERROR -> {
                        println("${result.message} Arch")
                    }
                    Status.LOADING -> {}
                }
            }
        }
    }

    companion object{
        val adModel = AdsModel(
            title = "Stay fit",
            image = "https://t4.ftcdn.net/jpg/03/89/92/27/360_F_389922799_AZFyYZguDeEMoUdoROgEiJqfDPih1S12.jpg",
            description = "",
            date = getNow(),
            deadline = "06.01.2025 12:00",
            category = AdCategories.BRAND.title
        )

        val architectureModel = ArchitectureModel(
            title = "Pisa tower",
            image = "https://firebasestorage.googleapis.com/v0/b/worldart-9336a.appspot.com/o/Architectures%2Fpisa.jpeg?alt=media&token=651a37c4-1888-487b-b51f-8ed0fda82b7d",
            info = "The Leaning Tower of Pisa (Italian: torre pendente di Pisa), or simply the Tower of Pisa (torre di Pisa [ˈtorre di ˈpiːza; ˈpiːsa]), is the campanile, or freestanding bell tower, of Pisa Cathedral. It is known for its nearly four-degree lean, the result of an unstable foundation. The tower is one of three structures in the Pisa's Cathedral Square (Piazza del Duomo), which includes the cathedral and Pisa Baptistry.\n" +
                    "\n" +
                    "The height of the tower is 55.86 metres (183 feet 3 inches) from the ground on the low side and 56.67 m (185 ft 11 in) on the high side. The width of the walls at the base is 2.44 m (8 ft 0 in). Its weight is estimated at 14,500 tonnes (16,000 short tons). The tower has 296 or 294 steps; the seventh floor has two fewer steps on the north-facing staircase.\n" +
                    "\n" +
                    "The tower began to lean during construction in the 12th century, due to soft ground which could not properly support the structure's weight. It worsened through the completion of construction in the 14th century. By 1990, the tilt had reached 5.5 degrees. The structure was stabilized by remedial work between 1993 and 2001, which reduced the tilt to 3.97 degrees.",
            category = ArtField.ARCHITECTURE.title,
            history = null,
            architect = ArtistModel(
                id = 1,
                fullname = "Bonanno Pisano",
                birthPlace = "Pisa, Italy",
                deadPlace = "Pisa, Italy",
                birthYear = "1150",
                deadYear = "1200",
                age = 50,
                info = null,
                image = "https://firebasestorage.googleapis.com/v0/b/worldart-9336a.appspot.com/o/Artist%2FBonanno%20Pisano%20(Pisa%20tower).jpeg?alt=media&token=6c93890a-da97-4aec-ad18-1eba10796065",
                fields = listOf(ArtField.ARCHITECTURE.title).toSQLiteString()
            ),
            place = PlaceModel(
                id = 1,
                city = "Pisa",
                country = "Italy",
                image = "https://firebasestorage.googleapis.com/v0/b/worldart-9336a.appspot.com/o/Country%2Fitaly.jpeg?alt=media&token=48fe2140-0046-4e4d-9e31-7e1f232eaf84",
                flag = "https://cdn.countryflags.com/thumbs/italy/flag-400.png",
                capital = "Rome",
                info = null
            )
        )
    }
}