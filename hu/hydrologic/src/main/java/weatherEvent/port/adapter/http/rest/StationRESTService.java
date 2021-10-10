package weatherEvent.port.adapter.http.rest;

import weatherEvent.Application.StationApplicationService;

import java.util.List;

public class StationRESTService {
    StationApplicationService applicationService = new StationApplicationService();

    public void weatherEventOnStation(String Uid, String mStationId, List<List<String>> measurements) {
        applicationService.weatherEventOnStation(Uid, mStationId, measurements);
    }
}
