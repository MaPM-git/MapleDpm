package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BoostEndAdrenalineSurge extends AttackSkill {
    public BoostEndAdrenalineSurge() {
        this.setName("부스트 엔드-아드레날린 서지(부스트)");
        this.setDamage(1320.0);
        this.setAttackCount(14L);
        this.setDelayByAttackSpeed(420L);
        this.setDotDuration(6000L);
        this.setInterval(300L);
        this.setCooldown(30.0);
        this.addFinalDamage(1.6);       // 코어강화
        this.setAddDamage(30L);         // 부스트 엔드-리인포스
        this.addIgnoreDefenseList(20L); // 부스트 엔드-이그노어 가드
    }
}
