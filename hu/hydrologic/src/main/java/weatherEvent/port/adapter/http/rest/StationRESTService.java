package weatherEvent.port.adapter.http.rest;

import weatherEvent.Application.StationApplicationService;

import java.util.List;

public class StationRESTService {
    StationApplicationService applicationService = new StationApplicationService();

    public void weatherEventOnStation(String Uid, String mStationId, List<List<String>> measurements) {
        try {
            applicationService.weatherEventOnStation(Uid, mStationId, measurements);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
