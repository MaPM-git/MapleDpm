package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritIncarnation extends AttackSkill {
    public SpiritIncarnation() {
        this.setName("정령의 화신");
        this.setDamage(700.0);
        this.setAttackCount(1L);
        this.setDotDuration(3000L);
        this.setInterval(360L);
        this.setLimitAttackCount(8L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
