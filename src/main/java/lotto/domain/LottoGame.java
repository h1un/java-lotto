package lotto.domain;

import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {
    LottoList lottoList = new LottoList();
    WinningLottoNumbers winningLottoNumbers;

    final static int PRICE = 1000;

    public int getBuyCount(int buyPrice) {
        return buyPrice / PRICE;
    }

    public Lotto getLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.getAutoLotto();
    }

    public LottoList getLottoList(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(getLotto());
        }
        return lottoList;
    }

    public WinningLottoNumbers getWinningNumbers(String winningNumbers, int bonusNumber) {
        winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);

        return winningLottoNumbers;
    }


    public Map<Rank, Long> getWinning() {
        List<Rank> list = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int numberOfWinnings = 0;
            boolean bonus = false;
            for (int lottoNumber : lotto.getLottoNumbers()) {
                if (winningLottoNumbers.getWinningLottoNumbers().contains(lottoNumber)) {
                    numberOfWinnings++;
                }
            }
            if (lotto.getLottoNumbers().contains(winningLottoNumbers.getBonusNumber())) {
                bonus = true;
            }
            Rank rank = Rank.getRank(numberOfWinnings, bonus);
            list.add(rank);
        }
        Map<Rank, Long> collect = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        return collect;
    }


    public double getStatistics(Map<Rank,Long> statistics){


        return 0;
    }
}
