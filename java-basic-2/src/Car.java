public class Car extends Vehicle {
    private String modelName = "Mustang";   // Carクラスのフィールド

    public static void main(String[] args) {
        // Carオブジェクトの作成
        Car myCar = new Car();

        // CarオブジェクトでVehicleクラスのhonkメソッドを呼び出す
        myCar.honk();

        // Vehicleクラスのbrandフィールドにアクセス
        System.out.println(myCar.brand + " " + myCar.modelName);
    }
}