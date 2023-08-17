package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SuperFistEnrageShockWave extends AttackSkill {
    public SuperFistEnrageShockWave() {
        this.setName("슈퍼 피스트 인레이지(충격파)");
        this.setAttackCount(10L);
        this.setDamage(455.0);
        this.setApplyFinalAttack(true);
        this.setAddDamage(20 + 20L);    // 암살-리인포스, 보스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
