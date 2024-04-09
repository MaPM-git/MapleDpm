package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PowerStompShockWave extends AttackSkill implements BetaSkill {
    public PowerStompShockWave() {
        this.setName("어드밴스드 파워 스텀프(충격파)");
        this.setAttackCount(9L);
        this.setDamage(335.0);
        this.setDelayByAttackSpeed(30L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(960L);
    }
}
