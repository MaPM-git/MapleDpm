package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SeaWave extends AttackSkill {
    public SeaWave() {
        this.setName("해파");
        this.setAttackCount(4L);
        this.setDamage(190.0 + 102);        // 윈드 부스터
        this.setCooldown(12.0);
        this.addFinalDamage(4.0);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
