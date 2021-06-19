package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

    private List<Lotto> lottoList = new ArrayList<>();
    private LottoMachine lottoMachine;


    public void purchaseAutoLottoList(int buyCount){
        lottoMachine = new LottoMachine();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(lottoMachine.generateAutoLotto());
        }
    }

    public void purchaseManualLottoList(List<String> manualLottoList) {
        for (String manualLottoStr : manualLottoList) {
            lottoList.add(lottoMachine.generateManualLotto(manualLottoStr));
        }
    }
    public WinningStatistics getWinning(WinningLottoNumbers winningNumbers) {
        List<Rank> lottoRankList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            int numberOfWinnings = getNumberOfWinnings(lotto, winningNumbers.getWinningLottoNumbers());
            boolean bonus = isBonus(lotto, winningNumbers.getBonusNumber());
            Rank rank = Rank.getRank(numberOfWinnings, bonus);
            lottoRankList.add(rank);
        }

        return new WinningStatistics(lottoRankList, lottoList.size());
    }

    public boolean isBonus(Lotto lotto, LottoNumber bonusNumber) {
        return lotto.containsNumber(bonusNumber);
    }

    public int getNumberOfWinnings(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(lottoNumber -> winningLotto.containsNumber(lottoNumber))
                .count();
    }



    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
