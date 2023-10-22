package hr.kingict.springbootakademija2023_2.mapper;


import com.amadeus.resources.FlightOfferSearch;
import hr.kingict.springbootakademija2023_2.dto.FlightSearchDto;
import org.springframework.stereotype.Component;

@Component
public class FlightOfferSearchFlightSearchDtoMapper {
    
    
    public FlightSearchDto map(FlightOfferSearch flightOfferSearch){
        
        if(flightOfferSearch == null){
            return null;
        }

        FlightSearchDto flightSearchDto = new FlightSearchDto();

        FlightOfferSearch.Itinerary outboundItinerary = flightOfferSearch.getItineraries()[0];
        FlightOfferSearch.Itinerary inboundItinerary = flightOfferSearch.getItineraries()[1];

        FlightOfferSearch.SearchSegment outboundSegment = outboundItinerary.getSegments()[0];
        FlightOfferSearch.SearchSegment inboundSegment = inboundItinerary.getSegments()[0];


        //outbound data
        flightSearchDto.setOutbundDepartureAirport(outboundSegment.getDeparture().getIataCode());
        flightSearchDto.setOutboundDepartureDate(outboundSegment.getDeparture().getAt());

        flightSearchDto.setOutboundArrivalAirport(outboundSegment.getArrival().getIataCode());
        flightSearchDto.setOutboundArrivalDate(outboundSegment.getArrival().getAt());

        flightSearchDto.setOutboundCarrier(outboundSegment.getCarrierCode());


        //inbound data
        flightSearchDto.setInboundDepartureAirport(inboundSegment.getDeparture().getIataCode());
        flightSearchDto.setInboundDepartureDate(inboundSegment.getDeparture().getAt());

        flightSearchDto.setInboundArrivalAirport(inboundSegment.getArrival().getIataCode());
        flightSearchDto.setInboundArrivalDate(inboundSegment.getArrival().getAt());

        flightSearchDto.setInboundCarrier(inboundSegment.getCarrierCode());

        flightSearchDto.setPrice(flightOfferSearch.getPrice().getTotal());


        return flightSearchDto;

    }
}
