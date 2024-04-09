package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PowerStomp extends AttackSkill implements BetaSkill {
    public PowerStomp() {
        this.setName("어드밴스드 파워 스텀프");
        this.setAttackCount(9L);
        this.setDamage(335.0);
        this.setDelayByAttackSpeed(750L);
        this.setRelatedSkill(new PowerStompShockWave());
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
