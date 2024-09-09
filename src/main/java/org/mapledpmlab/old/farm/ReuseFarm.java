package org.mapledpmlab.old.farm;

public class ReuseFarm extends Farm {

    public ReuseFarm() {
        this.setDescription("농장" +
                "\n1.주스탯 스페셜 SS : 주스탯 15" +
                "\n2.주스탯 스페셜 A+ : 주스탯 10" +
                "\n3.주스탯 SS : 주스탯 14" +
                "\n4.주스탯/부스탯 SS : 주스탯/부스탯 7" +
                "\n5.쁘띠 라니아 : 올스탯 20" +
                "\n6.오베론 : 올스탯 5" +
                "\n7.파풀라투스의 시계 : 올스탯 5" +
                "\n8.비급 : 데미지 1%" +
                "\n9.핑크빈 : 데미지 2%" +
                "\n10.검은 바이킹 : 데미지 2%" +
                "\n11.쁘띠 시그너스 : 데미지 3%" +
                "\n12.로맨티스트 킹슬라임 : 크리티컬 확률 3%" +
                "\n13.쁘띠 혼테일 : 크리티컬 확률 3%" +
                "\n14.쁘띠 팬텀 : 크리티컬 확률 4%" +
                "\n15.라즐리 : 크리티컬 확률 5%" +
                "\n16.쁘띠 힐라 : 크리티컬 데미지 2%" +
                "\n17.쁘띠 반레온 : 보스 공격 시 데미지 5%" +
                "\n18.쁘띠 랑 : 보스 공격 시 데미지 8%" +
                "\n19.라피스 : 몬스터 방어율 무시 5%" +
                "\n20.쁘띠 매그너스 : 몬스터 방어율 무시 5%" +
                "\n21.양철 나무꾼 : 몬스터 방어율 무시 6%" +
                "\n22.쁘띠 은월 : 재사용 대기시간 미적용 4%" +
                "\n23.큰 운영자의 벌룬 : 재사용 대기시간 미적용 2%" +
                "\n24.쁘띠 루미너스(어둠) : 공격력/마력 5" +
                "\n25.미르 : 공격력/마력 5" +
                "\n26.검은 마법사의 그림자 : 공격력/마력 6" +
                "\n27.쁘띠 루미너스(이퀄리브리엄) : % 미적용 공격력 마력 [LEVEL]/20" +
                "\n28.쁘띠 루미너스 빛 : 다수 공격 스킬의 공격 대상 +1"
        );
        this.addMainStat(10L);      // 주스탯스페셜A+
        this.addMainStat(14L);      // 주스탯SS
        this.addMainStat(15L);      // 주스탯스페셜SS
        this.addMainStat(7L);       // 주스탯/부스탯SS
        this.addSubStat(7L);
        this.addMainStat(5L);       // 오베론
        this.addSubStat(5L);
        this.addOtherStat1(5L);
        this.addOtherStat2(5L);
        this.addMainStat(5L);       // 파풀라투스의시계
        this.addSubStat(5L);
        this.addOtherStat1(5L);
        this.addOtherStat2(5L);
        this.addMainStat(20L);      // 쁘띠라니아
        this.addSubStat(20L);
        this.addOtherStat1(20L);
        this.addOtherStat2(20L);
        this.addDamage(1L);         // 비급
        this.addDamage(2L);         // 핑크빈
        this.addDamage(2L);         // 검은바이킹
        this.addDamage(3L);         // 쁘띠시그너스
        this.addCriticalP(3.0);     // 로맨티스트킹슬라임
        this.addCriticalP(3.0);     // 쁘띠혼테일
        this.addCriticalP(4.0);     // 쁘띠팬텀
        this.addCriticalP(5.0);     // 라즐리
        this.addCriticalDamage(2.0);// 쁘띠힐라
        this.addBossDamage(5L);     // 쁘띠반레온
        this.addBossDamage(8L);     // 쁘띠랑
        this.addIgnoreDefenseList(5L);   // 라피스
        this.addIgnoreDefenseList(5L);   // 쁘띠매그너스
        this.addIgnoreDefenseList(6L);   // 양철나무꾼
        this.addReuse(4.0);          // 쁘띠은월
        this.addReuse(2.0);          // 큰운영자의벌룬
        this.addAtt(5L);            // 쁘띠루미너스(어둠)
        this.addMagic(5L);
        this.addAtt(5L);            // 미르
        this.addMagic(5L);
        this.addAtt(6L);            // 검은마법사의그림자
        this.addMagic(6L);
        this.addPerXAtt((long) (275 / 20)); // 쁘띠루미너스(이퀄리브리엄)
        // 쁘띠루미너스(빛)
    }
}
