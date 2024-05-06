package org.mapledpmlab.type.union;

import org.mapledpmlab.type.etc.Common;

public class Union extends Common {

    public Union() {
        this.setDescription("" +
                "유니온 공격대 점령효과" +
                "\n1.크리티컬 데미지 20%" +
                "\n2.보스 공격 시 데미지 40%" +
                "\n3.몬스터 방어율 무시 30%" +
                "\n4.버프 지속시간 40%" +
                "\n5.공격력/마력 5" +
                "\n6.주스탯 25" +
                "\n7.부스탯 5" +
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
                "\n11.미하일 200 : HP 2000"
        );
        this.addIgnoreDefenseList(5L);  // 블래스터
        this.addBossDamage(6L);         // 데몬어벤져
        this.addCriticalP(5.0);         // 신궁
        this.addCooldownReductionP(6L); // 메르세데스
        this.addStatXDamage(4L);        // 와일드헌터
        this.addCriticalP(5.0);         // 나이트로드
        this.addCriticalDamage(6.0);    // 은월
        this.addPlusBuffDuration(25L);  // 메카닉
        this.addAtt(20L);               // 메이플스토리M
        this.addMagic(20L);

        this.addCriticalDamage(20.0);   // 공격대 점령
        this.addBossDamage(40L);
        this.addIgnoreDefenseList(30L);
        this.addPlusBuffDuration(40L);
        this.addAtt(5L);
        this.addMagic(5L);
        this.addMainStat(25L);
        this.addSubStat(5L);
    }
}
