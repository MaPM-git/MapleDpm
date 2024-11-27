package org.mapledpmlab.type.union;

public class DemonAvengerUnion extends Union {

    public DemonAvengerUnion() {
        super();
        this.setDescription("유니온 공격대 점령효과" +
                "\n1.크리티컬 데미지 20%" +        // 40
                "\n2.보스 공격 시 데미지 40%" +     // 40
                "\n3.몬스터 방어율 무시 40%" +      // 40
                "\n4.버프 지속시간 40%" +         // 40
                "\n5.공격력/마력 5" +            // 5
                "\n6.주스탯 1250" +            // 5
                "\n7.부스탯 5" +               // 1
                "\n\n유니온 공격대원 효과" +
                "\n1.블래스터 250 : 몬스터 방어율 무시 6%" +
                "\n2.데몬 어벤져 250 : 보스 공격 시 데미지 6%" +
                "\n3.신궁 250 : 크리티컬 확률 5%" +
                "\n4.메르세데스 250 : 스킬 재사용 대기시간 감소 6%" +
                "\n5.와일드헌터 250 : 데미지 4%(공격시 20% 확률로 데미지 20% 증가)" +
                "\n6.나이트로드 250 : 크리티컬 확률 5%" +
                "\n7.은월 250 : 크리티컬 데미지 6%" +
                "\n8.메카닉 250 : 버프 지속시간 25%" +
                "\n9.메이플스토리M : 공격력/마력 20" +
                "\n10.소울마스터 200 : HP 2000" +
                "\n11.미하일 200 : HP 2000" +
                "\n12.다크나이트 200 : HP 5%" +
                "\n13.제논 200 : 부스탯 40"
        );
        this.addPerXSubStat(640L);
        this.addPerXSubStat(40L);
        this.addHp(1250L);
        this.addMainStatP(5L);
        this.addPerXMainStat(2000L);              // 소울마스터
        this.addPerXMainStat(2000L);              // 미하일
        this.addMainStat(-25L);
    }
}
