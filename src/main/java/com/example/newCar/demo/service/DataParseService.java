package com.example.newCar.demo.service;

import com.example.newCar.demo.parseDto.CarDto;
import com.example.newCar.demo.parseDto.CarDetailDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataParseService {

    @Autowired
    DataIngestionService dataIngestionService;
    public void startDataParsingFromHtmlToJavaPojo() throws IOException {
        List<String> carUrlList = new ArrayList<>();

        for(int pageCount = 1; pageCount <= 9; pageCount++){
            String html = "https://www.cartrade.com/new-car-launches/p-%d/";
            String formattedURL = String.format(html, pageCount);
            Document doc = Jsoup.connect(formattedURL).get();
            Elements elements = doc.getElementsByClass("cars_list");
            for(Element elements1: elements){
                for(Element elements2: elements1.getElementsByClass("right_block")){
                    carUrlList.add(elements2.select("a").attr("href"));
                    System.out.println(elements2.select("a").attr("href"));
                }
            }
            pageCount++;
        }
        for(String carUrl : carUrlList){
            CarDto carDto = getCarDtoForURL(carUrl);
            dataIngestionService.transformAndIngestInDB(carDto);
        }
    }

    private CarDto getCarDtoForURL(String carUrl) throws IOException{
        CarDto carDto = new CarDto();
        try{
            Document doc = Jsoup.connect(carUrl).get();
//            Elements elements =
            Elements elements = doc.select("tbody.keySpecsBody tr");
            for(int i = 0; i < elements.size(); i++){
                String key = elements.get(i).select("th").text();
                String value = elements.get(i).select("td").text();
//                System.out.println(key  + " ------ " + value);
                if(key.equals("Price")) {
                    carDto.setPrice(value);
                }else if(key.equals("Fuel Type")){
                    carDto.setFuelType(value);
                }else if(key.equals("Seating Capacity")){
                    carDto.setSeatingCapacity(value);
                }else if(key.equals("Safety Rating")){
                    carDto.setSafetyRating(value);
                }else if(key.equals("Warranty")){
                    carDto.setWarranty(value);
                }else if(key.equals("Engine Size")){
                    carDto.setEngineSize(value);
                }else if(key.equals("Transmission")){
                    carDto.setTransmission(value);
                }else if(key.equals("Size")){
                    carDto.setSize(value);
                }else if(key.equals("Fuel Tank")){
                    carDto.setFuelTank(value);
                }else if(key.equals("Mileage")){
                    carDto.setMileage(value);
                }else if(key.equals("Ground Clearance (mm)")){
                    carDto.setGroundClearance(value);
                }
            }

//            for(int i = 0; i < elements.size(); i++){
//
//            }
//            System.out.println();
        }
        catch(Exception exception){
            System.out.println("Exception for url: "+ carUrl + " trace : "+ exception.getLocalizedMessage());
        }
        return carDto;
    }
}
