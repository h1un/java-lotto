package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Rank;

import java.util.Map;

public class ResultView {

    public void resultBuyPrice(int buyCount) {
        System.out.println(buyCount + "개를 구매했습니다.");
    }

    public void resultLottoList(LottoList lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getAutoLotto());
        }
    }

    public void resultStatistics(Map<Rank, Long> winning) {

        for (Rank rank : Rank.values()) {
            if (winning.get(rank) != null) {
                System.out.println(rank.getMessage() + "(" + rank.getMoney() + "원) - " + winning.get(rank) + "개");
            } else {
                System.out.println(rank.getMessage() + "(" + rank.getMoney() + "원) - " + 0 + "개");
            }
        }

    }
}
