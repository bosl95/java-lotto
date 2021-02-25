package lottogame.domain;

import lottogame.domain.lotto.Money;
import lottogame.utils.InvalidManualTicketQuantityException;

public class TicketMachine {
    private static final int TICKET_PRICE = 1000;

    public Money buyManualTicket(Money money, int quantity) {
        validateQuantityRange(money, quantity);
        return money.consume(quantity * TICKET_PRICE);
    }

    private void validateQuantityRange(Money money, int quantity) {
        if (!money.availableForPurchase(TICKET_PRICE * quantity)) {
            throw new InvalidManualTicketQuantityException();
        }
    }

    public int buyableAutoTicketQuantity(Money money) {
        return money.buyLotto(TICKET_PRICE);
    }
}
