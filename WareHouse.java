package org.example;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

// questa e una singelton l'ho presa da https://www.baeldung.com/java-singleton
//con un po di modifike
public final class WareHouse {
    Gson gson = new Gson();
    private static WareHouse INSTANCE;

    List<Car> carsList = new ArrayList<>();

    private WareHouse() {
        //query if db
        this.carsList.add(new Car(11,"bmw", 3594.9));
        this.carsList.add(new Car(12,"audi", 38346.9));
        this.carsList.add(new Car(13,"ferrari", 130000.0));
    }

    public static WareHouse getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new org.example.WareHouse();
        }

        return INSTANCE;
    }

    void addCar(Car car) {
        carsList.add(car);
    }

    void removeCar(Car product) {
        carsList.remove(product);
    }

    int numberCar() {
        return carsList.size();
    }


    Object allSorted() {
        carsList.sort((o1, o2) -> {
            return o1.getBrand().compareTo(o2.getBrand());
        });

        return carsList;
    }

    Object moreExpensive(){
        carsList.sort((o1, o2) -> {
            if (o1.getPrice()>o2.getPrice())
                return 1;
            if (o1.getPrice()<o2.getPrice())
                return -1;
            return 0;
        });
        return carsList ;
    }

    //questo metodo premde carlist e la trasforma in un jsonformat
    String ToJSon() {

        String jsonStr = gson.toJson(carsList);
        return jsonStr;
    }
    String moreExptoJson (){
        String jsonExpensive = gson.toJson(moreExpensive());
        return jsonExpensive;
    }
    String allSortedJson(){
        String jsonSorted = gson.toJson(allSorted());
        return jsonSorted;
    }


}

