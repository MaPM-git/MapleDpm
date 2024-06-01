package org.mapledpmlab.type.union;

public class AdeleUnion extends Union {

    public AdeleUnion() {
        super();
        this.setDescription("유니온 공격대 점령효과" +
                        "\n1.크리티컬 데미지 20%" +
                        "\n2.보스 공격 시 데미지 40%" +
                        "\n3.몬스터 방어율 무시 30%" +
                        "\n4.버프 지속시간 39%" +
                        "\n5.크리티컬 확률 1%" +
                        "\n6.공격력/마력 5" +
                        "\n7.주스탯 25" +
                        "\n8.부스탯 5" +
                        "\n\n유니온 공격대원 효과" +
                        "\n1.블래스터 250 : 몬스터 방어율 무시 5%" +
                        "\n2.데몬 어벤져 250 : 보스 공격 시 데미지 5%" +
                        "\n3.신궁 250 : 크리티컬 확률 5%" +
                        "\n4.메르세데스 250 : 스킬 재사용 대기시간 감소 6%" +
                        "\n5.와일드헌터 250 : 데미지 4%(공격시 20% 확률로 데미지 20% 증가)" +
                        "\n6.나이트로드 250 : 크리티컬 확률 5%" +
                        "\n7.은월 250 : 크리티컬 데미지 6%" +
                        "\n8.메카닉 250 : 버프 지속시간 25%" +
                        "\n9.메이플스토리M : 공격력/마력 20" +
                        "\n10.소울마스터 200 : HP 2000" +
                        "\n11.미하일 200 : HP 2000" +
                        "\n12.%미적용 주스탯 : 680" +
                        "\n13.%미적용 부스탯 : 440"
        );
        this.addPerXMainStat(640L);
        this.addPerXSubStat(400L);
        this.addPerXMainStat(40L);
        this.addPerXSubStat(40L);
        this.addPlusBuffDuration(-1L);
        this.addCriticalP(1.0);
    }
}
