package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HammerSmashJump extends AttackSkill {
    public HammerSmashJump() {
        this.setName("해머 스매시(점프)");
        this.setDelay(75L);
        this.setAttackCount(6L + 2);    // 펀치-보너스 어택
        this.setDamage(477.0);
        this.setAddDamage(10L);         // 펀치-리인포스
        this.addIgnoreDefenseList(20L); // 펀치-이그노어 가드
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
