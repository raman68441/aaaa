package resources;

import java.util.Arrays;
import java.util.Map;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

    public AddPlace addPlacePayload() {
        AddPlace p = new AddPlace();
        Location l = new Location();

        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        p.setAccuracy(50);
        p.setName("kathriki ramanjaneylu");
        p.setPhone_number("(+91) 983 893 3937");
        p.setAddress("29, side layout, cohen 012");
        p.setTypes(Arrays.asList("shoe park", "shop"));
        p.setWebsite("http://google.com");
        p.setLanguage("French-IN");
        return p;
    }
//	public AddPlace addPlacePayloadFromExcel() {
//	    ExcelReader reader = new ExcelReader();
//	    Map<String, String> data = reader.getTestData("src/test/resources/AddPlaceData.xlsx", "Sheet1");
//
//	    Location l = new Location();
//	    l.setLat(Double.parseDouble(data.get("lat")));
//	    l.setLng(Double.parseDouble(data.get("lng")));
//
//	    AddPlace p = new AddPlace();
//	    p.setLocation(l);
//	    p.setAccuracy(Integer.parseInt(data.get("accuracy")));
//	    p.setName(data.get("name"));
//	    p.setPhone_number(data.get("phone_number"));
//	    p.setAddress(data.get("address"));
//	    p.setTypes(Arrays.asList(data.get("type1"), data.get("type2")));
//	    p.setWebsite(data.get("website"));
//	    p.setLanguage(data.get("language"));
//
//	    return p;
//	}
    public String updatePlacePayload(String placeId, String newAddress) {
        return "{\n" +
               "\"place_id\":\"" + placeId + "\",\n" +
               "\"address\":\"" + newAddress + "\",\n" +
               "\"key\":\"qaclick123\"\n" +
               "}";
    }

}
