package com.kursatkumsuz.bootcampfinalprojecttravelapp.domain.usecase

import com.kursatkumsuz.bootcampfinalprojecttravelapp.domain.model.TravelModel
import com.kursatkumsuz.bootcampfinalprojecttravelapp.domain.repository.HomeRepository
import com.kursatkumsuz.bootcampfinalprojecttravelapp.util.Resource
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    /**
     * Gets all data
     * Checks whether response is successful or not
     * @return [Resource]
     */
    suspend fun getAllList() : Resource<List<TravelModel>> {

        return try {
            val response = homeRepository.getAllList()

            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("No Data", null)
            } else {
                Resource.error("Error" , null)
            }
        } catch (e: Exception) {
            Resource.error("No Data", null)
        }
    }

    /**
     * Gets category flight data
     * Checks whether response is successful or not
     * @return [Resource]
     */
    suspend fun getFlightList() : Resource<List<TravelModel>> {

        return try {
            val response = homeRepository.getFlightList()

            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("No Data", null)
            } else {
                Resource.error("Error" , null)
            }
        } catch (e: Exception) {
            Resource.error("No Data", null)
        }
    }

    /**
     * Gets category hotel data
     * Checks whether response is successful or not
     * @return [Resource]
     */
    suspend fun getHotelList() : Resource<List<TravelModel>> {

        return try {
            val response = homeRepository.getHotelList()

            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("No Data", null)
            } else {
                Resource.error("Error" , null)
            }
        } catch (e: Exception) {
            Resource.error("No Data", null)
        }
    }

    /**
     * Gets category transportation data
     * Checks whether response is successful or not
     * @return [Resource]
     */
    suspend fun getTransportationList() : Resource<List<TravelModel>> {

        return try {
            val response = homeRepository.getTransportationList()

            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("No Data", null)
            } else {
                Resource.error("Error" , null)
            }
        } catch (e: Exception) {
            Resource.error("No Data", null)
        }
    }


}