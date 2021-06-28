# 문자열 계산기
## 기능 요구사항
* [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (e.g. "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)
* [x] 쉼표(,) 또는 콜론(:)외에 커스텀 구분자를 지정할수 있다
 "//" "\n" 사이에 위치한 문자를 커스텀 구분자로 사용한다.
* [x] 문자열 계산기에 숫자이외의 값 또는 음수를 전달하는 경우 런타임입센션 예외를 처리한다.
# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능 요구사항
###1단계 - 로또 (자동)

* input view
  * [x] 구매금액 입력 
  * [x] 수동으로 구매할 로또 수 입력
  * [ ] 수동으로 (수동으로 구매할 로또 수만큼) 구매할 번호 입력
  * [ ] 지난주 당첨 번호 입력
  * [ ] 보너스 볼 입력
* output view
  * [ ] 수동&자동으로 뽑은 로또리스트 출력
  * [ ] 당첨 통계
  
* model
  * [ ] LottoNumber : [int] 로또 숫자 1 ~ 45
    * [x] 로또 번호 1부터 45까지만 들어가는 예외 처리
    * [x] 로또번호 정렬을 위한 Comparable 인터페이스 사용
  * [x] LottoNumbers : [List(LottoNumber)] 로또 숫자 목록
  * [x] Lotto : [set(LottoNumber)] 로또
  * [ ] Lottos : [List(Lotto)] 로또 목록
  * [ ] LottoMachine : 로또 자동 추첨기 return Lotto
  * [ ] ShuffleStrategy : 셔플
  * [ ] Rank : [Enum] 순위 
  * [ ] WinningStatistics : [Map<Rank, long>] 당첨통계 
  

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
