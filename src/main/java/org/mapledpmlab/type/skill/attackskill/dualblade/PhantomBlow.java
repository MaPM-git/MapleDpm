package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhantomBlow extends AttackSkill {
    public PhantomBlow() {
        this.setName("팬텀 블로우");
        this.setAttackCount(14L);    // 팬텀 블로우-보너스 어택
        this.setDamage(530.0 + 106);
        this.addIgnoreDefenseList(40L);
        this.setDelayByAttackSpeed(720L);
        this.setAddDamage(20L);         // 팬텀 블로우-리인포스
        this.addIgnoreDefenseList(20L); // 팬텀 블로우-이그노어 가드
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(0.85);           // 미러 이미징
    }
}
