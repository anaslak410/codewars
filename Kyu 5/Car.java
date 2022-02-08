public class Car {
    public int length;
    public int doors;

    public Chassis chassis;

    public class Chassis {

        public String component;

        public Chassis() {
            component = layer1(component);

        }

        public String layer1(String input) {
            String result = new String(new char[length]).replace('\0', '-');
            StringBuilder myName = new StringBuilder(result);
            myName.setCharAt(1, 'o');
            myName.setCharAt(length - 3, 'o');
            myName.setCharAt(length - 1, '\'');

            if (length >= 12) {

                int front = 1;
                int back = length - 3;

                for (int i = 12; i <= length; i = i + 2) {
                    if (i % 4 == 0) {
                        front = front + 2;
                        myName.setCharAt(front, 'o');
                    } else {
                        back = back - 2;
                        myName.setCharAt(back, 'o');
                    }
                }
            }
            return myName.toString();
        }
    }

    public Body body;

    public class Body {

        public String component;

        public Body() {
            component = layer1(component);
            component = component + "\n" + layer2(component) + "\n";

        }

        public String layer1(String input) {
            String result = new String(new char[length - 2]).replace('\0', '_');
            StringBuilder myName = new StringBuilder(result);

            myName.setCharAt(0, ' ');

            return myName.toString();
        }

        public String layer2(String input) {
            String result = new String(new char[length - 1]).replace('\0', ' ');
            StringBuilder myName = new StringBuilder(result);

            myName.setCharAt(0, '|');
            myName.setCharAt(length - 2, '\\');
            myName.setCharAt(length - 3, ']');
            myName.setCharAt(length - 4, '[');

            for (int i = 2; i <= doors; i++) {
                if (i % 2 == 0) {
                    myName.setCharAt(i, ']');
                    myName.setCharAt(i - 1, '[');
                } else {
                    myName.setCharAt(length - i - 2, ']');
                    myName.setCharAt(length - i - 3, '[');
                }
            }
            return myName.toString();
        }
    }

    public Car(int length, int doors) {
        if (length < 7 || doors < 1 || (length / 2 - 2) < doors)
            throw new NullPointerException("please stop");
        this.length = length;
        this.doors = doors;

        Chassis chassis = new Chassis();
        this.chassis = chassis;

        Body body = new Body();
        this.body = body;
    }

}