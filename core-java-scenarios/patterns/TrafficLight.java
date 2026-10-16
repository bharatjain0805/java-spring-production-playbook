package patterns;

public class TrafficLight {
    public static void processSignal(String lightColor, boolean pedestrianWaiting, boolean emergencyVehicle) {
        switch (lightColor.toUpperCase()) {
            case "RED" -> System.out.println("Stop");
            case "YELLOW" -> {
                if (pedestrianWaiting) {
                    System.out.println("Stop, pedestrian crossing");
                } else {
                    System.out.println("Slow down");
                }
            }
            case "GREEN" -> {
                if (emergencyVehicle) {
                    System.out.println("Give way to emergency vehicle");
                } else {
                    System.out.println("Go");
                }
            }
            default -> System.out.println("Invalid Signal");
        }
    }
}