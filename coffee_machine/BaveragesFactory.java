package coffee_machine;

public class BaveragesFactory {

    public Beverages produce(String type){
        switch (type) {
            case "hot_tea" -> {
                return new Beverages.Builder()
                        .hotWater(200)
                        .hotMilk(100)
                        .sugarSyrup(30)
                        .teaLeavesSyrup(30)
                        .build();
            }
            case "hot_coffee" -> {
                return new Beverages.Builder()
                        .hotMilk(400)
                        .hotWater(100)
                        .coffeeDecoration(50)
                        .sugarSyrup(30)
                        .build();
            }
            case "black_tea" -> {
                return new Beverages.Builder()
                        .hotWater(300)
                        .sugarSyrup(20)
                        .teaLeavesSyrup(30)
                        .build();
            }
            default -> {
                throw new RuntimeException("you entered wrong beverage");
            }
        }
    }
}
