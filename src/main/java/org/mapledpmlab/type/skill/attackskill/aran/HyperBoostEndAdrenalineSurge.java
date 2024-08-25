package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HyperBoostEndAdrenalineSurge extends AttackSkill {
    public HyperBoostEndAdrenalineSurge() {
        this.setName("하이퍼 부스트 엔드-아드레날린 서지(초각성)");
        this.setDamage(1430.0);
        this.setAttackCount(14L);
        this.setDelay(420L);
        this.setDotDuration(6000L);
        this.setInterval(300L);
        this.setCooldown(30.0);
        this.setAddDamage(30L);         // 부스트 엔드-리인포스
        this.addIgnoreDefenseList(20L); // 부스트 엔드-이그노어 가드
        this.addFinalDamage(1.6);       // 코어강화
    }
}
