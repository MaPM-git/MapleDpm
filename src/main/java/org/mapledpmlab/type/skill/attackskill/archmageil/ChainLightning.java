package org.mapledpmlab.type.skill.attackskill.archmageil;

public class ChainLightning extends ThunderAttack {
    public ChainLightning() {
        this.setName("체인 라이트닝");
        this.setDamage(335.0);
        this.setAttackCount(10L + 1);       // 체인 라이트닝-보너스 어택
        this.setDelayByAttackSpeed(780L);
        this.setAddDamage(20L);             // 체인 라이트닝-리인포스
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(60L);             // 프로스트 이펙트
    }
}
