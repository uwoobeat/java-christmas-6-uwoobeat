package christmas;

import christmas.common.manager.EventPlanner;
import christmas.common.view.InputView;
import christmas.common.view.OutputView;

public class Application {
    public static void main(String[] args) {
        EventPlanner eventPlanner = new EventPlanner(new InputView(), new OutputView());
        eventPlanner.run();
    }
}
