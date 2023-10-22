package hr.kingict.springbootakademija2023_2.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private Amadeus amadeus;

    Logger logger = LoggerFactory.getLogger(FlightService.class);

    public List<Location> getAirports(String keyword) {

        Params params = Params
                .with("subType", Locations.AIRPORT)
                .and("keyword", keyword);

        try {
            Location[] locations = amadeus.referenceData.locations.get(params);
            return Arrays.asList(locations);
        } catch (Exception e) {

            logger.error("getAirports error", e);
            return Collections.emptyList();
        }
    }


    public List<FlightOfferSearch> getFlights(String originLocationCode, String destinationLocationCode, LocalDate departureDate, LocalDate returnDate, Integer adults) {

        Params params = Params
                .with("originLocationCode", originLocationCode)
                .and("destinationLocationCode", destinationLocationCode)
                .and("departureDate", departureDate.toString())
                .and("returnDate", returnDate.toString())
                .and("adults", adults)
                .and("nonStop", true)
                .and("max", 10);

        try {
            FlightOfferSearch[] flightOfferSearches = amadeus.shopping.flightOffersSearch.get(params);

            return Arrays.asList(flightOfferSearches);
        } catch (Exception e) {
            logger.error("getFlights neka greška: " + e.getMessage(), e);

            return Collections.emptyList();
        }


    }
}